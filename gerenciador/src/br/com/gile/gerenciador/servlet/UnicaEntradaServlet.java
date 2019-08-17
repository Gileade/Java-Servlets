package br.com.gile.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gile.gerenciador.acao.Acao;
import br.com.gile.gerenciador.acao.AlteraEmpresa;
import br.com.gile.gerenciador.acao.ListaEmpresas;
import br.com.gile.gerenciador.acao.MostraEmpresa;
import br.com.gile.gerenciador.acao.NovaEmpresa;
import br.com.gile.gerenciador.acao.NovaEmpresaForm;
import br.com.gile.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.gile.gerenciador.acao." + paramAcao;
		
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);//Carrega a classe com o nome passado
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		
		String [] tipoEEndereco = nome.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
			rd.forward(request, response);	
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
	}

}
