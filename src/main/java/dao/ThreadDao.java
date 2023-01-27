package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.DoctorModel;
import model.ReportModel;
import model.ThreadModel;

public class ThreadDao {

	public void saveThread(ThreadModel threadModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(threadModel);
		transaction.commit();
		System.out.println("Inserted...");
		session.flush();
		session.close();
		con.closeSessionFactory();
	}

	public List<ThreadModel> getAllThreadByPatientId(int pid) {
		// TODO Auto-generated method stub
		String query = "from ThreadModel as thread where thread.patientModel.patientId=" + pid ;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<ThreadModel> threadModels = new ArrayList<>();
		threadModels = queryExecuteable.list();
		

		session.flush();
		session.close();
		con.closeSessionFactory();

		return threadModels;
	}

}
