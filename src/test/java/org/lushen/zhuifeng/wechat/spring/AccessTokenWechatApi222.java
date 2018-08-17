package org.lushen.zhuifeng.wechat.spring;

import org.lushen.zhuifeng.wechat.WechatApi;
import org.lushen.zhuifeng.wechat.WechatException;
import org.lushen.zhuifeng.wechat.WechatSupport;
import org.lushen.zhuifeng.wechat.v1.AccessTokenWechatApi;
import org.lushen.zhuifeng.wechat.v1.parameter.secret.AccessTokenParameter;
import org.lushen.zhuifeng.wechat.v1.response.secret.AccessTokenResponse;

@WechatApi
public class AccessTokenWechatApi222 extends WechatSupport {
	
	private final AccessTokenWechatApi wechatApi = new AccessTokenWechatApi();

	public AccessTokenResponse getAccessToken(AccessTokenParameter parameter) throws WechatException {
		System.out.println("========================================================");
		return wechatApi.getAccessToken(parameter);
	}

	public AccessTokenResponse getAccessToken(String appid, String secret) throws WechatException {
		System.out.println("========================================================");
		return wechatApi.getAccessToken(appid, secret);
	}

}
