package org.lushen.zhuifeng.wechat;

/**
 * 微信api异常
 * 
 * @author hlm
 */
@SuppressWarnings("serial")
public final class WechatException extends Exception {

	public WechatException(String message, Throwable cause) {
		super(message, cause);
	}

	public WechatException(String message) {
		super(message);
	}

	public WechatException(Throwable cause) {
		super(cause);
	}

}
