package org.lushen.zhuifeng.wechat.conveter;

/**
 * 转换器接口
 * 
 * @author hlm
 */
public interface MessageConverter {

	/**
	 * 转换Java对象为json字符串
	 * 
	 * @param arg
	 * @return
	 */
	String fromObject2JsonString(Object arg);

	/**
	 * 转换json字符串为java对象
	 * 
	 * @param json
	 * @param cls
	 * @return
	 */
	<T> T fromJson2JavaObject(byte[] json, Class<T> cls);

	/**
	 * 转换Java对象为xml字符串
	 * 
	 * @param arg
	 * @return
	 */
	String fromObject2XmlString(Object arg);

	/**
	 * 转换xml字符串为java对象
	 * 
	 * @param xml
	 * @param cls
	 * @return
	 */
	<T> T fromXml2JavaObject(byte[] xml, Class<T> cls);

}
