package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口分析分时数据接口响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class InterfaceSummaryHourResponse extends SimpleResponse {

	private List<InterfaceSummaryHour> list;

	@Getter
	@Setter
	public static final class InterfaceSummaryHour {

		private String ref_date;

		private int ref_hour;

		private int callback_count;

		private int fail_count;

		private int total_time_cost;

		private int max_time_cost;

	}

}
