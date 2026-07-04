package mx.com.misterjob.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto {
	private Integer code;
	private List<String> message;
	private Object content;
	
	public ResponseDto() {
		super();
	}
	
	public ResponseDto(Integer code, List<String> message, Object content) {
		super();
		this.code = code;
		this.message = message;
		this.content = content;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		if (this.code == null) {
			this.code = code;
		} else {
			this.code = -50;
		}
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(ArrayList<String> message) {
		this.message = message;
	}
	
	public void addMessage(String message) {
		if (this.message == null) {
			this.message = new ArrayList<String>();
		}
		
		this.message.add(message);
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ResponseDto [code=" + code + ", message=" + message + ", content=" + content + "]";
	}
}
