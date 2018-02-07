package com.rahul.phmc.sopdb.exception;

/**
 * @author rahul
 *
 */
public class SOPDB_NotFoundException extends  RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7096082315117550045L;

	public SOPDB_NotFoundException( String message){
		super(message);
		
	}
}
