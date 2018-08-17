package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 消息发送周数据接口响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class UpStreamMsgWeekResponse extends SimpleResponse  {

	private List<UpStreamMsgWeek> list;

	@Getter
	@Setter
	public static final class UpStreamMsgWeek {

		private String ref_date;

		private int msg_type;

		private int msg_user;

		private int msg_count;

	}

}
