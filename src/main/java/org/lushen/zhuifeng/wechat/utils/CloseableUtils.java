package org.lushen.zhuifeng.wechat.utils;

import java.io.Closeable;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 资源关闭工具类
 * 
 * @author hlm
 */
public abstract class CloseableUtils {
	
	private static final Log log = LogFactory.getLog(CloseableUtils.class);

	/**
	 * 关闭资源
	 * 
	 * @param closeable
	 * @throws IOException 
	 */
	public static final void close(Closeable closeable) {
		if(closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}

	/**
	 * 关闭资源
	 * 
	 * @param closeables
	 * @throws IOException 
	 */
	public static final void close(Closeable... closeables) {
		for(Closeable closeable : closeables) {
			if(closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {
					log.error(e);
				}
			}
		}
	}

}
