package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取用户增减数据响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class UserSummaryResponse extends SimpleResponse  {

	private List<UserSummary> list;

	@Getter
	@Setter
	public static final class UserSummary {

		private String ref_date;

		private String user_source;

		private String new_user;

		private String cancel_user;

	}

}
