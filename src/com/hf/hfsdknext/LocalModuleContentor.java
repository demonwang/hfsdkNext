package com.hf.hfsdknext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.hf.info.ModuleInfo;
import com.hf.itf.ILocalModuleContentor;

public class LocalModuleContentor implements ILocalModuleContentor{
	private static String LOCAL_MODULE_SP = "LOCAL_MODULE_SP";
//	private static String LOCAL_MODULE_MAC_LIST = "LOCAL_MODULE_MAC_LIST";
	private static LocalModuleContentor me = null;
	private SharedPreferences sp = null;
	
	private Hashtable<String, ModuleInfo> moduleList = new Hashtable<String, ModuleInfo>();
	
	public static LocalModuleContentor getInstence(){
		if(me == null){
			me = new LocalModuleContentor();
		}
		return me;
	}
	
	@Override
	public void init(Context ctx) {
		// TODO Auto-generated method stub
		sp = ctx.getSharedPreferences(LOCAL_MODULE_SP, Context.MODE_PRIVATE);
		Map<String, ?> mis = sp.getAll();
		Iterator<String> it = mis.keySet().iterator();
		while(it.hasNext()){
			String mi = (String) mis.get(it.next());
			ModuleInfo module = new ModuleInfo();
			module.fromStrJson(mi);
			moduleList.put(module.getMac(), module);
		}
	}

	@Override
	public ArrayList<ModuleInfo> getAll() {
		// TODO Auto-generated method stub
		ArrayList<ModuleInfo> mis =  new ArrayList<>();
		Iterator<String> it = moduleList.keySet().iterator();
		while(it.hasNext()){
			mis.add(moduleList.get(it.next()));
		}
		return mis;
	}

	@Override
	public ModuleInfo get(String mac) {
		// TODO Auto-generated method stub
		return moduleList.get(mac);
	}

	@Override
	public void reMoveAll() {
		// TODO Auto-generated method stub
		Editor e = sp.edit();
		e.clear();
		e.commit();
		moduleList.clear();
	}

	@Override
	public void delete(String mac) {
		// TODO Auto-generated method stub
		Editor e = sp.edit();
		e.remove(mac);
		e.commit();
		moduleList.remove(mac);
	}

	@Override
	public void addModule(ModuleInfo mi) {
		// TODO Auto-generated method stub
		Editor e = sp.edit();
		e.putString(mi.getMac(), mi.toJSon().toString());
		e.commit();
		moduleList.put(mi.getMac(), mi);
	}

	@Override
	public void addAll(ArrayList<ModuleInfo> mis) {
		// TODO Auto-generated method stub
		this.reMoveAll();
		Iterator<ModuleInfo> it = mis.iterator();
		while(it.hasNext()){
			addModule(it.next());
		}
	}

	@Override
	public Hashtable<String, ModuleInfo> getByMap() {
		// TODO Auto-generated method stub
		return moduleList;
	}
	
}
