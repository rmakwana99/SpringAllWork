package phmc.connection;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.rahul.phmc.util.Payhind_DBManager;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

public class TestPayhindConnection {


	@Test
	public void getPayhindConn() throws ClassNotFoundException, SQLException {

		Connection conn = Payhind_DBManager.payhind_getConnection();
		Assert.assertNotNull(conn);
		conn.close();

	}

	@Test
	public void getHiberenatePayhindConn() {
		
		Session session=null;
		try{
			session = PayhindHibernateUtil.getSessionFactory().openSession();
			Assert.assertNotNull(session);
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}


}
