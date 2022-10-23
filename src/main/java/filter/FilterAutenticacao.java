package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;

import connection.SingleConnectionBanco;

/**
 * 
 * @author anailson FILTER INTERCEPTA TODAS AS REQUISI��ES QUE VIER DO PROJETO
 *         OU MAPEAMENTO
 */
@WebFilter(urlPatterns = { "/principal/*" })
public class FilterAutenticacao implements Filter {

	private static Connection connection;

	public FilterAutenticacao() {

	}

	/*
	 * encerra os processos quando o servidor � parado - exemplo:matar os processos
	 * de conex�o com o banco
	 */
	public void destroy() {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}

	/**
	 * intercepta as requisi��es e as respostas do sistema. Exemplo: valida��o de
	 * autentica��o, commit no banco etc
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
	
			String usuarioLogado = (String) session.getAttribute("usuario");
			String urlParaAutenticar = req.getServletPath();// URL que est� sendo acessada.
	
			/*
			 * VALIDAR SER EST� LOGADO - Caso n�o esteja redirecionar para a tela de login
			 */
	
			if (usuarioLogado == null && !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {
	
				RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
				request.setAttribute("msg", "Por favor realize o login!");
				redireciona.forward(request, response);
				return; // para a execu��o e redireciona para o login
	
			} else {
				chain.doFilter(request, response);
			}
			
			connection.commit();/*Deu tudo certo � realizado os commit com as altera��es no banco de dados*/
			
		}catch (Exception e) {
			e.printStackTrace();
			
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
			
	}  

	/**
	 * iniciar os processo ou recursos qd o servidor sobre o projeto -
	 * exemplo:iniciar a conex�o com o banco
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnectionBanco.getConnection();
	}

}
