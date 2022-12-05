package co.com.pedido.dto;

import org.springframework.http.HttpStatus;

public class ResponseDto<T> {

	private HttpStatus responseCode;
	private String message;
	private T listas;
	private String transactionId;

	public ResponseDto() {
		// Constructor vacío para instancia
	}

	public ResponseDto(HttpStatus responseCode, String message, T listas, String transactionId) {
		this.responseCode = responseCode;
		this.message = message;
		this.listas = listas;
		this.transactionId = transactionId;
	}

	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getListas() {
		return listas;
	}

	public void setListas(T listas) {
		this.listas = listas;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}