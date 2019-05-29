package com.dyq.model;

public class ResultModel {

	/** 成功Flg */
	private boolean success = false;
	/** 成功信息*/
	private String okMessage;
	/** 失败信息 */
	private String errorMessage;
	/** 返回数据 */
	private Object result;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getOkMessage() {
		return okMessage;
	}
	public void setOkMessage(String okMessage) {
		this.okMessage = okMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
}
