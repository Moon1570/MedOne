package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.PatientModel;
import model.ReportModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.IOUtils;

import dao.PatientDao;
import dao.ReportDao;

/**
 * Servlet implementation class ReportServlet
 */

@MultipartConfig

public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ReportDao db = new ReportDao();
	PatientDao pdb = new PatientDao();


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");		
		HttpSession session = request.getSession();
		
		
		String action = request.getParameter("action");


		
		int pid = (int) session.getAttribute("pid");
		
		if (action.equals("viewAll")) {
			List<ReportModel> reportModels = db.getAllReportByPatientId(pid);
			System.out.println(reportModels.get(0).getReportName());
			request.setAttribute("reports", reportModels);
			System.out.println("Viewing All");
			request.getRequestDispatcher("/view_reports.jsp").forward(request, response);
		}
		else if(action.equals("viewReport")) {
			int rid = Integer.parseInt(request.getParameter("rid"));
			ReportModel reportModel = db.getReportByReportId(rid);
			if(reportModel.isImage()) {
				byte[] image = reportModel.getReportFile();

				/*
								response.setContentType("application/pdf");

								response.addHeader("Content-Disposition", "attachment; filename="+reportModel.getReportName()+".pdf");
								response.setStatus(HttpServletResponse.SC_OK);
								OutputStream out = response.getOutputStream();
								System.out.println(pdfData.length);
								         
								out.write(pdfData);
								System.out.println("sendDone");
								out.flush();
								
								*/
								OutputStream os = response.getOutputStream();
								os.write(image);
								os.flush();
								os.close();
			}
			else {
				byte[] pdfData = reportModel.getReportFile();

/*
				response.setContentType("application/pdf");

				response.addHeader("Content-Disposition", "attachment; filename="+reportModel.getReportName()+".pdf");
				response.setStatus(HttpServletResponse.SC_OK);
				OutputStream out = response.getOutputStream();
				System.out.println(pdfData.length);
				         
				out.write(pdfData);
				System.out.println("sendDone");
				out.flush();
				
				*/
				OutputStream os = response.getOutputStream();
				os.write(pdfData);
				os.flush();
				os.close();
				
			}
			
		}
		else if(action.equals("downloadReport")) {
			int rid = Integer.parseInt(request.getParameter("rid"));
			ReportModel reportModel = db.getReportByReportId(rid);
			if(reportModel.isImage()) {
				byte[] image = reportModel.getReportFile();

								response.setContentType("application/pdf");

								response.addHeader("Content-Disposition", "attachment; filename="+reportModel.getReportName()+".jpeg");
								response.setStatus(HttpServletResponse.SC_OK);
								OutputStream out = response.getOutputStream();
								System.out.println(image.length);
								         
								out.write(image);
								System.out.println("sendDone");
								out.flush();
								

			}
			else {
				byte[] pdfData = reportModel.getReportFile();

				response.setContentType("application/pdf");

				response.addHeader("Content-Disposition", "attachment; filename="+reportModel.getReportName()+".pdf");
				response.setStatus(HttpServletResponse.SC_OK);
				OutputStream out = response.getOutputStream();
				System.out.println(pdfData.length);
				         
				out.write(pdfData);
				System.out.println("sendDone");
				out.flush();
				

			}
			
		}
		else if(action.equals("viewReportFullScreen")) {
			int rid = Integer.parseInt(request.getParameter("rid"));
			ReportModel reportModel = db.getReportByReportId(rid);
		
				request.setAttribute("report", reportModel);
				request.getRequestDispatcher("/full_screen_report.jsp").forward(request, response);

		}
		else if(action.equalsIgnoreCase("deleteReport")) {
			int rid = Integer.parseInt(request.getParameter("rid"));
			ReportModel reportModel = db.getReportByReportId(rid);
			db.deleteReport(reportModel);
			response.sendRedirect("./report?action=viewAll");
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
		
		if (action.equals("reportUpload")) {
			
			String reportName = request.getParameter("reportName");
			
			
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
			LocalDateTime now = LocalDateTime.now();  
			String time = (dtf.format(now));
			
			Timestamp instant= Timestamp.from(Instant.now()); 
			System.out.println(instant);
			
			Part part = request.getPart("reportImage");
						
			InputStream inputStream = null;
			
			
			
			inputStream = part.getInputStream();
			byte[] bytes = IOUtils.toByteArray(inputStream);
			
			ReportModel model = new ReportModel();
		
			HttpSession session=request.getSession();
			
			int pid = (int) session.getAttribute("pid");
			
			PatientModel patientModel = pdb.getPatientById(pid);
			
			
			model.setImage(true);
			model.setReportFile(bytes);
			model.setReportCreateDate(instant);
			model.setReportModifyDate(instant);
			model.setPatient(patientModel);
			model.setReportName(reportName);
			
			String fileType = part.getContentType();
			if (fileType.contains("pdf")) {
				model.setImage(false);
			} else if (fileType.contains("image")) {
				model.setImage(true);
			}
			db.saveReport(model);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);

		}
		
	}

}
