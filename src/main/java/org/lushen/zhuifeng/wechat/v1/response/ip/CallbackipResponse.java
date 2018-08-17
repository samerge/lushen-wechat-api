package org.lushen.zhuifeng.wechat.v1.response.ip;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取微信服务器IP地址接口响应
 * 
 * @author hlm
 */
@Getter
@Setter
public class CallbackipResponse extends SimpleResponse {

	private String[] ip_list;

}
