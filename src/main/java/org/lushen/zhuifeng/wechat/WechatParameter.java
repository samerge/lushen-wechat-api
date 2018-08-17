package org.lushen.zhuifeng.wechat;

import static org.lushen.zhuifeng.wechat.WechatDefaultProperties.getDefaultMessageConverter;

/**
 * 微信接口参数
 * 
 * @author hlm
 */
public interface WechatParameter {

	/**
	 * 转换参数为json字符串
	 * 
	 * @return
	 */
	default String toJsonString() {
		return getDefaultMessageConverter().fromObject2JsonString(this);
	}

	/**
	 * 转换参数为xml字符串
	 * 
	 * @return
	 */
	default String toXmlString() {
		return getDefaultMessageConverter().fromObject2XmlString(this);
	}

}
