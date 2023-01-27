package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.DoctorModel;
import model.PatientModel;
import model.ReportModel;

public class DoctorDao {

	public void saveDoctor(DoctorModel doctorModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(doctorModel);
		transaction.commit();
		System.out.println("Inserted...");
		session.flush();
		session.close();
		con.closeSessionFactory();
	}

	public DoctorModel getDoctorPasswordByPhone(String doctorPhone) {
		String query = "from DoctorModel doctor where doctor.doctorPhone='"+doctorPhone+"'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);
		DoctorModel customerModel = null;
		try {
			customerModel = (DoctorModel) queryExecuteable.list().get(0);
		} catch (Exception e) {
		System.out.println("Problem with login... + " + doctorPhone + " got it?");
		}

		//SignupModel signupModel = (SignupModel) queryExecuteable.list().get(0);
		System.out.println(customerModel);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return customerModel;
	}

	public PatientModel getPatientByPhone(String phone) {
		// TODO Auto-generated method stub
		String query = "from PatientModel patient where patient.patientPhone='"+phone+"'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);
		PatientModel patient = null;
		try {
			patient = (PatientModel) queryExecuteable.list().get(0);
		} catch (Exception e) {
		System.out.println("Problem with login... + " + patient + " got it?");
		}

		//SignupModel signupModel = (SignupModel) queryExecuteable.list().get(0);
		System.out.println(patient);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return patient;
	}

	public DoctorModel getDoctorById(int did) {
		// TODO Auto-generated method stub
		String query = "from DoctorModel doctor where doctor.doctorId=" + did;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		
		
		Query queryExecuteable = session.createQuery(query);
		DoctorModel doctor = (DoctorModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return doctor;
		
	}

	public void updateDoctor(DoctorModel doctorModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.update(doctorModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Updated...");
	}

	public DoctorModel getDoctorByPhone(String doctorsPhone) {
		// TODO Auto-generated method stub
		String query = "from DoctorModel doctor where doctor.doctorPhone=" + doctorsPhone;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		
		Query queryExecuteable = session.createQuery(query);
		if(queryExecuteable.list().isEmpty()) {
			return null;
		} else {
			DoctorModel doctors = (DoctorModel) queryExecuteable.list().get(0);
			session.flush();
			session.close();
			con.closeSessionFactory();
			return doctors;
		}
	}

	public List<DoctorModel> getAllDoctorsByPatientId(int pid) {
		// TODO Auto-generated method stub
		String query = "from DoctorModel d join d.patients p where p.patientId=:id";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<DoctorModel> doctors=new ArrayList<>();
		doctors = queryExecuteable.list();
		

		session.flush();
		session.close();
		con.closeSessionFactory();

		return doctors;
	}

}
