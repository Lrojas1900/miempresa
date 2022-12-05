package co.com.pedido.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tipos")
public class TiposEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ropa;
    private String descripcion;

    public TiposEntity() {
    }

    public TiposEntity(Long id, String ropa, String descripcion) {
        this.id = id;
        this.ropa = ropa;
        this.descripcion = descripcion;
    }
}

