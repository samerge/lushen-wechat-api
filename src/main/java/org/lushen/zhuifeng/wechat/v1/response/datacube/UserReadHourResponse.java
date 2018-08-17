package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取图文统计分时数据响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class UserReadHourResponse extends SimpleResponse  {

	private List<UserReadHour> list;

	@Getter
	@Setter
	public static final class UserReadHour {

		private String ref_date;

		private int ref_hour;

		private int user_source;

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
