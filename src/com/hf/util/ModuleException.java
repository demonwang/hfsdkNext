package com.hf.util;

public class ModuleException extends Exception{
	
	public static final int ERRCODE_CANNOT_FIND_USERDATA_LOCAL = -100;
	
	
	
	
	
	
	private int errorCode = 0;
	
	public ModuleException(int errcode,String e){
		super(e);
		this.errorCode = errcode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}	
}
