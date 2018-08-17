package org.lushen.zhuifeng.wechat;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 
 * @author hlm
 */
@Getter
@Setter
public class SimpleResponse implements WechatResponse {

	private int errcode;
	
	private String errmsg;

}
