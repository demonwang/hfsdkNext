package com.hf.hfsdknext;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.JsonWriter;

import com.hf.info.MainUserInfo;
import com.hf.itf.IUserDataContentor;
import com.hf.util.ModuleException;

public class UserDataContentor extends JSONObject implements IUserDataContentor{
	private static final String _USER_DATA = "_USER_DATA";
	private static final String _USER_DATA_INSTENCE = "_USER_DATA_INSTENCE";
	
	public static String FIRSTRUN 		= "FIRSTRUN";
	public static String REGISTED 		= "REGISTED";
	public static String LASTRUNTIME 	= "LASTRUNTIME";
	public static String LASTRUNSTATE 	= "LASTRUNSTATE";
	public static String SERVDOMAIN 	= "SERVDOMAIN";
	public static String LOCALPORT 		= "LOCALPORT";
	public static String MAINUSER 			= "MAINUSER";
	public static String SHAREDUSER 		= "SHAREDUSER";
	
	
	
	private boolean isFristrun = true;
	private boolean isRegisted = true;
	private String lastRunTime = "20140612";// YYYYMMDD
	private boolean lastRunState = true; // true remote ,fase local
	private String serverDomain = "www.iotworkshop.com";
	private int localPort = 38899;
	
	private MainUserInfo mainUser;
	
	//private sharedUser;
	
	private SharedPreferences sp ;
	
	private static UserDataContentor me = null;
	
	private static UserDataContentor getInstence(){
		if(me == null){
			me = new UserDataContentor();
		}
		return me;
	}
	
	@Override
	public void init(Context ctx) throws ModuleException {
		// TODO Auto-generated method stub
		sp = ctx.getSharedPreferences(_USER_DATA, Context.MODE_PRIVATE);
		String data = sp.getString(_USER_DATA_INSTENCE, "{}");
		decodeJson(data);
	}
	
	private void decodeJson(String data) throws ModuleException{
		try {
			JSONObject js = new JSONObject(data);
			Iterator<String> it = js.keys();
			while(it.hasNext()){
				String key = it.next();
				this.put(key, js.get(key));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			throw new ModuleException(ModuleException.ERRCODE_CANNOT_FIND_USERDATA_LOCAL, e.getMessage());
		}
	}
	
	
	
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		Editor e = sp.edit();
		e.putString(_USER_DATA_INSTENCE, this.toString());
		e.commit();
	}

	@Override
	public MainUserInfo getMainUserInfo() {
		// TODO Auto-generated method stub
		if(mainUser == null){
			mainUser = new MainUserInfo(this);
		}
		return mainUser;
	}
}
