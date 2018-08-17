package org.lushen.zhuifeng.wechat.resource;

/**
 * 默认的资源格式化实现
 * 
 * @author hlm
 */
public class DefaultResourceFormater implements ResourceFormater {

	@Override
	public String format(String resource, Object... args) {
		return String.format(resource, args);
	}

}
