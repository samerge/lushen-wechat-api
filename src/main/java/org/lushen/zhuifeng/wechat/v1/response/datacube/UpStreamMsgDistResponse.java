package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 消息发送分布数据接口响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class UpStreamMsgDistResponse extends SimpleResponse {

	private List<UpStreamMsgDist> list;

	@Getter
	@Setter
	public static final class UpStreamMsgDist {

		private String ref_date;

		private int count_interval;

		private int msg_user;

	}

}
