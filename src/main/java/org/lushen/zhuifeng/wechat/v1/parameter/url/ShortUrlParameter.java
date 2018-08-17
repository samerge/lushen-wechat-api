package org.lushen.zhuifeng.wechat.v1.parameter.url;

import org.lushen.zhuifeng.wechat.WechatParameter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 长链接转短链接   参数对象
 * 
 * @author hlm
 */
@NoArgsConstructor
@Getter
@Setter
public class ShortUrlParameter implements WechatParameter {

	private String action = "long2short";

	private String long_url;

	public ShortUrlParameter(String long_url) {
		super();
		this.long_url = long_url;
	}

}

