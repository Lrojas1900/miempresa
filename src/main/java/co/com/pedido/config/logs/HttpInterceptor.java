package co.com.pedido.config.logs;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * interceptor de peticiones HTTP
 * @author Germán Alejandro Casallas Guarnizo
 */
public class HttpInterceptor extends HandlerInterceptorAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpInterceptor.class);
    
	Gson gson = new Gson();

    @Override
    public boolean preHandle(HttpServletRequest requestServlet, HttpServletResponse responseServlet, Object handler) throws Exception
    {
        var paramsMap = requestServlet.getParameterMap();

        // log de query params
        if (!paramsMap.isEmpty()) {
            String jsonString = gson.toJson(paramsMap);

            LOGGER.info("REQUEST: {}", jsonString);
        }

        return true;
    }
}
