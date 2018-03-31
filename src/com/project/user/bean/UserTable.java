package com.project.user.bean;

public class UserTable {
	private int account_id;
	private int user_id;
	private  String password;
	private String secret_question;
	private String secret_answer;
	private int trasaction_password;
	private String lock_status;
	private int lock_count;
	public int getLock_count() {
		return lock_count;
	}
	public void setLock_count(int lock_count) {
		this.lock_count = lock_count;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecret_question() {
		return secret_question;
	}
	public void setSecret_question(String secret_question) {
		this.secret_question = secret_question;
	}
	public String getSecret_answer() {
		return secret_answer;
	}
	public void setSecret_answer(String secret_answer) {
		this.secret_answer = secret_answer;
	}
	public int getTrasaction_password() {
		return trasaction_password;
	}
	public void setTrasaction_password(int trasaction_password) {
		this.trasaction_password = trasaction_password;
	}
	public String getLock_status() {
		return lock_status;
	}
	public void setLock_status(String lock_status) {
		this.lock_status = lock_status;
	}
}
