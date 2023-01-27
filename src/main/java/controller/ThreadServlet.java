package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DoctorModel;
import model.MessageModel;
import model.PatientModel;
import model.ThreadModel;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import dao.DoctorDao;
import dao.MessageDao;
import dao.PatientDao;
import dao.ReportDao;
import dao.ThreadDao;

/**
 * Servlet implementation class ThreadServlet
 */
public class ThreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PatientDao patientDao = new PatientDao();
	DoctorDao doctorDao = new DoctorDao();
	ThreadDao threadDao = new ThreadDao();
	ReportDao reportDao = new ReportDao();
	MessageDao messageDao = new MessageDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThreadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		
		if (action.equals("myThreads")) {
			
			HttpSession session = request.getSession();
			
			int pid = (int)session.getAttribute("pid");
			
			List<ThreadModel> threadModels = threadDao.getAllThreadByPatientId(pid);
			
			if (threadModels.isEmpty()) {
				request.getRequestDispatcher("create_chat.jsp").forward(request, response);
			} else {
				request.setAttribute("threads", threadModels);
				request.getRequestDispatcher("my_chats.jsp").forward(request, response);
			}
			
		} else if(action.equals("startNewChat")) {
			request.getRequestDispatcher("create_chat.jsp").forward(request, response);
		} else if(action.equals("openThread")) {
			int threadId = Integer.parseInt(request.getParameter("threadId"));
			ThreadModel thread = threadDao.getThreadByThreadId(threadId);
			Set<MessageModel> messages = thread.getMessageList();
			request.setAttribute("threadId", threadId);
			if (messages.isEmpty()) {
				request.setAttribute("flag", 0);
			} else {
				request.setAttribute("flag", 1);
				request.setAttribute("messages", messages);
			}
			request.getRequestDispatcher("chat_page.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String action = request.getParameter("action");

		if (action.equals("addNewThread")) {
			
			int did = Integer.parseInt(request.getParameter("dropdownDoctor"));

			System.out.println("doctor ID = "+ did);
			
			if(did == 0) {
				request.setAttribute("msg", "please select a doctor.");
				request.getRequestDispatcher("/create_chat.jsp").forward(request, response);
			}
			else {
				ThreadModel threadModel = new ThreadModel();
				HttpSession session = request.getSession();
				int pid = (int)session.getAttribute("pid");
				PatientModel patientModel = patientDao.getPatientById(pid);
				DoctorModel doctorModel = doctorDao.getDoctorById(did);
				threadModel.setDoctorModel(doctorModel);
				threadModel.setPatientModel(patientModel);
				
				threadDao.saveThread(threadModel);
				
				response.sendRedirect(request.getContextPath() + "/threads?action=myThreads");
				//request.getRequestDispatcher("my_chats.jsp").forward(request, response);

			}
		}
		
	}

}
