package co.com.pedido.dto;

import lombok.Data;

@Data
public class ResponsePedidoDto<T> {

	private Integer id;
	private String name;
	private String tipoIdentificacion;
	private String identificacion;
	private T itemPedido;

	public ResponsePedidoDto() {
		// Constructor vacío para instancia
	}

}