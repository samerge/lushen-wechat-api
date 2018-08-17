package org.lushen.zhuifeng.wechat.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lushen.zhuifeng.wechat.WechatException;
import org.lushen.zhuifeng.wechat.v1.AccessTokenWechatApi;
import org.lushen.zhuifeng.wechat.v1.parameter.secret.AccessTokenParameter;
import org.lushen.zhuifeng.wechat.v1.response.secret.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestWechat {

	@Autowired
	private AccessTokenWechatApi accessTokenWechatApi;

	@Test
	public void test() {
		try {
			AccessTokenParameter parameter = new AccessTokenParameter("appid", "secret");
			AccessTokenResponse response = accessTokenWechatApi.getAccessToken(parameter);
			System.out.println(response.toJsonString());
		} catch (WechatException e) {
			e.printStackTrace();
		}
	}

}
