package com.project.user.services;

import java.util.Scanner;

import com.project.user.bean.UserTable;
import com.project.user.dao.UserDao;
import com.project.user.ui.LoginScreen;

public class UserServices implements UserServicersInterface{
	UserDao ud=new UserDao();
	LoginScreen loginscreen= new LoginScreen();
	Boolean flag=true;
	@Override
	public void login(LoginScreen ls) {
		UserTable ut=ud.loginDao(ls);
		try {
			if(ut.getLock_status().equals("active")) {
				String temp_pass=String.valueOf(ut.getTrasaction_password());
				if(ls.password.equals(ut.getPassword())||ls.password.equals(temp_pass))
				{
					if(ls.password.equals(temp_pass))
					{
						do 
						{   
							LoginScreen l=loginscreen.new_password();
							String attempt1=l.new_password;
							String attempt2=l.new_password_again;
							if(attempt1.equals(attempt2))
							{
								ut.setPassword(attempt2);
								ud.changepassword(ls, ut);
								flag=false;
							}
							else 
								ls.printStatement("Enter both the fields with same passwords");
						}while(flag);
					}
					ls.printStatement("succesful Login");
					ud.chageLockStatus(ls);
				}
				else
				{
					UserTable count=ud.changeCount(ls);
					ls.printStatement("login failed");
					int c=3-count.getLock_count();
					String s="Number attempts left : "+c;
					ls.printStatement(s);
					if(count.getLock_count()==3)
					{
						ud.changeStatus(ls);
						ls.printStatement("your account is locked . Contact admin.");
					}
				}
			}else
				ls.printStatement("Your account is locked");
		}catch(NullPointerException e) 
		{
			e.printStackTrace();
		}
	}	

	@Override
	public void forgetPassword(LoginScreen ls) {
		UserTable ut=ud.forgetpassword(ls);
		String answer = "answers";
		if(ut.getSecret_question()!=null)
		{
			System.out.println(ut.getSecret_question());
			LoginScreen l1=loginscreen.scan(1);
			answer=l1.answer;
		}
		try {
			if(ut.getSecret_answer().equals(answer))
			{
				ls.printStatement("Entered answer is correct .");
				String s="Your temporary password is password : "+ut.getTrasaction_password();
				ls.printStatement(s);
			}
		}catch (NullPointerException e) {
			ls.printStatement("Entered user ID doesn't exist");
		}
	}
}