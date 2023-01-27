package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
