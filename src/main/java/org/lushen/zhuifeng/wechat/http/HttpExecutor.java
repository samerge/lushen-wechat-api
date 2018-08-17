package org.lushen.zhuifeng.wechat.http;

import java.util.Map;

/**
 * http请求执行器
 * 
 * @author hlm
 */
public interface HttpExecutor {

	/**
	 * 执行http get请求
	 * 
	 * @param url
	 * @return
	 * @throws HttpException
	 */
	byte[] doHttpGet(String url) throws HttpException;

	/**
	 * 执行http post 表单请求
	 * 
	 * @param url
	 * @param formDatas
	 * @return
	 * @throws HttpException
	 */
	byte[] doHttpPost(String url, Map<String, Object> formDatas) throws HttpException;

	/**
	 * 执行http post body请求
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws HttpException
	 */
	byte[] doHttpPost(String url, String data) throws HttpException;

}
