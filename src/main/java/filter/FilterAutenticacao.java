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
 * @author anailson FILTER INTERCEPTA TODAS AS REQUISIÇÕES QUE VIER DO PROJETO
 *         OU MAPEAMENTO
 */
@WebFilter(urlPatterns = { "/principal/*" })
public class FilterAutenticacao implements Filter {

	private static Connection connection;

	public FilterAutenticacao() {

	}

	/*
	 * encerra os processos quando o servidor é parado - exemplo:matar os processos
	 * de conexão com o banco
	 */
	public void destroy() {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}

	/**
	 * intercepta as requisições e as respostas do sistema. Exemplo: validação de
	 * autenticação, commit no banco etc
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
	
			String usuarioLogado = (String) session.getAttribute("usuario");
			String urlParaAutenticar = req.getServletPath();// URL que está sendo acessada.
	
			/*
			 * VALIDAR SER ESTÁ LOGADO - Caso não esteja redirecionar para a tela de login
			 */
	
			if (usuarioLogado == null && !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {
	
				RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
				request.setAttribute("msg", "Por favor realize o login!");
				redireciona.forward(request, response);
				return; // para a execução e redireciona para o login
	
			} else {
				chain.doFilter(request, response);
			}
			
			connection.commit();/*Deu tudo certo é realizado os commit com as alterações no banco de dados*/
			
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
	 * exemplo:iniciar a conexão com o banco
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnectionBanco.getConnection();
	}

}
