package com.alibaba.testsdk.packet;

import com.fastjrun.sdkg.packet.BaseResponseBody;

public abstract class BasePostcodeResponseBody extends BaseResponseBody {
	/**
	 * 返回说明
	 * 
	 */
	private String reason;
	/**
	 * 返回码
	 * 
	 */
	private Integer error_code;

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getError_code() {
		return this.error_code;
	}

	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}

}
