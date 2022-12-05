package co.com.pedido.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "itempedido")
public class ItempedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer peido_id;
    private Integer tipos_id;
    private Integer cantidad;
    private String direccion;

    public Long getId() {
        return id;
    }

    public ItempedidoEntity() {
    }

    public ItempedidoEntity(Long id, Integer peido_id, Integer tipos_id, Integer cantidad, String direccion) {
        this.id = id;
        this.peido_id = peido_id;
        this.tipos_id = tipos_id;
        this.cantidad = cantidad;
        this.direccion = direccion;
    }
}

