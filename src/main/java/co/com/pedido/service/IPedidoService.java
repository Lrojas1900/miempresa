package co.com.pedido.service;

import co.com.pedido.dto.ResponsePedidoDto;
import co.com.pedido.dto.TiposDto;

import java.util.List;

public interface IPedidoService {

    List<TiposDto> findTipos();

    String addPedido(ResponsePedidoDto requestDto);
}
