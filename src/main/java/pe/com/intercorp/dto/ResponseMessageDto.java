package pe.com.intercorp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMessageDto<T extends Object> {
	private String error;
	private String code;
	private T object;
	public ResponseMessageDto(String error, String code, T object) {
		super();
		this.error = error;
		this.code = code;
		this.object = object;
	}
	
	public ResponseMessageDto() {
		super();
	}

	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public T getObject() {
		return object;
	}
	

	public void setObject(T object) {
		this.object = object;
	}
}
