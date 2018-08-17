package org.lushen.zhuifeng.wechat.v1;

import org.lushen.zhuifeng.wechat.WechatApi;
import org.lushen.zhuifeng.wechat.WechatException;
import org.lushen.zhuifeng.wechat.WechatSupport;
import org.lushen.zhuifeng.wechat.v1.parameter.datacube.DatacubeParameter;
import org.lushen.zhuifeng.wechat.v1.response.datacube.ArticleSummaryResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.ArticleTotalResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.InterfaceSummaryHourResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.InterfaceSummaryResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UpStreamMsgDistMonthResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UpStreamMsgDistResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UpStreamMsgDistWeekResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UpStreamMsgHourResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UpStreamMsgMonthResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UpStreamMsgResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UpStreamMsgWeekResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UserCumulateResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UserReadHourResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UserReadResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UserShareHourResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UserShareResponse;
import org.lushen.zhuifeng.wechat.v1.response.datacube.UserSummaryResponse;

/**
 * 数据统计接口
 *
 * @author hlm
 */
@WechatApi
public class DatacubeWechatApi extends WechatSupport {

	/**
	 * 获取用户增减数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UserSummaryResponse getUserSummary(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_usersummary_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UserSummaryResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}


	/**
	 * 获取累计用户数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UserCumulateResponse getUserCumulate(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_usercumulate_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UserCumulateResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取图文群发每日数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public ArticleSummaryResponse getArticleSummary(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_articlesummary_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, ArticleSummaryResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取图文群发总数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public ArticleTotalResponse getArticleTotal(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_articletotal_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, ArticleTotalResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取图文统计数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UserReadResponse getUserRead(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_userread_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UserReadResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取图文统计分时数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UserReadHourResponse getUserReadHour(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_userreadhour_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UserReadHourResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取图文分享转发数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UserShareResponse getUserShare(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_usershare_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UserShareResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 
	 * 获取图文分享转发分时数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UserShareHourResponse getUserShareHour(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_usersharehour_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UserShareHourResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取消息发送概况数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UpStreamMsgResponse getUpStreamMsg(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_upstreammsg_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UpStreamMsgResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取消息分送分时数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UpStreamMsgHourResponse getUpStreamMsgHour(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_upstreammsghour_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UpStreamMsgHourResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取消息发送周数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UpStreamMsgWeekResponse getUpStreamMsgWeek(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_upstreammsgweek_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UpStreamMsgWeekResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取消息发送月数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UpStreamMsgMonthResponse getUpStreamMsgMonth(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_upstreammsgmonth_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UpStreamMsgMonthResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取消息发送分布数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UpStreamMsgDistResponse getUpStreamMsgDist(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_upstreammsgdist_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UpStreamMsgDistResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取消息发送分布周数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UpStreamMsgDistWeekResponse getUpStreamMsgDistWeek(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_upstreammsgdistweek_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UpStreamMsgDistWeekResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取消息发送分布月数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public UpStreamMsgDistMonthResponse getUpStreamMsgDistMonth(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_upstreammsgdistmonth_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, UpStreamMsgDistMonthResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取接口分析数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public InterfaceSummaryResponse getInterfaceSummary(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_interfacesummary_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, InterfaceSummaryResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

	/**
	 * 获取接口分析分时数据
	 * 
	 * @param access_token
	 * @param parameter
	 * @return
	 * @throws WechatException
	 */
	public InterfaceSummaryHourResponse getInterfaceSummaryHour(String access_token, DatacubeParameter parameter) throws WechatException {
		try{
			String url = loadAndFormatResource("{datacube_interfacesummaryhour_url}", access_token);
			byte[] bytes = doHttpPost(url, parameter.toJsonString());
			return fromJson2JavaObject(bytes, InterfaceSummaryHourResponse.class);
		} catch (Exception e) {
			throw new WechatException(e);
		}
	}

}
