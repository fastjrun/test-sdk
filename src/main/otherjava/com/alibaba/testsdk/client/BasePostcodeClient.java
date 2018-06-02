
package com.alibaba.testsdk.client;

import java.util.Map;
import java.util.ResourceBundle;

import com.fastjrun.sdkg.client.BaseGenericClient;
import com.fastjrun.sdkg.common.CodeException;

import net.sf.json.JSONObject;

/**
 * 注意：邮编查询接口访问抽象类
 * 
 * @Copyright 2018 快嘉框架. All rights reserved.
 * @author cuiyingfeng
 */
public abstract class BasePostcodeClient extends BaseGenericClient {

	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public void initSDKConfig(String apiworld) {
		ResourceBundle rb = ResourceBundle.getBundle(apiworld + "-sdk");
		this.genericUrlPre = rb.getString(apiworld + ".genericUrlPre");
		this.key = rb.getString(apiworld + ".key");
	}

	@Override
	protected JSONObject process(String reqStr, String urlReq, String method, Map<String, String> requestProperties) {
		JSONObject responseJsonObject = this.processInternal(reqStr, urlReq + "&key=" + this.key, method,
				requestProperties);
		try {
			int code = responseJsonObject.getInt("error_code");
			if (code == 0) {
				return responseJsonObject;
			}
			//这里可以过滤错误码，对指定错误码可以进行再封装
			String msg = responseJsonObject.getString("reason");
			if (msg == null) {
				msg = "";
			}
			throw new CodeException(String.valueOf(code), msg);
		} catch (Exception e) {
			throw new CodeException("603", "返回数据error_code有误");
		}
	}

}
