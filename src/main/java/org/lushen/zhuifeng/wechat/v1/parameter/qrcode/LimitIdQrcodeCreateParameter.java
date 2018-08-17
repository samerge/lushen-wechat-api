package org.lushen.zhuifeng.wechat.v1.parameter.qrcode;

import lombok.Getter;
import lombok.Setter;

/**
 * 数字scene永久二维码	参数对象
 * 
 * @author hlm
 */
@Getter
@Setter
public final class LimitIdQrcodeCreateParameter extends QrcodeCreateParameter {

	private String action_name = "QR_LIMIT_SCENE";

	private QrcodeActionInfo action_info;

	public LimitIdQrcodeCreateParameter(int scene_id) {
		super();
		this.action_info = new QrcodeActionInfo(new QrcodeSceneForId(scene_id));
	}

}
