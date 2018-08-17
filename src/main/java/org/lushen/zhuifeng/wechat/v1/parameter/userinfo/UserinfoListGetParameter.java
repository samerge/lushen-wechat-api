package org.lushen.zhuifeng.wechat.v1.parameter.userinfo;

import java.util.List;

import org.lushen.zhuifeng.wechat.WechatParameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 批量获取用户基本信息 参数对象
 * 
 * @author hlm
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserinfoListGetParameter implements WechatParameter {

	private List<Userinfo> user_list;

	/**
	 * 用户信息
	 * 
	 * @author hlm
	 */
	@Getter
	@Setter
	public static class Userinfo {

		private String openid;

		private String lang = "zh_CN";

	}

}

