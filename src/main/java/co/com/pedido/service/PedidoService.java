package co.com.pedido.service;

import co.com.pedido.dto.ResponsePedidoDto;
import co.com.pedido.dto.TiposDto;
import co.com.pedido.entity.ItempedidoEntity;
import co.com.pedido.entity.PedidoEntity;
import co.com.pedido.entity.TiposEntity;
import co.com.pedido.repository.ItempedidoRepository;
import co.com.pedido.repository.PedidoRepository;
import co.com.pedido.repository.TiposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItempedidoRepository itempedidoRepository;

    @Autowired
    private TiposRepository tiposRepository;

    @Override
    public List<TiposDto> findTipos() {
        Iterator<TiposEntity> lista = tiposRepository.findAll().iterator();
        List<TiposDto> response = new ArrayList<>();

        while (lista.hasNext()) {
            TiposEntity tipos = lista.next();
            TiposDto tiposDto = new TiposDto();
            tiposDto.setId(tipos.getId());
            tiposDto.setRopa(tipos.getRopa());
            tiposDto.setDescripcion(tipos.getDescripcion());
            response.add(tiposDto);
        }
        return response;
    }

    @Override
    public String addPedido(ResponsePedidoDto requestDto){
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setNombre(requestDto.getName());
        pedidoEntity.setTipo_identificacion(requestDto.getTipoIdentificacion());
        pedidoEntity.setIdentificacion(requestDto.getIdentificacion());

        PedidoEntity pedidos = pedidoRepository.save(pedidoEntity);
        if (pedidos == null){
            return "No se guardo el pedido";
        }else{
            List<LinkedHashMap> items = (List<LinkedHashMap>) requestDto.getItemPedido();
            for (int i=0;i<items.size();i++) {
                var item = items.get(i);
                ItempedidoEntity pedido = new ItempedidoEntity();
                pedido.setId(Long.parseLong((int)(Math.random() * 999999950 + 1) + ""));
                pedido.setPeido_id(pedidos.getId());
                pedido.setTipos_id(Integer.parseInt(item.get("tipos_id").toString()));
                pedido.setCantidad(Integer.parseInt(item.get("cantidad").toString()));
                pedido.setDireccion(item.get("direccion").toString());
                itempedidoRepository.save(pedido);
            }
            return "Pedido guardado con éxito";
        }
    }
}
