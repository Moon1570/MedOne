package dao;

import org.hibernate.Query;
import org.hibernate.Session;

import model.AdminModel;

public class AdminDao {
	
	public AdminModel getAdminPasswordByPhone(String adminPhone) {
		// TODO Auto-generated method stub
		String query = "from AdminModel admin where admin.adminPhone='"+adminPhone+"'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);
		AdminModel adminModel = null;
		try {
			adminModel = (AdminModel) queryExecuteable.list().get(0);
		} catch (Exception e) {
		System.out.println("Problem with login...");
		}
		//SignupModel signupModel = (SignupModel) queryExecuteable.list().get(0);
		System.out.println(adminModel);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return adminModel;
	}
	
	public AdminModel getAdminByphone(String phone) {
		// TODO Auto-generated method stub
		String query = "from adminModel admin where admin.adminPhone=" + phone;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		
		Query queryExecuteable = session.createQuery(query);
		if(queryExecuteable.list().isEmpty()) {
			return null;
		} else {
			AdminModel admin = (AdminModel) queryExecuteable.list().get(0);
			session.flush();
			session.close();
			con.closeSessionFactory();
			return admin;
		}
		
	}

}
