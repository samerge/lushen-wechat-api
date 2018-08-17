package org.lushen.zhuifeng.wechat.v1;

import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.lushen.zhuifeng.wechat.SimpleResponse;
import org.lushen.zhuifeng.wechat.WechatApi;
import org.lushen.zhuifeng.wechat.WechatException;
import org.lushen.zhuifeng.wechat.WechatSupport;
import org.lushen.zhuifeng.wechat.v1.parameter.oauth2.Oauth2Scope;
import org.lushen.zhuifeng.wechat.v1.response.oauth2.Oauth2Response;
import org.lushen.zhuifeng.wechat.v1.response.oauth2.Oauth2UserinfoResponse;

/**
 * 微信授权接口
 *
 * @author hlm
 */
@WechatApi
public class Oauth2WechatApi extends WechatSupport {

	/**
	 * 获取网页授权跳转URL
	 * 
	 * @param appid
	 * @param redirect_url
	 * @param scope
	 * @param state
	 * @return
	 * @throws WechatException
	 */
	public String getOauth2Url(String appid, String redirect_url, Oauth2Scope scope, String state) throws WechatException {
		try {
			redirect_url = URLEncoder.encode(redirect_url, Charset.defaultCharset().displayName());
			state = URLEncoder.encode(state, Charset.defaultCharset().displayName());
			return loadAndFormatResource("{authorize_url}", appid, redirect_url, scope, state);
		} catch (Throwable e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 通过code换取用户信息
	 * 
	 * @param appid
	 * @param appsecret
	 * @param code
	 * @return
	 * @throws WechatException
	 */
	public Oauth2Response oauth2Code(String appid, String appsecret, String code) throws WechatException {
		try{
			String url = loadAndFormatResource("{authorize_code_url}", appid, appsecret, code);
			byte[] bytes = doHttpGet(url);
			return fromJson2JavaObject(bytes, Oauth2Response.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 刷新微信授权的 access_token
	 * 
	 * @param appid
	 * @param refresh_token
	 * @return
	 * @throws WechatException
	 */
	public Oauth2Response oauth2Reflush(String appid, String refresh_token) throws WechatException {
		try{
			String url = loadAndFormatResource("{authorize_reflush_url}", appid, refresh_token);
			byte[] bytes = doHttpGet(url);
			return fromJson2JavaObject(bytes, Oauth2Response.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 拉取用户信息(需scope为 snsapi_userinfo)
	 * 
	 * @param access_token
	 * @param openid
	 * @return
	 * @throws WechatException
	 */
	public Oauth2UserinfoResponse getOauth2Userinfo(String access_token, String openid) throws WechatException {
		try{
			String url = loadAndFormatResource("{authorize_userinfo_url}", access_token, openid);
			byte[] bytes = doHttpGet(url);
			return fromJson2JavaObject(bytes, Oauth2UserinfoResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 检验授权凭证（access_token）是否有效
	 * 
	 * @param access_token
	 * @param openid
	 * @return
	 * @throws WechatException
	 */
	public SimpleResponse oauth2Check(String access_token, String openid) throws WechatException {
		try{
			String url = loadAndFormatResource("{authorize_check_url}", access_token, openid);
			byte[] bytes = doHttpGet(url);
			return fromJson2JavaObject(bytes, SimpleResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

}
