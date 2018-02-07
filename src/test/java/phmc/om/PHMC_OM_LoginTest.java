package phmc.om;

import org.junit.Assert;
import org.junit.Test;

import com.rahul.phmc.om.login.model.PHMC_OM_LOGIN;
import com.rahul.phmc.om.login.services.PHMC_OM_LoginService;
import com.rahul.phmc.util.ErrorMessage;

public class PHMC_OM_LoginTest {

	ErrorMessage msg=new ErrorMessage();
	PHMC_OM_LOGIN login= new PHMC_OM_LOGIN();
	PHMC_OM_LoginService loginService= new PHMC_OM_LoginService();
	
	/*@Test
	public void testPhmc_phob_readLoginDetail() {
		login=loginService.phmc_phob_readLoginDetail("rahul123");
		Assert.assertEquals("U2FsdGVkX1+8XGchsDVSN5eXVeLlgHHDidfrpWpXxRQ=", login.getPHMC_OM_Password());
	}*/


	@Test
	public void testPhmc_phob_createUpdateLoginDetail() {
		login= new PHMC_OM_LOGIN();
		login.setPHMC_OM_UserName("rahul123");
		login.setPHMC_OM_Email("rony@ymail.com");
		login.setPHMC_OM_Password("main123");
		login.setPHMC_OM_Lead("00");
		
		msg=loginService.phmc_phob_createUpdateLoginDetail("rahul123", login);
		Assert.assertEquals(200, msg.getErrorCode());
	}

}
