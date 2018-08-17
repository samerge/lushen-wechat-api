package org.lushen.zhuifeng.wechat.spring;

import org.lushen.zhuifeng.wechat.WechatDefaultProperties;
import org.lushen.zhuifeng.wechat.conveter.MessageConverter;
import org.lushen.zhuifeng.wechat.http.HttpExecutor;
import org.lushen.zhuifeng.wechat.resource.ResourceResolver;
import org.springframework.beans.factory.InitializingBean;

/**
 * spring 微信配置项全局配置中心
 * 
 * @author hlm
 */
public class SpringWechatApiGolbalConfigurer implements InitializingBean {

	private MessageConverter messageConverter;

	private HttpExecutor httpExecutor;

	private ResourceResolver resourceResolver;

	@Override
	public void afterPropertiesSet() throws Exception {
		if(this.messageConverter != null) {
			WechatDefaultProperties.setDefaultMessageConverter(this.messageConverter);
		}
		if(this.httpExecutor != null) {
			WechatDefaultProperties.setDefaultHttpExecutor(this.httpExecutor);
		}
		if(this.resourceResolver != null) {
			WechatDefaultProperties.setDefaultResourceResolver(this.resourceResolver);
		}
	}

	public void setMessageConverter(MessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}

	public void setHttpExecutor(HttpExecutor httpExecutor) {
		this.httpExecutor = httpExecutor;
	}

	public void setResourceResolver(ResourceResolver resourceResolver) {
		this.resourceResolver = resourceResolver;
	}

}
