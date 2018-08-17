package org.lushen.zhuifeng.wechat.v1;

import org.lushen.zhuifeng.wechat.WechatApi;
import org.lushen.zhuifeng.wechat.WechatException;
import org.lushen.zhuifeng.wechat.WechatSupport;
import org.lushen.zhuifeng.wechat.v1.response.ip.CallbackipResponse;

/**
 * 获取微信服务器IP地址接口
 * 
 * @author hlm
 */
@WechatApi
public class CallbackipWechatApi extends WechatSupport {

	/**
	 * 获取微信服务器IP地址
	 * 
	 * @param access_token
	 * @return
	 * @throws WechatException 
	 */
	public CallbackipResponse getCallbackip(String access_token) throws WechatException {
		try {
			String url = loadAndFormatResource("{callbackip_get_url}", access_token);
			byte[] bytes = doHttpGet(url);
			return fromJson2JavaObject(bytes, CallbackipResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

}
