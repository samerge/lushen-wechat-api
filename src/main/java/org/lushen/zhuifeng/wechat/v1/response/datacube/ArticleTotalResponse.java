package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取图文群发总数据响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class ArticleTotalResponse extends SimpleResponse {

	private List<ArticleTotal> list;

	@Getter
	@Setter
	public static final class ArticleTotal {

		private String ref_date;

		private String msgid;

		private String title;

		private List<Details> details;

	}

	@Getter
	@Setter
	public static final class Details {

		private String stat_date;

		private int target_user;

		private int int_page_read_user;

		private int int_page_read_count;

		private int ori_page_read_user;

		private int ori_page_read_count;

		private int share_user;

		private int share_count;

		private int add_to_fav_user;

		private int add_to_fav_count;

		private int int_page_from_session_read_user;

		private int int_page_from_session_read_count;

		private int int_page_from_hist_msg_read_user;

		private int int_page_from_hist_msg_read_count;

		private int int_page_from_feed_read_user;

		private int int_page_from_feed_read_count;

		private int int_page_from_friends_read_user;

		private int int_page_from_friends_read_count;

		private int int_page_from_other_read_user;

		private int int_page_from_other_read_count;

		private int feed_share_from_session_user;

		private int feed_share_from_session_cnt;

		private int feed_share_from_feed_user;

		private int feed_share_from_feed_cnt;

		private int feed_share_from_other_user;

		private int feed_share_from_other_cnt;

	}

}

