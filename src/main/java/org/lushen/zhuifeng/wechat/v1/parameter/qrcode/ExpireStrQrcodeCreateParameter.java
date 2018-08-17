package org.lushen.zhuifeng.wechat.v1.parameter.qrcode;

import lombok.Getter;
import lombok.Setter;

/**
 * 字符串scene临时二维码	参数对象
 * 
 * @author hlm
 */
@Getter
@Setter
public class ExpireStrQrcodeCreateParameter extends QrcodeCreateParameter {

	private int expire_seconds;

	private String action_name = "QR_STR_SCENE";

	private QrcodeActionInfo action_info;

	public ExpireStrQrcodeCreateParameter(int expire_seconds, String scene_str) {
		super();
		this.expire_seconds = expire_seconds;
		this.action_info = new QrcodeActionInfo(new QrcodeSceneForStr(scene_str));
	}

}
