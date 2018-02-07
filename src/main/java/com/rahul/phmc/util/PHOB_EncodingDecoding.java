package com.rahul.phmc.util;

import java.util.Base64;

/**
 * @author rahul Makvana
 *
 */
public class PHOB_EncodingDecoding {

	public static void main(String args[]) {
		String base64 = "Rk1SACAyMAAAAADYAAABCAFEAMUAxQEAAABkH0CwAB3sZIDjACRlZEBvAC2NZEC7AC9vZEDLAEneZEDfAE7dZECCAFaVZICIAFkNZIAxAF2qZICoAGByZIDRAGtaZECNAHChZEBXAHKrZEDbAHLYZEBCAHatZEC7AIZgZEAwAIiyZEDNAItWZECfAJiwZICrAKfSZEDFAKlVZEClAK/IZEA3AMa9ZEAuAMu0ZICLANDNZECxANzLZEArAPSxZID0APdXZECHAQ7RZEAnARPEZICJASxQZAAA";
	
		
	    byte[] decodedSting = Base64.getDecoder().decode(base64.getBytes());
		
		System.out.println("decode string : " + new String(decodedSting));
		
	}

}
