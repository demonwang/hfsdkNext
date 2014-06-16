package com.hf.itf;

import java.util.ArrayList;
import java.util.Hashtable;

import android.content.Context;

import com.hf.info.ModuleInfo;

public interface ILocalModuleContentor {
	void init(Context ctx);
	
	ArrayList<ModuleInfo> getAll();
	Hashtable<String, ModuleInfo> getByMap();
	ModuleInfo get(String mac);
	
	void reMoveAll();
	void delete(String mac);
	
	void addModule(ModuleInfo mi);
	void addAll(ArrayList<ModuleInfo> mis);
}
