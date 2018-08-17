package org.lushen.zhuifeng.wechat.v1.response.jssdk;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * jssdk接口响应对象
 *
 * @author hlm
 */
@Setter
@Getter
public class JsSdkResponse extends SimpleResponse {

	private String ticket;

	private long expires_in;

}
