package org.lushen.zhuifeng.wechat.v1;

import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.lushen.zhuifeng.wechat.WechatApi;
import org.lushen.zhuifeng.wechat.WechatException;
import org.lushen.zhuifeng.wechat.WechatSupport;
import org.lushen.zhuifeng.wechat.v1.parameter.qrcode.QrcodeCreateParameter;
import org.lushen.zhuifeng.wechat.v1.response.qrcode.QrcodeCreateResponse;

/**
 * 二维码接口
 *
 * @author hlm
 */
@WechatApi
public class QrcodeWechatApi extends WechatSupport {

	/**
	 * 创建二维码ticket
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public QrcodeCreateResponse createQrcode(String access_token, QrcodeCreateParameter parameter) throws WechatException {
		try {
			String url = loadAndFormatResource("{qrcode_create_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, QrcodeCreateResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 通过ticket换取二维码
	 * 
	 * @Param ticket
	 * @return byte[] 二维码图片byte[]
	 * @throws WechatException 
	 */
	public byte[] downloadQrcode(final String ticket) throws WechatException {
		try {
			String url = loadAndFormatResource("{qrcode_download_url}", URLEncoder.encode(ticket, Charset.defaultCharset().displayName()));
			return doHttpGet(url);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

}
