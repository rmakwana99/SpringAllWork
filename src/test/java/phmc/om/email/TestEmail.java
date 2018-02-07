package phmc.om.email;

import org.junit.Test;

import com.rahul.phmc.util.email.session.SPE_EmailSession;

public class TestEmail {
	
	@Test
	public void sendEmail(){		
		//create session object
		
		SPE_EmailSession session =  new SPE_EmailSession();
		String to = "tekamchandraprakash@gmail.com";
		String subject = "New Report";
		String body = "Hi </br> Report Attached.";
		//add absolute path path of report file  if not then set as null
		String filePath = null; //"E:\\CAMP\\Test Script File\\sopdb Test Data VO1.02 30MAY2017.xlsx";
		session.sendEmail(to, subject, body, filePath);
	}

}
