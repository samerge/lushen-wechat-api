package org.lushen.zhuifeng.wechat.test;

import org.lushen.zhuifeng.wechat.WechatException;
import org.lushen.zhuifeng.wechat.v1.AccessTokenWechatApi;
import org.lushen.zhuifeng.wechat.v1.parameter.secret.AccessTokenParameter;
import org.lushen.zhuifeng.wechat.v1.response.secret.AccessTokenResponse;

public class TestAccessToken {

	public static void main(String[] args) throws WechatException {

		AccessTokenWechatApi wechatApi = new AccessTokenWechatApi();

		AccessTokenParameter parameter = new AccessTokenParameter("appid", "secret");
		AccessTokenResponse response = wechatApi.getAccessToken(parameter);

		System.out.println(response.toJsonString());
	}

}
