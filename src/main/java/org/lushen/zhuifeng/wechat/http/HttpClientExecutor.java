package org.lushen.zhuifeng.wechat.http;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.lushen.zhuifeng.wechat.utils.CloseableUtils;
import org.lushen.zhuifeng.wechat.utils.ReleaseUtils;

/**
 * apache http client 执行器
 * 
 * @author hlm
 */
public class HttpClientExecutor implements HttpExecutor {

	@Override
	public byte[] doHttpGet(String url) throws HttpException {
		HttpGet httpGet = new HttpGet(url);
		return doHttp(httpGet);
	}

	@Override
	public byte[] doHttpPost(String url, Map<String, Object> formDatas) throws HttpException {
		HttpPost httpPost = new HttpPost(url);
		if(MapUtils.isNotEmpty(formDatas)) {
			MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
			for(Entry<String, Object> entry :  formDatas.entrySet()) {
				String name = entry.getKey();
				Object value = entry.getValue();
				if(value instanceof File) {
					multipartEntityBuilder.addBinaryBody(name, (File)value);
				}
				else if(value instanceof byte[]) {
					multipartEntityBuilder.addBinaryBody(name, (byte[])value);
				}
				else if(value instanceof InputStream) {
					multipartEntityBuilder.addBinaryBody(name, (InputStream) value);
				}
				else {
					multipartEntityBuilder.addTextBody(name, value.toString());
				}
				httpPost.setEntity(multipartEntityBuilder.build());
			}
		}
		return doHttp(httpPost);
	}

	@Override
	public byte[] doHttpPost(String url, String data) throws HttpException {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(data, Charset.defaultCharset().displayName()));
		return doHttp(httpPost);
	}

	/**
	 * 执行http事务
	 * 
	 * @param httpRequestBase
	 * @return
	 * @throws HttpException
	 */
	private final byte[] doHttp(HttpRequestBase httpRequestBase) throws HttpException {

		CloseableHttpClient httpclient = HttpClients.createDefault();

		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		InputStream inputStream = null;
		try {

			//超时配置
			Builder builder = RequestConfig.custom();
			builder.setConnectionRequestTimeout(30*1000);
			builder.setSocketTimeout(30*1000);
			builder.setConnectTimeout(30*1000);
			RequestConfig config = builder.build();
			httpRequestBase.setConfig(config);

			response = httpclient.execute(httpRequestBase);

			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode != HttpStatus.SC_OK) {
				throw new RuntimeException("HTTP error code :: " + statusCode);
			}
			entity = response.getEntity();
			inputStream = entity.getContent();
			return IOUtils.toByteArray(inputStream);

		} catch (Throwable e) {

			throw new HttpException("Http request fail. url = " + httpRequestBase.getURI(), e);

		} finally {

			ReleaseUtils.nonBreakRelease(entity, EntityUtils::consume);
			CloseableUtils.close(inputStream, response, httpclient);

		}
	}

}
