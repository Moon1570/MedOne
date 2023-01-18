package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.DoctorModel;
import model.PatientModel;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.IOUtils;

import dao.DoctorDao;
import dao.PatientDao;

/**
 * Servlet implementation class DoctorServlet
 */

@MultipartConfig
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	DoctorDao db = new DoctorDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");		
		HttpSession session = request.getSession();
		
		
		String action = request.getParameter("action");


		
		System.out.println(session.getAttribute("cid"));
		if (action.equals("reg")) {
			
			
			request.getRequestDispatcher("/doctor_registration.jsp").forward(request, response);
		} 
		else if (action.equals("login")) {
			
		
			request.getRequestDispatcher("/doctor_login.jsp").forward(request, response);
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
		if (action.equals("reg")) {
			DoctorModel doctorModel = new DoctorModel();
			
			String doctorName = request.getParameter("doctorName");
			String doctorPhone = request.getParameter("doctorPhone");
			String doctorPassword = request.getParameter("doctorPassword");
			String doctorAddress = request.getParameter("doctorAddress");
			
			
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
			LocalDateTime now = LocalDateTime.now();  
			String time = (dtf.format(now));
			
			Part part = request.getPart("doctorImage");
						
			Part part2 = request.getPart("doctorCert");

			InputStream inputStream = null;
			InputStream inputStream2 = null;

			// prints out some information for debugging
		//	System.out.println(part.getName());
	//		System.out.println(part.getSize());
	//		System.out.println(part.getContentType());

			// obtains input stream of the upload file

			System.out.println(part);
			
			
			
			inputStream = part.getInputStream();
			byte[] imageByte = IOUtils.toByteArray(inputStream);
			
			inputStream2 = part2.getInputStream();
			byte[] certByte = IOUtils.toByteArray(inputStream2);
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
			String doctorDOB = request.getParameter("doctorDOB");
			
			try {
				doctorModel.setDoctorDOB(simpleDateFormat.parse(doctorDOB));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			doctorModel.setDoctorImage(imageByte);
			doctorModel.setDoctorCert(certByte);
			doctorModel.setDoctorAddress(doctorAddress);
			doctorModel.setDoctorName(doctorName);
			doctorModel.setDoctorPhone(doctorPhone);
			doctorModel.setDoctorPassword(doctorPassword);
			
		
			db.saveDoctor(doctorModel);
	

			int did = doctorModel.getDoctorId();
			System.out.println("line 154 " + did);
			
			HttpSession session=request.getSession();
			session.setAttribute("message", "login" );
			session.setAttribute("dname", doctorName);
			session.setAttribute("did", did);
			
			System.out.println("Done");
			
			request.getRequestDispatcher("/doctor_dashboard.jsp").forward(request, response);
		}
		
else if (action.equals("login")) {
			
			DoctorModel doctorModel = new DoctorModel();
			
			String doctorPhone = request.getParameter("doctorPhone");
			String doctorPassword = request.getParameter("doctorPassword");
			
			doctorModel =db.getDoctorPasswordByPhone(doctorPhone);
			
			
			if(doctorModel==null)
			{
				request.setAttribute("message", "Account id Invalid...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/doctor_login.jsp").forward(request, response);
			}
			else if (doctorPhone.equals(doctorModel.getDoctorPhone()) && doctorPassword.equals(doctorModel.getDoctorPassword())) {
				int did = doctorModel.getDoctorId();
				
				HttpSession session=request.getSession();
				session.setAttribute("message", "" );
				session.setAttribute("dname", doctorModel.getDoctorName());
				session.setAttribute("did", did);
				
				request.getRequestDispatcher("/doctor_dashboard.jsp").forward(request, response);

			
			}
			
			else {
				request.setAttribute("message", "Wrong Account id or  password...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/doctor_login.jsp").forward(request, response);
			}
		} 
		
	}

}
