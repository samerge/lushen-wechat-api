package org.lushen.zhuifeng.wechat.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 资源释放工具类
 * 
 * @author hlm
 */
public abstract class ReleaseUtils {

	private static final Log log = LogFactory.getLog(ReleaseUtils.class);

	/**
	 * 释放资源，保证不抛出异常
	 * 
	 * @param resource
	 * @param consumer
	 */
	public static final <T> void nonBreakRelease(T resource, Consumer<T> consumer) {
		try {
			if(resource != null) {
				consumer.release(resource);
			}
		} catch (Throwable e) {
			log.error(e);
		}
	}

	/**
	 * 资源释放接口定义
	 * 
	 * @author helm
	 * @param <T>
	 */
	public static interface Consumer<T> {

		void release(T resource) throws Throwable;

	}

}
