package org.lushen.zhuifeng.wechat.v1;

import org.lushen.zhuifeng.wechat.WechatApi;
import org.lushen.zhuifeng.wechat.WechatException;
import org.lushen.zhuifeng.wechat.WechatSupport;
import org.lushen.zhuifeng.wechat.v1.parameter.url.ShortUrlParameter;
import org.lushen.zhuifeng.wechat.v1.response.url.ShortUrlResponse;

/**
 * 长链接转换短链接Api
 * 
 * @author hlm
 */
@WechatApi
public class ConvertUrlWechatApi extends WechatSupport {

	/**
	 * 长链接转短链接
	 * 
	 * @param access_token
	 * @param long_url
	 * @return
	 * @throws WechatException 
	 */
	public ShortUrlResponse getShortUrl(String access_token, String long_url) throws WechatException {
		return getShortUrl(access_token, new ShortUrlParameter(long_url));
	}

	/**
	 * 长链接转短链接
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException 
	 */
	public ShortUrlResponse getShortUrl(String access_token, ShortUrlParameter parameter) throws WechatException {
		try {
			String url = loadAndFormatResource("{shorturl_get_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, ShortUrlResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

}
