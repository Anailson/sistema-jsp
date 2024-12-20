package servlets;

import dao.DAOLoginRepository;
import model.ModelLogin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//� O CHAMADO CONTROLLER S�O AS servlets ou ServletLoginController
@WebServlet(urlPatterns = {"/principal/ServletLogin", "/ServletLogin"}) // MAPEAMENTO DA URL QUE VEM DA TELA
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOLoginRepository daoLoginRepository = new DAOLoginRepository();

	public ServletLogin() {

	}

	// RECEBER OS DADOS PELA URL EM PARAMETROS
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("logout")) {
			request.getSession().invalidate();//invalida a sess�o
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			redirecionar.forward(request, response);
		}else {
			 doPost(request, response);	
		}			
	
	}

	/// RECEBER OS DADOS ENVIADOS POR UM FORMUL�RIO
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url   = request.getParameter("url");

		try {
	
			//Login e senha diferente de null - armazenar no objeto
		if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {

			//ModelLogin modelLogin = null;/*Causando um erro para chamar a pagina de erro.jsp*/
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			
		
			if (daoLoginRepository.validarAutenticacao(modelLogin)){//SIMULANDO LOGIN
				
				request.getSession().setAttribute("usuario", modelLogin.getLogin());
				
				if(url == null || url.equals("null")) {
					url = "principal/principal.jsp";
					
				}
				
				RequestDispatcher redirecionar = request.getRequestDispatcher(url);
				redirecionar.forward(request, response);
			
				//Caso n�o seja informado dados do usu�rio
			}else {
				RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "Informe o login e senha corretamente!!");
				redirecionar.forward(request, response);
			}//teste
			
			
		}else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Informe o login e senha corretamente!!");
			redirecionar.forward(request, response);
		}
	} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
			
		}
		

	}

}
