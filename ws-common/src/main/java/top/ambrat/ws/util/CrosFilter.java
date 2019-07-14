package top.ambrat.ws.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(servletNames={"dispatcherServlet"})
public class CrosFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, 
		ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//‘ –ÌAjaxøÁ”Ú◊ ‘¥∑√
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
