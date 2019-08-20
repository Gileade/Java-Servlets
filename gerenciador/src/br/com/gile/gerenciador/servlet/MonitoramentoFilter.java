package br.com.gile.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long inicio = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Tempo de Execução: "+ (fim - inicio));
		
	}

}
