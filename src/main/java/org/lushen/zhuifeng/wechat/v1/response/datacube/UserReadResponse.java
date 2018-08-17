package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取图文统计数据响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class UserReadResponse extends SimpleResponse  {

	private List<UserRead> list;

	@Getter
	@Setter
	public static final class UserRead {

		private String ref_date;

		private int int_page_read_user;

		private int int_page_read_count;

		private int ori_page_read_user;

		private int ori_page_read_count;

		private int share_user;

		private int share_count;

		private int add_to_fav_user;

		private int add_to_fav_count;

	}

}
