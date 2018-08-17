package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取图文群发每日数据响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class ArticleSummaryResponse extends SimpleResponse {

	private List<ArticleSummary> list;

	@Getter
	@Setter
	public static final class ArticleSummary {

		private String ref_date;

		private String msgid;

		private String title;

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

