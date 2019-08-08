package br.com.gile.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Deve ser inserido essa annotation para saber onde sera acessada na URL
//Foi retirado pois está sendo chamado pelo webxml
//@WebServlet(urlPatterns="/oi")
public class OlaMundoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//Cria um objeto PrintWriter do objeto de resposta para que possa escrever o HRML
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Olá Mundo em Servlet");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("O servlet Olá mundo foi chamado");
	}
	
}
