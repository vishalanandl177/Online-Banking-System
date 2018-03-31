package com.project.user.dao;

import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import java.sql.SQLException;
import java.util.Random;

import com.project.helper.ConnectToDB;
import com.project.user.bean.UserTable;
import com.project.user.ui.LoginScreen;

public class UserDao implements UserDaoInterface{
	private Connection con=null;
	private PreparedStatement prepareState=null;
	private PreparedStatement prepareState1=null;
	private ResultSet res=null;
	@Override
	public UserTable loginDao(LoginScreen l1) {
		UserTable ut=new UserTable();
		try {
			con=ConnectToDB.createConnection();
			prepareState=con.prepareStatement("select login_password,lock_status,transaction_password from user_table where user_id=?");

			prepareState.setInt(1, l1.userID);
			res=prepareState.executeQuery();
			while(res.next()){
				ut.setLock_status(res.getString(2));
				ut.setPassword(res.getString(1));
				ut.setTrasaction_password(res.getInt(3));
			}
			con.close();
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ut;
	}
	@Override
	public UserTable forgetpassword(LoginScreen ls) {
		UserTable ut= new UserTable();
		try {
			con=ConnectToDB.createConnection();
			prepareState=con.prepareStatement("select secret_question,secret_answer,transaction_password from user_table where user_id=?");
			prepareState1=con.prepareStatement("update user_table set lock_count=0,lock_status='active'");
			prepareState.setInt(1, ls.userID);
			res=prepareState.executeQuery();
			prepareState1.executeUpdate();
			while(res.next()) {
				ut.setSecret_question(res.getString(1));
				ut.setSecret_answer(res.getString(2));
				ut.setTrasaction_password(res.getInt(3));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ut;
	}
	@Override
	public void changepassword(LoginScreen ls,UserTable ut1) {
		UserTable ut= new UserTable();
		try {
			con=ConnectToDB.createConnection();
			prepareState=con.prepareStatement("update user_table set login_password=?,transaction_password=?,lock_count=0,lock_status='active' where user_id=?");
			prepareState.setInt(3, ls.userID);
			int maximum=10000;
			int minimum=1000;
			Random rn = new Random();
			int n = maximum - minimum + 1;
			int i = rn.nextInt() % n;
			int randomNum =  minimum + i;
			if(randomNum<0)
				randomNum=randomNum*-1;
			prepareState.setInt(2, randomNum);
			prepareState.setString(1, ut1.getPassword());
			prepareState.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public UserTable changeCount(LoginScreen ls) {
		UserTable ut= new UserTable();
		try {
			con=ConnectToDB.createConnection();
			prepareState=con.prepareStatement("select lock_count from user_table where user_id=?");
			prepareState.setInt(1, ls.userID);
			res=prepareState.executeQuery();
			while(res.next())
			{	
				ut.setLock_count(res.getInt(1));
			}
			prepareState1=con.prepareStatement("update user_table set lock_count=? where user_id=?");
			prepareState1.setInt(1, ut.getLock_count()+1);
			prepareState1.setInt(2, ls.userID);
			prepareState1.executeUpdate();

			prepareState=con.prepareStatement("select lock_count from user_table where user_id=?");
			prepareState.setInt(1, ls.userID);
			res=prepareState.executeQuery();
			while(res.next())
			{	
				ut.setLock_count(res.getInt(1));
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return ut;
	}
	@Override
	public void changeStatus(LoginScreen ls) {
		UserTable ut= new UserTable();
		try {
			con=ConnectToDB.createConnection();
			prepareState=con.prepareStatement("update user_table set lock_status='lock' where user_id=?");
			prepareState.setInt(1, ls.userID);
			res=prepareState.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void chageLockStatus(LoginScreen ls) {
		try {
			con=ConnectToDB.createConnection();
			prepareState1=con.prepareStatement("update user_table set lock_status='active',lock_count=0 where user_id=?");
			prepareState1.setInt(1, ls.userID);
			prepareState1.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}