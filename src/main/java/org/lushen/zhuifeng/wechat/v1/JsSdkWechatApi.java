package org.lushen.zhuifeng.wechat.v1;

import org.lushen.zhuifeng.wechat.WechatApi;
import org.lushen.zhuifeng.wechat.WechatException;
import org.lushen.zhuifeng.wechat.WechatSupport;
import org.lushen.zhuifeng.wechat.v1.parameter.jssdk.JsSdkType;
import org.lushen.zhuifeng.wechat.v1.response.jssdk.JsSdkResponse;

/**
 * js sdk接口
 * 
 * @author hlm
 */
@WechatApi
public final class JsSdkWechatApi extends WechatSupport {

	/**
	 * js sdk ticket接口
	 * 
	 * @param access_token
	 * @param type
	 * @return
	 * @throws WechatException
	 */
	public JsSdkResponse getJssdkTicket(final String access_token, final JsSdkType type) throws WechatException {
		try{
			String url = loadAndFormatResource("{jssdk_ticket_url}", access_token, type);
			byte[] bytes = doHttpGet(url);
			return fromJson2JavaObject(bytes, JsSdkResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

}
