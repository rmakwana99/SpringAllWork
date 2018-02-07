package spe.amazon.earning;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.rahul.phmc.spe.sdp.dao.SPE_DAILY_AMAZON_EARNING_DEPOTModelDAO;
import com.rahul.phmc.spe.sdp.model.SPE_DAILY_AMAZON_EARNING_DEPOTModel;

public class AmzonEarningDepotTest {
	@Test
	public void testInsertion() {

		List<SPE_DAILY_AMAZON_EARNING_DEPOTModel> list = new ArrayList<>();
       int count = 0;
		for (int i = 0; i < 40; i++) {
			SPE_DAILY_AMAZON_EARNING_DEPOTModel model = new SPE_DAILY_AMAZON_EARNING_DEPOTModel();
			model.setSPE_TxnID("20170809114609"+ (count++));
			list.add(model);
		}
		
		SPE_DAILY_AMAZON_EARNING_DEPOTModelDAO dao =  new SPE_DAILY_AMAZON_EARNING_DEPOTModelDAO();
		
	   dao.spe_sdp_uploadAmazonEaring(list);
	   
	   Assert.assertNotNull(" Earning List Not Null", list);

	}

}
