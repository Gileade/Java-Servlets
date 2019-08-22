package br.com.gile.cliente;

import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws Exception {
		String conteudo = 
		Request
		.Post("http://localhost:8080/gerenciador/empresas")
		.addHeader("Accept","application/xml")//Aqui onde é passado o que é necessário, se é json ou xml
		.execute()
		.returnContent()
		.asString();
		
		System.out.println(conteudo);
	}

}
