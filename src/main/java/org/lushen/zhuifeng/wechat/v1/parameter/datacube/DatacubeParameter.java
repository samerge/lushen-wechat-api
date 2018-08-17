package org.lushen.zhuifeng.wechat.v1.parameter.datacube;

import org.lushen.zhuifeng.wechat.WechatParameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 数据统计接口参数对象
 *
 * @author hlm
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class DatacubeParameter implements WechatParameter  {

	private String begin_date;

	private String end_date;

}

