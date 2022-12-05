package co.com.list.dto;

import lombok.Data;

@Data
public class RequestDto {

    private Long id;
    private String titulo;
    private String artista;
    private String albun;
    private String anno;
    private String genero;

    public RequestDto() {
        // Constructor vacío para instancia
    }
}
