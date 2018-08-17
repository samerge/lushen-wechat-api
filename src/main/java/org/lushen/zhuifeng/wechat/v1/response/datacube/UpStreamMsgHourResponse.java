package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 消息分送分时数据响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class UpStreamMsgHourResponse extends SimpleResponse {

	private List<UpStreamMsgHour> list;

	@Getter
	@Setter
	public static final class UpStreamMsgHour {

		private String ref_date;

		private int ref_hour;

		private int msg_type;

		private int msg_user;

		private int msg_count;

	}

}
