package com.ivan.mall.pojo;

/**
 * 通用的返回类Json格式
 * @author Ivan
 *
 */

public class Message {

	// 返回数据状态码
	private int code;// 0--成功;-1--失败
	// 返回数据信息
	private String msg;
	//数据总数,在分页时返回数据总数
	private long count;
	// 返回数据,在分页时返回数据详情
	private Object data;

	// 操作成功
	public static Message success() {
		Message result = new Message();
		result.setCode(0);// 0--成功
		result.setMsg("操作成功...");
		return result;
	}

	// 操作失败
	public static Message error() {
		Message result = new Message();
		result.setCode(-1);// -1--失败
		result.setMsg("操作失败...");
		return result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
