package org.lushen.zhuifeng.wechat.v1.response.oauth2;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 通过code换取网页授权access_token  响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class Oauth2Response extends SimpleResponse {

	private String access_token;

	private int expires_in;

	private String refresh_token;

	private String openid;

	private String scope;

}
