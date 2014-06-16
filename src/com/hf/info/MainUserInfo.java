package com.hf.info;

import com.hf.hfsdknext.UserDataContentor;
import com.hf.itf.IUserDataContentor;

public class MainUserInfo extends UserInfo  {	
	public static final String USER = "USER";
	public static final String SHOWNAME = "SHOWNAME";
	public static final String PASSWORD = "PASSWORD";
	public static final String PHONE = "PHONE";
	public static final String EMAIL = "EMAIL";
	private UserDataContentor uc ;
	public MainUserInfo(UserDataContentor uc){
		this.uc = uc;
		
	} 
}
