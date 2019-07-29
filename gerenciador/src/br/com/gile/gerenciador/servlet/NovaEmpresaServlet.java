package br.com.gile.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// Foi sobrescrito o metodo doPost, onde nessa classe agora somente conseguimos
	// usar esse método como post e não mais passando parametros pela URL (GET)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Cadastrando nova Empresa");
		String nomeDaEmpresa = request.getParameter("nome");

		Empresa empresa = new Empresa();
		empresa.setNome(nomeDaEmpresa);

		Banco banco = new Banco();
		banco.adiciona(empresa);

		// Chamar o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", empresa.getNome());
		rd.forward(request, response);
	}

}
