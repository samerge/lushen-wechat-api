package org.lushen.zhuifeng.wechat.http;

/**
 * http异常
 * 
 * @author hlm
 */
@SuppressWarnings("serial")
public final class HttpException extends Exception {

	public HttpException(String message, Throwable cause) {
		super(message, cause);
	}

	public HttpException(String message) {
		super(message);
	}

}
