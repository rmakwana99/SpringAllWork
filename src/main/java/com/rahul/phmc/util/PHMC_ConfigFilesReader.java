package com.rahul.phmc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author rahul Makvana
 *
 */
public class PHMC_ConfigFilesReader {

	/**
	 * @param SCIDR_fileName
	 * @return
	 */
	public static Properties phmc_readConfigFiles(String SCIDR_fileName){
		
		InputStream SCIDR_ins = PHMC_ConfigFilesReader.class.getClassLoader().getResourceAsStream(SCIDR_fileName);
		
		//create properties object
				Properties SCIDR_prop = new Properties();
				try {
					SCIDR_prop.load(SCIDR_ins);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return SCIDR_prop;
	}
}
