package org.lushen.zhuifeng.wechat.v1.response.oauth2;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 拉取授权跳转用户的信息响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class Oauth2UserinfoResponse extends SimpleResponse {

	private String openid;

	private String nickname;

	private int sex;

	private String province;

	private String city;

	private String country;

	private String headimgurl;

	private String[] privilege;

	private String unionid;

}
