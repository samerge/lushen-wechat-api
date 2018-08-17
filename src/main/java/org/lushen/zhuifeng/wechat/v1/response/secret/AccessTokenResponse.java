package org.lushen.zhuifeng.wechat.v1.response.secret;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取access token接口响应
 * 
 * @author hlm
 */
@Getter
@Setter
public class AccessTokenResponse extends SimpleResponse {

	private String access_token;

	private int expires_in;

}

