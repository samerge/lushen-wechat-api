package org.lushen.zhuifeng.wechat.conveter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 默认的转换器，使用jackson转换
 * 
 * @author hlm
 */
public final class DefaultMessageConveter implements MessageConverter {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	private static final XmlMapper xmlMapper = new XmlMapper();

	/**
	 * 转换Java对象为json字符串
	 * 
	 * @param arg
	 * @return
	 */
	@Override
	public String fromObject2JsonString(Object arg) {
		try {
			return objectMapper.writeValueAsString(arg);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 转换json字符串为java对象
	 * 
	 * @param json
	 * @param cls
	 * @return
	 */
	@Override
	public <T> T fromJson2JavaObject(byte[] json, Class<T> cls) {
		try {
			return objectMapper.readValue(json, cls);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 转换Java对象为xml字符串
	 * 
	 * @param arg
	 * @return
	 */
	@Override
	public String fromObject2XmlString(Object arg) {
		try {
			return xmlMapper.writeValueAsString(arg);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 转换xml字符串为java对象
	 * 
	 * @param xml
	 * @param cls
	 * @return
	 */
	@Override
	public <T> T fromXml2JavaObject(byte[] xml, Class<T> cls) {
		try {
			return xmlMapper.readValue(xml, cls);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
