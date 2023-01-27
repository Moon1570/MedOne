package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MessageModel;
import model.ThreadModel;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

import dao.DoctorDao;
import dao.MessageDao;
import dao.PatientDao;
import dao.ReportDao;
import dao.ThreadDao;

/**
 * Servlet implementation class MessageServlet
 */
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PatientDao patientDao = new PatientDao();
	DoctorDao doctorDao = new DoctorDao();
	ThreadDao threadDao = new ThreadDao();
	ReportDao reportDao = new ReportDao();
	MessageDao messageDao = new MessageDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		
		if(action.equals("sendMessage")) {
			String message = request.getParameter("myMessage");
			int threadId = Integer.parseInt(request.getParameter("threadId"));
			MessageModel messageModel = new MessageModel();
			Timestamp instant= Timestamp.from(Instant.now()); 

			messageModel.setMessages(message);
			messageModel.setMessageDate(instant);
			messageModel.setPatient(true);
			
			
			
			
			messageDao.saveMessage(messageModel);
			System.out.println(messageModel.getMessageId());
			ThreadModel threadModel = threadDao.getThreadByThreadId(threadId);
			Set<MessageModel> messages = threadModel.getMessageList();
			messages.add(messageModel);
		}
	}

}
