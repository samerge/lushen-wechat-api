package org.lushen.zhuifeng.wechat.resource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.lushen.zhuifeng.wechat.utils.CloseableUtils;

/**
 * 默认资源加载处理器，处理properties文件
 * 
 * @author hlm
 */
public class PropertiesResourceResolver implements ResourceResolver {

	private static final String prefix = "{";

	private static final String subfix = "}";

	private final Map<String, String> resources = new HashMap<String, String>();	//资源缓存

	private final String[] paths;	//资源路径

	private final ResourceFormater formater;	//资源格式化辅助类

	public PropertiesResourceResolver(String path) {
		this(new String[]{path}, new DefaultResourceFormater());
	}

	public PropertiesResourceResolver(String[] paths) {
		this(paths, new DefaultResourceFormater());
	}

	public PropertiesResourceResolver(String[] paths, ResourceFormater formater) {
		super();
		this.paths = paths;
		this.formater = formater;
		initialize();
	}

	/**
	 * 初始化预加载所有properties资源配置
	 */
	private final void initialize() {
		if(this.paths == null) {
			return;
		}
		for(String path : this.paths) {
			loadProperties(path).forEach((name, value) -> {
				String resourceName = StringUtils.join(prefix, name, subfix);
				String resourceValue = value.toString();
				this.resources.put(resourceName, resourceValue);
			});
		}
	}

	@Override
	public String loadResource(String name) {
		return this.resources.get(name);
	}

	@Override
	public String loadAndFormatResource(String name, Object... args) {
		String resource = loadResource(name);
		return this.formater.format(resource, args);
	}
	
	/**
	 * 加载Properties文件
	 * 
	 * @param pathname
	 * @return
	 */
	private Properties loadProperties(String pathname) {
		InputStream inputStream = Class.class.getResourceAsStream(pathname);
		try {
			Properties props = new Properties();
			props.load(inputStream);
			return props;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			CloseableUtils.close(inputStream);
		}
	}

}
