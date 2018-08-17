package org.lushen.zhuifeng.wechat.v1;

import org.lushen.zhuifeng.wechat.WechatApi;
import org.lushen.zhuifeng.wechat.WechatException;
import org.lushen.zhuifeng.wechat.WechatSupport;
import org.lushen.zhuifeng.wechat.v1.parameter.secret.AccessTokenParameter;
import org.lushen.zhuifeng.wechat.v1.response.secret.AccessTokenResponse;

/**
 * 微信access token接口
 * 
 * @author hlm
 */
@WechatApi
public class AccessTokenWechatApi extends WechatSupport {

	/**
	 * 获取微信access token
	 * 
	 * @param parameter
	 * @return
	 * @throws WechatException 
	 */
	public AccessTokenResponse getAccessToken(AccessTokenParameter parameter) throws WechatException {
		return getAccessToken(parameter.getAppid(), parameter.getSecret());
	}

	/**
	 * 获取微信access token
	 * 
	 * @param appid
	 * @param secret
	 * @return
	 * @throws WechatException 
	 */
	public AccessTokenResponse getAccessToken(String appid, String secret) throws WechatException {
		try {
			String url = loadAndFormatResource("{accesstoken_get_url}", appid, secret);
			byte[] bytes = doHttpGet(url);
			return fromJson2JavaObject(bytes, AccessTokenResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

}
