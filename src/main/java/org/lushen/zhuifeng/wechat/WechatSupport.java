package org.lushen.zhuifeng.wechat;

import static org.lushen.zhuifeng.wechat.WechatDefaultProperties.getDefaultHttpExecutor;
import static org.lushen.zhuifeng.wechat.WechatDefaultProperties.getDefaultMessageConverter;
import static org.lushen.zhuifeng.wechat.WechatDefaultProperties.getDefaultResourceResolver;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lushen.zhuifeng.wechat.conveter.MessageConverter;
import org.lushen.zhuifeng.wechat.http.HttpException;
import org.lushen.zhuifeng.wechat.http.HttpExecutor;
import org.lushen.zhuifeng.wechat.resource.ResourceResolver;

/**
 * 微信api支持定义，抽取的公共实现
 * 
 * @author hlm
 */
public abstract class WechatSupport implements HttpExecutor, ResourceResolver, MessageConverter {

	protected final Log log = LogFactory.getLog(getClass());
	private HttpExecutor httpExecutor = getDefaultHttpExecutor();
	private ResourceResolver resourceResolver = getDefaultResourceResolver();
	private MessageConverter messageConverter = getDefaultMessageConverter();

	/**
	 * 设置当前的资源加载处理器
	 * 
	 * @param resourceResolver
	 */
	public void setResourceResolver(ResourceResolver resourceResolver) {
		this.resourceResolver = resourceResolver;
	}

	/**
	 * 设置当前的http执行器
	 * 
	 * @param httpExecutor
	 */
	public void setHttpExecutor(HttpExecutor httpExecutor) {
		this.httpExecutor = httpExecutor;
	}

	/**
	 * 设置当前的消息转换器
	 * 
	 * @param messageConverter
	 */
	public void setMessageConverter(MessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}

	@Override
	public String loadResource(String name) {
		return this.resourceResolver.loadResource(name);
	}

	@Override
	public String loadAndFormatResource(String name, Object... args) {
		return this.resourceResolver.loadAndFormatResource(name, args);
	}

	@Override
	public byte[] doHttpGet(String url) throws HttpException {
		return this.httpExecutor.doHttpGet(url);
	}

	@Override
	public byte[] doHttpPost(String url, Map<String, Object> formDatas) throws HttpException {
		return this.httpExecutor.doHttpPost(url, formDatas);
	}

	@Override
	public byte[] doHttpPost(String url, String data) throws HttpException {
		return this.httpExecutor.doHttpPost(url, data);
	}

	@Override
	public String fromObject2JsonString(Object arg) {
		return this.messageConverter.fromObject2JsonString(arg);
	}

	@Override
	public <T> T fromJson2JavaObject(byte[] json, Class<T> cls) {
		return this.messageConverter.fromJson2JavaObject(json, cls);
	}

	@Override
	public String fromObject2XmlString(Object arg) {
		return this.messageConverter.fromObject2XmlString(arg);
	}

	@Override
	public <T> T fromXml2JavaObject(byte[] xml, Class<T> cls) {
		return this.messageConverter.fromXml2JavaObject(xml, cls);
	}

}
