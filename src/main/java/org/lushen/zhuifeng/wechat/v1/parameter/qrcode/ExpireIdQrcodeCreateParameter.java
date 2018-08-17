package org.lushen.zhuifeng.wechat.v1.parameter.qrcode;

import lombok.Getter;
import lombok.Setter;

/**
 * 数字scene临时二维码	参数对象
 * 
 * @author hlm
 */
@Getter
@Setter
public class ExpireIdQrcodeCreateParameter extends QrcodeCreateParameter {

	private int expire_seconds;

	private String action_name = "QR_SCENE";

	private QrcodeActionInfo action_info;

	public ExpireIdQrcodeCreateParameter(int expire_seconds, int scene_id) {
		super();
		this.expire_seconds = expire_seconds;
		this.action_info = new QrcodeActionInfo(new QrcodeSceneForId(scene_id));
	}

}
