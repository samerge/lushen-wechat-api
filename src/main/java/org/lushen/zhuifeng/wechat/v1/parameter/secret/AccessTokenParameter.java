package org.lushen.zhuifeng.wechat.v1.parameter.secret;

import org.lushen.zhuifeng.wechat.WechatParameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 获取access token接口参数
 * 
 * @author hlm
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenParameter implements WechatParameter {

	private String appid;

	private String secret;

}
