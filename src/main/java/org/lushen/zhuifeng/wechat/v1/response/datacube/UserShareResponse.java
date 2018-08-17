package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取图文分享转发数据响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class UserShareResponse extends SimpleResponse  {

	private List<UserShare> list;

	@Getter
	@Setter
	public static final class UserShare {

		private String ref_date;

		private int share_scene;

		private int share_count;

		private int share_user;

	}

}
