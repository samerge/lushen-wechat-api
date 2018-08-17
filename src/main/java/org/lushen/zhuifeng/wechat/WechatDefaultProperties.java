package org.lushen.zhuifeng.wechat;

import java.util.function.Supplier;

import org.lushen.zhuifeng.wechat.conveter.DefaultMessageConveter;
import org.lushen.zhuifeng.wechat.conveter.MessageConverter;
import org.lushen.zhuifeng.wechat.http.DefaultHttpExecutor;
import org.lushen.zhuifeng.wechat.http.HttpClientExecutor;
import org.lushen.zhuifeng.wechat.http.HttpExecutor;
import org.lushen.zhuifeng.wechat.resource.PropertiesResourceResolver;
import org.lushen.zhuifeng.wechat.resource.ResourceResolver;

/**
 * 默认配置项
 * 
 * @author hlm
 */
public final class WechatDefaultProperties {

	private static final String defaultResourcePath = "/org.lushen.zhuifeng.wechat.api.v1.url.properties";

	private static ResourceResolver defaultResourceResolver = new PropertiesResourceResolver(defaultResourcePath);

	private static MessageConverter defaultMessageConverter = new DefaultMessageConveter();

	private static HttpExecutor defaultHttpExecutor = ((Supplier<HttpExecutor>)() -> {
		//尝试使用apache http client
		try {
			return new HttpClientExecutor();
		} catch (Throwable e) {
			return new DefaultHttpExecutor();
		}
	}).get();

	/**
	 * 设置默认的全局资源加载解析器
	 * 
	 * @param defaultResourceResolver
	 */
	public static void setDefaultResourceResolver(ResourceResolver defaultResourceResolver) {
		if(defaultResourceResolver != null) {
			WechatDefaultProperties.defaultResourceResolver = defaultResourceResolver;
		}
	}

	/**
	 * 设置默认的全局转换器
	 * 
	 * @param defaultMessageConverter
	 */
	public static void setDefaultMessageConverter(MessageConverter defaultMessageConverter) {
		if(defaultMessageConverter != null) {
			WechatDefaultProperties.defaultMessageConverter = defaultMessageConverter;
		}
	}

	/**
	 * 设置默认的全局http执行器
	 * 
	 * @param defaultHttpExecutor
	 */
	public static void setDefaultHttpExecutor(HttpExecutor defaultHttpExecutor) {
		if(defaultHttpExecutor != null) {
			WechatDefaultProperties.defaultHttpExecutor = defaultHttpExecutor;
		}
	}

	/**
	 * 获取默认的全局资源加载解析器
	 * 
	 * @return
	 */
	public static MessageConverter getDefaultMessageConverter() {
		return defaultMessageConverter;
	}

	/**
	 * 获取默认的全局转换器
	 * 
	 * @return
	 */
	public static ResourceResolver getDefaultResourceResolver() {
		return defaultResourceResolver;
	}

	/**
	 * 获取默认的全局http执行器
	 * 
	 * @return
	 */
	public static HttpExecutor getDefaultHttpExecutor() {
		return defaultHttpExecutor;
	}

}
