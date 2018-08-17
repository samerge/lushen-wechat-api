package org.lushen.zhuifeng.wechat.http;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.lushen.zhuifeng.wechat.utils.CloseableUtils;
import org.lushen.zhuifeng.wechat.utils.ReleaseUtils;

/**
 * 默认的http执行器，使用{@link HttpURLConnection}
 * 
 * @author hlm
 */
public class DefaultHttpExecutor implements HttpExecutor {

	@Override
	public byte[] doHttpGet(String url) throws HttpException {

		HttpURLConnection connection = null;
		InputStream inputStream = null;
		try {

			connection = createHttpURLConnection(url, "GET");
			connection.connect();

			int statusCode = connection.getResponseCode();
			if(statusCode != HttpStatus.SC_OK) {
				throw new RuntimeException("HTTP error code :: " + statusCode);
			}

			inputStream = connection.getInputStream();
			return IOUtils.toByteArray(inputStream);

		} catch (Throwable e) {
			throw new HttpException("Http request fail. url = " + url, e);
		} finally {
			CloseableUtils.close(inputStream);
			ReleaseUtils.nonBreakRelease(connection, e -> e.disconnect());
		}
	}

	@Override
	public byte[] doHttpPost(String url, Map<String, Object> formDatas) throws HttpException {

		HttpURLConnection connection = null;
		InputStream inputStream = null;
		try {

			connection = createHttpURLConnection(url, "POST");

			//写出表单参数
			if(formDatas != null && ! formDatas.isEmpty()) {
				OutputStream out = connection.getOutputStream();
				String boundary = "---------------------------"+System.currentTimeMillis();
				for(Entry<String, Object> entry : formDatas.entrySet()) {

					String name = entry.getKey();
					byte[] bytes = null;
					String fileName = "";
					boolean octetStream = false;

					Object value = entry.getValue();
					if(value instanceof File) {
						File file = (File)value;
						bytes = FileUtils.readFileToByteArray(file);
						fileName = file.getName();
					}
					else if(value instanceof InputStream) {
						bytes = IOUtils.toByteArray((InputStream)value);
					}
					else if(value instanceof byte[]) {
						bytes = (byte[])value;
					}
					else {
						bytes = value.toString().getBytes();
					}

					if(octetStream) {
						out.write(("\r\n--"+boundary+"\r\n").getBytes());
						out.write(("Content-Disposition: form-data; name=\""+name+"\"; filename=\"" + fileName + "\"\r\n").getBytes());
						out.write(("Content-Type: application/octet-stream\r\n\r\n").getBytes());
						out.write(bytes);
						out.write(("\r\n--" + boundary + "--\r\n").getBytes());
					} else {
						out.write(("\r\n--"+boundary+"\r\n").getBytes());
						out.write(("Content-Disposition: form-data; name=\""+name+"\"\r\n\r\n").getBytes());
						out.write(value.toString().getBytes());
						out.write(("\r\n--" + boundary + "--\r\n").getBytes());
					}
				}
			}

			int statusCode = connection.getResponseCode();
			if(statusCode != HttpStatus.SC_OK) {
				throw new RuntimeException("HTTP error code :: " + statusCode);
			}

			inputStream = connection.getInputStream();
			return IOUtils.toByteArray(inputStream);

		} catch (Throwable e) {
			throw new HttpException("Http request fail. url = " + url, e);
		} finally {
			CloseableUtils.close(inputStream);
			ReleaseUtils.nonBreakRelease(connection, e -> e.disconnect());
		}
	}

	@Override
	public byte[] doHttpPost(String url, String data) throws HttpException {
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		try {
			connection = createHttpURLConnection(url, "POST");

			OutputStream out = connection.getOutputStream();
			try {
				out.write(data.getBytes());
				out.flush();
			} finally {
				CloseableUtils.close(out);
			}

			int statusCode = connection.getResponseCode();
			if(statusCode != HttpStatus.SC_OK) {
				throw new RuntimeException("HTTP error code :: " + statusCode);
			}
			inputStream = connection.getInputStream();
			return IOUtils.toByteArray(inputStream);
		} catch (Throwable e) {
			throw new HttpException("Http request fail. url = " + url, e);
		} finally {
			CloseableUtils.close(inputStream);
			ReleaseUtils.nonBreakRelease(connection, e -> e.disconnect());
		}
	}

	/**
	 * 创建连接对象
	 * 
	 * @param url
	 * @param method
	 * @return
	 * @throws Exception
	 */
	private final HttpURLConnection createHttpURLConnection(String url, String method) throws Exception {

		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod(method);
		conn.setConnectTimeout(15*1000);
		conn.setReadTimeout(60*1000);

		if(StringUtils.startsWithIgnoreCase(url, "https")) {
			TrustManager[] trustManagers = {new X509TrustManager(){
				public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
				public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
				public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
			}};
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, trustManagers, new java.security.SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			((HttpsURLConnection)conn).setSSLSocketFactory(ssf);
		}

		return conn;
	}

}
