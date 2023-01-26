package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.ietf.jgss.Oid;

import dao.Connection;
import javassist.bytecode.Descriptor.Iterator;

import model.PatientModel;
import model.ReportModel;


public class PatientDao {
	int counter=0;

	public List<PatientModel> getAllPatients() {
		// TODO Auto-generated method stub
		List<PatientModel> customerModels = new ArrayList<>();
		String query = "from CustomerModel customerModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from CustomerModel customerModels");
		customerModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return customerModels;
	}

	public PatientModel getPatientById(int id) {
		
		/*
		String query = "from CustomerModel customer where customer.id=" + id;
		
		Session session = Connection.getSessionFactory().openSession();
		

		
		
		Query queryExecuteable = session.createQuery(query);
		CustomerModel customer = (CustomerModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		Connection.shutdown();
		return customer;
		
		*/
		
		String query = "from PatientModel patient where patient.id=" + id;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		
		
		Query queryExecuteable = session.createQuery(query);
		PatientModel patient = (PatientModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return patient;
		
		
	}

	public void savePatient(PatientModel patientModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(patientModel);
		transaction.commit();
		System.out.println("Inserted...");
		session.flush();
		session.close();
		con.closeSessionFactory();
	}

	public PatientModel getPatientPasswordByPhone(String patientPhone) {
		// TODO Auto-generated method stub
		String query = "from PatientModel patient where patient.patientPhone='"+patientPhone+"'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);
		PatientModel customerModel = null;
		try {
			customerModel = (PatientModel) queryExecuteable.list().get(0);
		} catch (Exception e) {
		System.out.println("Problem with login...");
		}
		//SignupModel signupModel = (SignupModel) queryExecuteable.list().get(0);
		System.out.println(customerModel);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return customerModel;
	}


	public ArrayList<PatientModel> getPatientPasswordByPhoneList(String phone, String pass) {
		// TODO Auto-generated method stub
	
		
		String query = "from PatientModel patient";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		ArrayList<PatientModel> customerModels=new ArrayList<>();
		customerModels = (ArrayList<PatientModel>) queryExecuteable.list();

		java.util.Iterator<PatientModel> it = customerModels.iterator();

		ArrayList<PatientModel> customerModels2 = new ArrayList<PatientModel>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			PatientModel sub =  (PatientModel) type;
				System.out.println("match");
				customerModels2.add(sub);
			
		}
		
		session.flush();
		session.close();

		con.closeSessionFactory();
		return customerModels2;
		
	}

	

	public PatientModel getPatientByphone(String phone) {
		// TODO Auto-generated method stub
		String query = "from PatientModel patient where patient.patientPhone=" + phone;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		
		Query queryExecuteable = session.createQuery(query);
		if(queryExecuteable.list().isEmpty()) {
			return null;
		} else {
			PatientModel patient = (PatientModel) queryExecuteable.list().get(0);
			session.flush();
			session.close();
			con.closeSessionFactory();
			return patient;
		}
		
	}


	public void deletePatient(PatientModel customerModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.delete(customerModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Deleted...");
	}

	public void updatePatient(PatientModel patientModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.update(patientModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Updated...");
	}



}
