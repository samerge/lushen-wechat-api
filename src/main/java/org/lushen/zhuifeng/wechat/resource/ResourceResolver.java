package org.lushen.zhuifeng.wechat.resource;

/**
 * 资源加载处理接口
 * 
 * @author hlm
 */
public interface ResourceResolver {

	/**
	 * 加载获取资源
	 * 
	 * @param name
	 * @return
	 * @throws ResouceException
	 */
	String loadResource(String name);

	/**
	 * 加载获取，并格式化资源
	 * 
	 * @param name
	 * @param args
	 * @return
	 * @throws ResouceException
	 */
	String loadAndFormatResource(String name, Object... args);

}
