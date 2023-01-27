package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.DoctorModel;
import model.MessageModel;
import model.PatientModel;
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

	public ThreadModel getThreadByThreadId(int threadId) {
		// TODO Auto-generated method stub
		String query = "from ThreadModel thread where thread.id=" + threadId;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		
		
		Query queryExecuteable = session.createQuery(query);
		ThreadModel thread = (ThreadModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return thread;
	}

	public void updateThread(ThreadModel threadModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.update(threadModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Updated...");
	}

}
