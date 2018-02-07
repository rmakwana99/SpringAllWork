/*
	* Copyright (C) 2017 Srishti ESDM Pvt Ltd.
	*
	* This file is property of Srishti ESDM Pvt Ltd and must not be copied, reused or distributed
	* without prior approval and agreement with Srishti ESDM Pvt Ltd.
	*
	* This file is allowed only for Srishti internal use and is a confidential property.
	*/
package spe.spd.settlement;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.rahul.phmc.spe.sdp.services.SPE_SDP_GetListOfSettlement;

public class SDP_SettlementTest {

	@Test
	public void testSPE_convertStringToDate() {
		Date date=new Date("03-Apr-2017 14:11:30");
		try {
			Assert.assertEquals(date, SPE_SDP_GetListOfSettlement.SPE_convertStringToDate("03-Apr-2017 14:11:30"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
