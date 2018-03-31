package com.project.user.dao;

import com.project.user.bean.UserTable;
import com.project.user.ui.LoginScreen;

public interface UserDaoInterface {
	public UserTable loginDao(LoginScreen l1);
	public UserTable forgetpassword(LoginScreen ls);
	public void changepassword(LoginScreen ls,UserTable ut1);
	public UserTable changeCount(LoginScreen ls);
	public void changeStatus(LoginScreen ls) ;
	public void chageLockStatus(LoginScreen ls);
}
