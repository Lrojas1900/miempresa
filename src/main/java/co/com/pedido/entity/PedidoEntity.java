package co.com.pedido.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pedido")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String tipo_identificacion;
    private String identificacion;

    public PedidoEntity() {
    }

    public PedidoEntity(String name, String tipo_identificacion, String identificacion) {

        this.nombre = name;
        this.tipo_identificacion = tipo_identificacion;
        this.identificacion = identificacion;
    }


}

