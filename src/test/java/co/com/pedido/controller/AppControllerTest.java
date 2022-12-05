package co.com.pedido.controller;

import ch.qos.logback.classic.Logger;
import co.com.pedido.dto.ResponsePedidoDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@SpringBootTest
class AppControllerTest {

    @Autowired
    private AppController controller;

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AppControllerTest.class);

    @Test
    void callGetTest() {
        Assert.assertNotNull(controller.getTipos());
    }

    @Test
    void callSaveMusicTest() {
        ResponsePedidoDto requestDto = new ResponsePedidoDto();
        requestDto.setName("José Perez");
        requestDto.setTipoIdentificacion("C");
        requestDto.setIdentificacion("1234567890");
        LinkedHashMap hash = new LinkedHashMap();
        hash.put("tipos_id", "1");
        hash.put("cantidad", "5");
        hash.put("direccion", "Calle 72 #35-25");
        List<LinkedHashMap> list = new ArrayList<>();
        list.add(0,hash);
        LinkedHashMap hash2 = new LinkedHashMap();
        hash2.put("tipos_id", "2");
        hash2.put("cantidad", "3");
        hash2.put("direccion", "Calle 68 #35-25");
        list.add(1,hash);
        requestDto.setItemPedido(list);

        Assert.assertNotNull(controller.savePedido(requestDto));
    }
}
