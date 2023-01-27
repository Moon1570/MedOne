package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.commons.io.IOUtils;

import dao.DoctorDao;
import dao.PatientDao;
import dao.ReportDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.DoctorModel;
import model.PatientModel;
import model.ReportModel;


@MultipartConfig
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PatientDao db = new PatientDao();
	ReportDao rdb = new ReportDao();
	DoctorDao ddb= new DoctorDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");		
		HttpSession session = request.getSession();


		String action = request.getParameter("action");



		if (action.equals("view")) {
			List<PatientModel> customerModels = db.getAllPatients();
			request.setAttribute("customers", customerModels);
			request.setAttribute("page", request.getParameter("page"));
			request.getRequestDispatcher("/Customers.jsp").forward(request, response);
		}
		else if (action.equals("reg")) {
			PatientModel customerModel = new PatientModel();

			request.setAttribute("registration", customerModel);
			request.setAttribute("action", "reg");

			request.getRequestDispatcher("/registration.jsp").forward(request, response);
		}
		else if (action.equals("login")) {

			PatientModel customerModel = new PatientModel();
			request.setAttribute("customer", customerModel);
			request.setAttribute("action", "login");


			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else if (action.equals("logout")) {



			session.removeAttribute("pid");
			session.removeAttribute("name");

			request.setAttribute("action", "login");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} 
		else if (action.equals("getImage")) {

			int pid = Integer.parseInt(request.getParameter("pid"));
			PatientModel patientModel = db.getPatientById(pid);

			byte[] image = patientModel.getPatientImage();

			OutputStream os = response.getOutputStream();
			os.write(image);
			os.flush();
			os.close();
		} 
		else if(action.equalsIgnoreCase("getMyDoctors")) {



			request.getRequestDispatcher("my_doctors.jsp").forward(request, response);

		}
		else if(action.equals("deleteDoctorFromPatientList")){
			int pid = (int) session.getAttribute("pid");
			PatientModel patientModel = db.getPatientById(pid);

			Set<DoctorModel> doctors = patientModel.getDoctors();
			int did = Integer.parseInt(request.getParameter("did"));
			
			DoctorModel doctorModel = ddb.getDoctorById(did);
			patientModel.removeDoctor(doctorModel);
			

		    
			ddb.updateDoctor(doctorModel);
			db.updatePatient(patientModel);
			request.getRequestDispatcher("my_doctors.jsp").forward(request, response);

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (action.equals("reg")) {
			PatientModel patientModel = new PatientModel();

			String patientName = request.getParameter("patientName");
			String patientPhone = request.getParameter("patientPhone");
			String patientPassword = request.getParameter("patientPassword");
			String patientAddress = request.getParameter("patientAddress");
			String bloodGroup = request.getParameter("bloodGroup");



			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
			LocalDateTime now = LocalDateTime.now();  
			String time = (dtf.format(now));

			Part part = request.getPart("patientImage");

			InputStream inputStream = null;

			// prints out some information for debugging
			//	System.out.println(part.getName());
			//		System.out.println(part.getSize());
			//		System.out.println(part.getContentType());

			// obtains input stream of the upload file




			inputStream = part.getInputStream();
			byte[] bytes = IOUtils.toByteArray(inputStream);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
			String patientDOB = request.getParameter("patientDOB");

			try {
				patientModel.setPatientDOB(simpleDateFormat.parse(patientDOB));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}


			patientModel.setPatientImage(bytes);
			patientModel.setPatientAddress(patientAddress);
			patientModel.setBloodGroup(bloodGroup);
			patientModel.setPatientName(patientName);
			patientModel.setPatientPhone(patientPhone);
			patientModel.setPatientPassword(patientPassword);

			Set<DoctorModel> doctors = new HashSet<>();

			patientModel.setDoctors(doctors);

			db.savePatient(patientModel);


			int pid = patientModel.getPatientId();
			System.out.println("line 154 " + pid);

			HttpSession session=request.getSession();
			session.setAttribute("message", "login" );
			session.setAttribute("name", patientName);
			session.setAttribute("pid", pid);

			System.out.println("Done");

			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if (action.equals("login")) {

			PatientModel patientModel = new PatientModel();

			String patientPhone = request.getParameter("patientPhone");
			String patientPassword = request.getParameter("patientPassword");

			patientModel =db.getPatientPasswordByPhone(patientPhone);


			if(patientModel==null)
			{
				request.setAttribute("message", "Account id Invalid...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else if (patientPhone.equals(patientModel.getPatientPhone()) && patientPassword.equals(patientModel.getPatientPassword())) {
				int pid = patientModel.getPatientId();

				HttpSession session=request.getSession();
				session.setAttribute("message", "" );
				session.setAttribute("name", patientModel.getPatientName());
				session.setAttribute("pid", pid);

				ReportModel reportModel = rdb.getLastReportByPatientId(pid);

				if(reportModel == null) {
					request.setAttribute("msg", "No reports uploaded yet");
				} else {
					request.setAttribute("msg", "You have uploaded at least one report");
					request.setAttribute("singleReport", reportModel);
				}

				request.getRequestDispatcher("/index.jsp").forward(request, response);

			}

			else {
				request.setAttribute("message", "Wrong Account id or  password...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} 
		else if (action.equalsIgnoreCase("addRelativesByPhone")) {
			String relativePhone= request.getParameter("relativePhoneNumber");
			HttpSession session=request.getSession();

			PatientModel relativeModel = db.getPatientByphone(relativePhone);
			int pid = (int) session.getAttribute("pid");

			PatientModel patientModel = db.getPatientById(pid);


			if(relativeModel == null) {
				request.setAttribute("relStatus", "0");
			} else if(relativeModel.getPatientId() == pid){
				request.setAttribute("relStatus", "2");
			} 
			else {
				Map<Integer, String> relativeMap = patientModel.getRelatives();
				if (relativeMap.isEmpty()) {
					request.setAttribute("relStatus", "1");
					request.setAttribute("relative", relativeModel);
				} else if(relativeMap.containsKey(relativeModel.getPatientId())){
					request.setAttribute("relStatus", "3");
					request.setAttribute("relative", relativeModel);
				} else {
					request.setAttribute("relStatus", "1");
					request.setAttribute("relative", relativeModel);
				}
			}
			System.out.println(patientModel.getRelatives().toString());
			request.getRequestDispatcher("/view_relative.jsp").forward(request, response);
		} else if(action.equalsIgnoreCase("addRelationship")) {
			HttpSession session = request.getSession();
			int pid = (int) session.getAttribute("pid");
			int rid = Integer.parseInt(request.getParameter("rid"));
			String relationName = request.getParameter("relationName");

			PatientModel patientModel = db.getPatientById(pid);
			Map<Integer, String> relativeMap = patientModel.getRelatives();

			relativeMap.put(rid, relationName);
			patientModel.setRelatives((HashMap<Integer, String>) relativeMap);
			db.updatePatient(patientModel);
			request.setAttribute("rmsg", "relative added");
			request.getRequestDispatcher("/index.jsp").forward(request, response);


		} else if(action.equalsIgnoreCase("addDoctorsByPhone")) {
			String doctorsPhone= request.getParameter("doctorPhoneNumber");
			HttpSession session=request.getSession();

			DoctorModel doctorModel = ddb.getDoctorByPhone(doctorsPhone);
			int pid = (int) session.getAttribute("pid");

			request.setAttribute("docStatus", "1");
			request.setAttribute("doctor", doctorModel);

			request.getRequestDispatcher("/view_doctor.jsp").forward(request, response);

		} else if (action.equals("addDoctor")) {
			int did = Integer.parseInt(request.getParameter("did"));
			DoctorModel doctorModel = ddb.getDoctorById(did);

			HttpSession session = request.getSession();
			int pid = (int) session.getAttribute("pid");
			PatientModel patientModel = db.getPatientById(pid);

			Set<PatientModel> patients = doctorModel.getPatients();
			patients.add(patientModel);
			ddb.updateDoctor(doctorModel);
			request.getRequestDispatcher("index.jsp").forward(request, response);


		}
	}

}
