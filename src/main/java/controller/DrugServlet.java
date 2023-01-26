package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DrugModel;
import model.ReportModel;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;



import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dao.DrugDao;

/**
 * Servlet implementation class DrugServlet
 */

public class DrugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DrugDao db = new DrugDao();
	
    public DrugServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("getAllDrugs")) {
			List<DrugModel> drugModels = db.getAllDrugs();
			request.setAttribute("drugs", drugModels);

			/*
			com.google.gson.JsonObject gson = new JsonObject();
			com.google.gson.JsonArray array = new JsonArray();

			Iterator<DrugModel> it = drugModels.iterator();
			int count = 0;
			while (it.hasNext()) {
				Object type = (Object) it.next();
				JsonObject item = new JsonObject();
				DrugModel sub =  (DrugModel) type;
				count++;

				item.addProperty("id", sub.getDrugId()+"");
				item.addProperty("name", sub.getBrandName());
				item.addProperty("type", sub.getType());
				item.addProperty("manufacturer", sub.getManufacturer());

				try {
					array.add(item);
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

			gson.add("demo", array); 

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			response.getWriter().write(gson.toString());
			
			*/
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
