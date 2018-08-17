package org.lushen.zhuifeng.wechat.v1.parameter.qrcode;

import lombok.Getter;
import lombok.Setter;

/**
 * 字符串scene永久二维码	参数对象
 * 
 * @author hlm
 */
@Getter
@Setter
public class LimitStrQrcodeCreateParameter extends QrcodeCreateParameter {

	private String action_name = "QR_STR_SCENE";

	private QrcodeActionInfo action_info;

	public LimitStrQrcodeCreateParameter(String scene_str) {
		super();
		this.action_info = new QrcodeActionInfo(new QrcodeSceneForStr(scene_str));
	}

}
