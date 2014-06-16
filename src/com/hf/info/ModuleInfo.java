package com.hf.info;

import org.json.JSONObject;

public class ModuleInfo {
	private String mac;
	
	
	
	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	
	/*******************************************************/
	public void fromStrJson(String json){
		
	}
	
	public JSONObject toJSon(){
		return null;
	}
	public String toString(){
		return toJSon().toString();
	}
}
