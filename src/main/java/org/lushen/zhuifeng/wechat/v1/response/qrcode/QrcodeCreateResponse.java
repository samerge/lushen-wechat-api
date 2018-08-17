package org.lushen.zhuifeng.wechat.v1.response.qrcode;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 二维码创建接口	响应对象
 *
 * @author hlm
 */
@Getter
@Setter
public final class QrcodeCreateResponse extends SimpleResponse {

	private String ticket;

	private int expire_seconds;

	private String url;

}
