package co.com.pedido.controller;

import brave.Tracer;
import co.com.pedido.dto.ResponseDto;
import co.com.pedido.dto.ResponsePedidoDto;
import co.com.pedido.dto.TiposDto;
import co.com.pedido.entity.PedidoEntity;
import co.com.pedido.entity.TiposEntity;
import co.com.pedido.service.IPedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * Clase controlador para exponer la operacion de validacion bloqueo de datos de
 * una linea
 */
@RestController
public class AppController {

	private static final Logger log = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private Tracer tracer;

	@Autowired
	private IPedidoService pedidoService;

	@GetMapping("getTipos")
	public ResponseEntity<ResponseDto<List>> getTipos() {

		return ResponseEntity.ok(new ResponseDto<List>(HttpStatus.OK, "", pedidoService.findTipos(), "803f2bfb499646c9"));
	}

	@PostMapping("savePedido")
	public ResponseEntity<ResponseDto> savePedido(@Valid @RequestBody ResponsePedidoDto requestDto) {
		return ResponseEntity.ok(new ResponseDto<PedidoEntity>(HttpStatus.OK, pedidoService.addPedido(requestDto), null, "803f2bfb499646c9"));
	}

}
