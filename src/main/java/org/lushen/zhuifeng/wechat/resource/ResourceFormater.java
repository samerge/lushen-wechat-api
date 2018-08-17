package org.lushen.zhuifeng.wechat.resource;

/**
 * 资源格式化接口
 * 
 * @author hlm
 */
public interface ResourceFormater {

	/**
	 * 格式化
	 * 
	 * @param resource
	 * @param args
	 * @return
	 */
	String format(String resource, Object... args);

}
