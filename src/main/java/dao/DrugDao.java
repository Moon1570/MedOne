package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.DrugModel;
import model.ReportModel;

public class DrugDao {

	public List<DrugModel> getAllDrugs() {
		// TODO Auto-generated method stub
		List<DrugModel> drugModels = new ArrayList<>();
		String query = "from DrugModel drug";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from DrugModel drug");
		drugModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return drugModels;
	}

}
