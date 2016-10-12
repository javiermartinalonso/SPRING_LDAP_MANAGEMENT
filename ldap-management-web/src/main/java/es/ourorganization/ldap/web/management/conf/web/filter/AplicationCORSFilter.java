package es.ourorganization.ldap.web.management.conf.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Un filtro para permitir peticiones ajax desde otros dominios 
 */
@Component
public class AplicationCORSFilter implements Filter {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(FilterConfig filterConfig) {
		// NULL
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void destroy() {
		// NULL
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, x-bonita-api-token");
//		response.setHeader("Access-Control-Expose-Headers",
//				InventoryController.HEADER_LINK + ", " + InventoryController.HEADER_NEXTPAGE);
		chain.doFilter(req, res);
	}
}
