package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AdminModel;
import model.PatientModel;
import model.ReportModel;

import java.io.IOException;

import dao.AdminDao;


@MultipartConfig
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AdminDao db = new AdminDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");		
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		
		//Controls the get request of admin
		if (action.equals("login")) {

			AdminModel adminModel = new AdminModel();
			request.setAttribute("admin", adminModel);
			request.setAttribute("action", "login");

			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		//Log admin outs
		else if (action.equals("logout")) {


			session.removeAttribute("adminId");
			session.removeAttribute("adminName");

			request.setAttribute("action", "login");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		 if (action.equals("login")) {

			AdminModel adminModel = new AdminModel();

			String adminPhone = request.getParameter("adminPhone");
			String adminPassword = request.getParameter("adminPassword");

			adminModel =db.getAdminPasswordByPhone(adminPhone);


			if(adminModel==null)
			{
				request.setAttribute("message", "Account id Invalid...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else if (adminPhone.equals(adminModel.getAdminPhone()) && adminPassword.equals(adminModel.getAdminPassword())) {
				int adminId = adminModel.getAdminId();

				HttpSession session=request.getSession();
				session.setAttribute("message", "" );
				session.setAttribute("adminName", adminModel.getAdminName());
				session.setAttribute("adminId", adminId);

				request.getRequestDispatcher("/admin_dashboard.jsp").forward(request, response);

			}

			else {
				request.setAttribute("message", "Wrong Account id or  password...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} 
		
	}

}
