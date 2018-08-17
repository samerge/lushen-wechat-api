package org.lushen.zhuifeng.wechat.v1.response.userinfo;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 批量获取用户基本信息  响应对象
 * 
 * @author hlm
 */
@Getter
@Setter
public class UserinfoListGetResponse extends SimpleResponse {

	private List<SubcribeUserinfo> user_info_list;

	@Getter
	@Setter
	public static class SubcribeUserinfo {

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

}
