package co.com.pedido.repository;

import co.com.pedido.entity.TiposEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposRepository extends CrudRepository<TiposEntity, Long> {

}