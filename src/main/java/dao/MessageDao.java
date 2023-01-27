package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.MessageModel;

public class MessageDao {

	public void saveMessage(MessageModel message) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(message);
		transaction.commit();
		System.out.println("Inserted...");
		session.flush();
		session.close();
		con.closeSessionFactory();
	}

}
