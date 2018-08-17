package org.lushen.zhuifeng.wechat.v1.response.userinfo;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取微信请求关注用户信息响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class UserinfoGetResponse extends SimpleResponse {

	private int subscribe;

	private String openid;

	private String nickname;

	private int sex;

	private String language;

	private String city;

	private String province;

	private String country;

	private String headimgurl;

	private int subscribe_time;

	private String unionid;

	private String remark;

	private int groupid;

	private int[] tagid_list;

}
