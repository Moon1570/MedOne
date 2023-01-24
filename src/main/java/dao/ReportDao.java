package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.ReportModel;

public class ReportDao {

	public void saveReport(ReportModel model) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(model);
		transaction.commit();
		System.out.println("Inserted...");
		session.flush();
		session.close();
		con.closeSessionFactory();
	}

	public List<ReportModel> getAllReportByPatientId(int pid) {
		// TODO Auto-generated method stub
		String query = "from ReportModel as report where report.patient.patientId=" + pid ;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<ReportModel> reportModels=new ArrayList<>();
		reportModels = queryExecuteable.list();
		/*
		java.util.Iterator<CartDetailsModel> it = cartDetailsModels.iterator();

		List<CartDetailsModel> cartDetailsModels2 = new ArrayList<CartDetailsModel>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			CartDetailsModel sub =  (CartDetailsModel) type;
			if (sub.getCartId().getCartId() == cartId) {
				cartDetailsModels2.add(sub);
				
				System.out.println(cartDetailsModels);
			}

		}
		*/

		session.flush();
		session.close();
		con.closeSessionFactory();

		return reportModels;
	}



}
