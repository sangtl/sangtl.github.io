package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Account;

@WebServlet(name = "DeleteControl", urlPatterns = {"/delete"})
public class DeleteControl extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 2890091925459791074L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        String pid = request.getParameter("pid");
	        HttpSession session = request.getSession();
	        Account a = (Account) session.getAttribute("acc");
	        DAO dao = new DAO();
	        dao.deleteProduct(a,pid);
	        response.sendRedirect("manager");
	}
	
	  @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }

	  
	   
	    @Override
	    public String getServletInfo() {
	        return "Short description";
	    }
}
