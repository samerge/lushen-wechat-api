package org.lushen.zhuifeng.wechat.v1.response.url;

import org.lushen.zhuifeng.wechat.SimpleResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 长链接转短链接   响应对象
 * 
 * @author hlm
 */
@Getter
@Setter
public class ShortUrlResponse extends SimpleResponse {

	private String short_url;

}
