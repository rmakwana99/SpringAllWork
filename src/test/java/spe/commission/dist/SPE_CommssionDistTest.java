package spe.commission.dist;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rahul.phmc.sdp.commssion.dist.dao.SPE_CommssionDistDAO;
import com.rahul.phmc.sdp.commssion.dist.model.SPE_CommissionDist;

/**
 * @author SrishtiESDM-Prakash
 *
 */
public class SPE_CommssionDistTest {

	SPE_CommssionDistDAO distDao;
	List<SPE_CommissionDist> commissionList;

	@Before
	public void createDaoObject() {
		distDao = new SPE_CommssionDistDAO();
		Assert.assertNotNull(distDao);
	}

	@Test
	public void updateCommission() {
		//distDao.updateCommission("");
		System.out.println("done!");
	}
}
