package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取累计用户数据响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class UserCumulateResponse extends SimpleResponse {

	private List<UserCumulate> list;

	@Getter
	@Setter
	public static final class UserCumulate {

		private String ref_date;

		private String cumulate_user;

		private String user_source;

	}

}
