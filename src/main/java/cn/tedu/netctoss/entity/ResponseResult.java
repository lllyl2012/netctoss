package cn.tedu.netctoss.entity;

public class ResponseResult<T> {
	public static final int STATE_OK = 1;
	public static final int STATE_ERROR = -1;
	private int state;
	private String message;
	private T data;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}

	
}
