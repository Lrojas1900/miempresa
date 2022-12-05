package co.com.pedido.repository;

import co.com.pedido.entity.ItempedidoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItempedidoRepository extends CrudRepository<ItempedidoEntity, Long> {



}