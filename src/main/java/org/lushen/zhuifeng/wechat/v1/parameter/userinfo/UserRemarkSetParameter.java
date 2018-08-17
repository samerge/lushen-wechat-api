package org.lushen.zhuifeng.wechat.v1.parameter.userinfo;

import org.lushen.zhuifeng.wechat.WechatParameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 设置用户备注名  参数对象
 * 
 * @author hlm
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRemarkSetParameter implements WechatParameter {

	private String openid;

	private String remark;

}
