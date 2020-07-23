package br.com.teste.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import br.com.teste.dao.EstudanteDao;
import br.com.teste.model.Estudante;

/**
 * Servlet implementation class EstudanteController
 */
@WebServlet(urlPatterns = {"/EstudanteController"})
public class EstudanteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
// action=” ${pageContext.request.contextPath}/EstudanteController”
	
//	private static String INCLUIR_EDITAR_ESTUDANTE = "/incluirEditarEstudante.jsp";
//	private static String LISTAR_ESTUDANTES = "/listarEstudantes.jsp";
	private static String LISTAR_ESTUDANTES = "/listarEstudantes.jsp";
	private static String LISTAR = "/listar.jsp";

	private EstudanteDao dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstudanteController() {
//        super();
        // TODO Auto-generated constructor stub
		System.out.println(" ...construindo EstudanteController");
        dao = new EstudanteDao();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub

    	System.out.println("\n service response: " + resp + " request: " + req);
		
    	super.service(req, resp);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("\n doGet response: " + response + " request: " + request);
		
		String acao = request.getParameter("acao");
		
		System.out.println("\n acao = " + acao);
		
		String forward = LISTAR_ESTUDANTES;

		if (acao.equals("listar")) {
			
			// *** campo a ser enviado pada a página via "forward" >> request.setAttribute("chave", "valor"); -> Sem aspas se for número
			request.setAttribute("campo", 12345);
			System.out.println("\n Listar estudante - Controller: todos");
			request.setAttribute("estudantes", dao.listarEstudantes());
		} 
		
		System.out.println("\n doGet Forward = " + forward);

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
				
	}
		
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("\n doPost response: " + response + " request: " + request);
		
		String acao = request.getParameter("acao");
		
		System.out.println("\n acao = " + acao);

		String forward = LISTAR_ESTUDANTES;

		Estudante estudante = new Estudante();

		estudante.setCodigo(Integer.parseInt(request.getParameter("id")));
		estudante.setNome(request.getParameter("name"));
		estudante.setCidade(request.getParameter("city"));
		estudante.setTelefone(request.getParameter("phone"));

		try {
			System.out.println("\n Incluir estudante - Controller " + estudante);

			dao.incluirEstudantes(estudante);
			System.out.println("\n:: Deu certo [INC EstudanteController]: " + estudante);

			request.setAttribute("estudantes", dao.listarEstudantes());
			System.out.println("\n:: Deu certo [LST EstudanteController]: " + estudante);
		} catch (Exception e) {
			System.out.println("\n:: Deu erro: " + e);
		}

		System.out.println("\n doPost Forward = " + forward);

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	public EstudanteDao getDao() {
		return dao;
	}

	public void setDao(EstudanteDao dao) {
		this.dao = dao;
	}

}
