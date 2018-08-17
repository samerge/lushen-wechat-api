package org.lushen.zhuifeng.wechat.v1.response.userinfo;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取用户列表	响应对象
 * 
 * @author hlm
 */
@Getter
@Setter
public class UserOpenidListResponse extends SimpleResponse {

	private int total;

	private int count;

	private OpenidListData data;

	private String next_openid;

	@Getter
	@Setter
	public static class OpenidListData {

		private String[] openid;

	}

}
