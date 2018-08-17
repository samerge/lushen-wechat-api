package org.lushen.zhuifeng.wechat.v1;

import org.lushen.zhuifeng.wechat.SimpleResponse;
import org.lushen.zhuifeng.wechat.WechatApi;
import org.lushen.zhuifeng.wechat.WechatException;
import org.lushen.zhuifeng.wechat.WechatSupport;
import org.lushen.zhuifeng.wechat.v1.parameter.userinfo.UserRemarkSetParameter;
import org.lushen.zhuifeng.wechat.v1.parameter.userinfo.UserinfoListGetParameter;
import org.lushen.zhuifeng.wechat.v1.response.userinfo.UserOpenidListResponse;
import org.lushen.zhuifeng.wechat.v1.response.userinfo.UserinfoGetResponse;
import org.lushen.zhuifeng.wechat.v1.response.userinfo.UserinfoListGetResponse;

/**
 * 用户信息 接口
 *
 * @author hlm
 */
@WechatApi
public class UserinfoWechatApi extends WechatSupport {

	/**
	 * 获取用户基本信息
	 * 
	 * @param access_token
	 * @param openid
	 * @return
	 * @throws WechatException
	 */
	public UserinfoGetResponse getSubcribeUserinfo(String access_token, String openid) throws WechatException {
		try{
			String url = loadAndFormatResource("{userinfo_get_url}", access_token, openid);
			byte[] bytes = doHttpGet(url);
			return fromJson2JavaObject(bytes, UserinfoGetResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 批量获取用户基本信息
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UserinfoListGetResponse getSubcribeUserinfoList(String access_token, UserinfoListGetParameter parameter) throws WechatException {
		try {
			String url = loadAndFormatResource("{userinfo_list_get_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UserinfoListGetResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 设置用户备注名
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public SimpleResponse setSubcribeUserRemark(String access_token, UserRemarkSetParameter parameter) throws WechatException {
		try {
			String url = loadAndFormatResource("{userinfo_remark_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, SimpleResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取用户列表
	 * 
	 * @param access_token
	 * @param next_openid
	 * @return
	 * @throws WechatException
	 */
	public UserOpenidListResponse getOpenidList(String access_token, String next_openid) throws WechatException {
		try{
			String url = loadAndFormatResource("{userinfo_openid_list_url}", access_token, next_openid);
			byte[] bytes = doHttpGet(url);
			return fromJson2JavaObject(bytes, UserOpenidListResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

}
