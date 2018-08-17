# lushen-wechat-api

微信公众号接口api工具类

#### 简介
	
	一个简单的微信Api项目，使用相对优雅的方式去实现。
	
	基于jdk1.8，返璞归真，并无复杂的代码和逻辑。
	
	基于lombok，可选择性地使用getter、setter等lombok注解，省略生成getter和setter方法，类属性一目了然。

#### 普通方式

	使用示例：
		
		AccessTokenParameter parameter = new AccessTokenParameter("appid", "secret");
		AccessTokenResponse response = new AccessTokenWechatApi().getAccessToken(parameter);
		System.out.println(response.getErrcode());
		System.out.println(response.getErrmsg());
		
	覆盖全局配置：
		
		WechatDefaultProperties.setDefaultResourceResolver(ResourceResolver);
		WechatDefaultProperties.setDefaultMessageConverter(MessageConverter);
		WechatDefaultProperties.setDefaultHttpExecutor(HttpExecutor);
		
	覆盖实例配置：
		
		AccessTokenWechatApi wechatApi = new AccessTokenWechatApi();
		wechatApi.setResourceResolver(ResourceResolver);
		wechatApi.setMessageConverter(MessageConverter);
		wechatApi.setHttpExecutor(HttpExecutor);

#### spring方式
	
	添加扫描器配置：
		
		<bean class="org.lushen.zhuifeng.wechat.spring.SpringWechatApiBeanScanner"/>
		
	或者指定配置：
		
		<bean class="org.lushen.zhuifeng.wechat.v1.AccessTokenWechatApi"/>
		<bean class="org.lushen.zhuifeng.wechat.v1.CallbackipWechatApi"/>
		<bean class="org.lushen.zhuifeng.wechat.v1.ConvertUrlWechatApi"/>
		
	注入调用示例:
		
		...
		
		@Autowired
		private AccessTokenWechatApi accessTokenWechatApi;
		
		public void test() {
			AccessTokenParameter parameter = new AccessTokenParameter("appid", "secret");
			AccessTokenResponse response = accessTokenWechatApi.getAccessToken(parameter);
			System.out.println(response.getErrcode());
			System.out.println(response.getErrmsg());
		}
		
	覆盖全局配置：
		
		<bean class="org.lushen.zhuifeng.wechat.spring.SpringWechatApiGolbalConfigurer">
			<property name="messageConverter" class="....">
			<property name="httpExecutor" class="....">
			<property name="resourceResolver" class="....">
		</bean>

#### api扩展

	1，自定义实现类继承org.lushen.zhuifeng.wechat.WechatSupport
	
	2，添加@WechatApi注解
	
	3，使用lombok定义参数对象，继承org.lushen.zhuifeng.wechat.WechatParameter
	
	4，使用lombok定义响应对象，继承org.lushen.zhuifeng.wechat.WechatResponse

	其他参考源码

#### ———— by 縋風



