package org.lushen.zhuifeng.wechat.v1.response.datacube;

import java.util.List;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口分析数据接口响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class InterfaceSummaryResponse extends SimpleResponse {

	private List<InterfaceSummary> list;

	@Getter
	@Setter
	public static final class InterfaceSummary {

		private String ref_date;

		private int callback_count;

		private int fail_count;

		private int total_time_cost;

		private int max_time_cost;

	}

}

