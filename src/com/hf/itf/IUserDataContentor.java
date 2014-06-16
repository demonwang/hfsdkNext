package com.hf.itf;

import com.hf.info.MainUserInfo;
import com.hf.util.ModuleException;

import android.content.Context;

public interface IUserDataContentor {
	void init(Context ctx) throws ModuleException;
	void save();
	MainUserInfo getMainUserInfo();
}
