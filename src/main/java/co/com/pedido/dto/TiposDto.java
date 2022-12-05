package co.com.pedido.dto;

import lombok.Data;

@Data
public class TiposDto {

    private Long id;
    private String ropa;
    private String descripcion;

    public TiposDto() {
        // Constructor vacío para instancia
    }
}
