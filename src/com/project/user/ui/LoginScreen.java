package com.project.user.ui;

import java.util.Scanner;

import com.project.user.services.UserServices;

public class LoginScreen {
	public int userID;
	public String password;
	public String new_password;
	public String new_password_again;
	public String answer;
	static LoginScreen ls=new LoginScreen();

	static LoginScreen ls1=new LoginScreen();
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int choice;
		do{
			System.out.println("Enter Your option \n1.User\n2.Admin\n3.Exit");
			System.out.print("Enter here  :");
			choice=scan.nextInt();
			System.out.println("-----------------------------------------------");
			ls.enterdetails(choice);
			if(choice==3)
				break;
		}while(choice!=3);
	}

	public void enterdetails(int choice){
		Scanner ch=new Scanner(System.in);		
		UserServices us=new UserServices();
		switch (choice) {
		case 1:
			System.out.println("Your in user page\n1.Login\n2.Forget password");
			System.out.print("Enter here  :");
			int ch1=ch.nextInt();
			System.out.println("\n-----------------------------------------------");
			switch (ch1) {
			case 1:
				System.out.print("Enter your Id :");
				Scanner ch3=new Scanner(System.in);
				ls.userID=ch3.nextInt();
				System.out.print("Enter password :");
				ls.password=ch3.next();
				us.login(ls);
				System.out.println("\n-----------------------------------------------");
				break;
			case 2:
				Scanner ch4=new Scanner(System.in);
				System.out.print("enter your user Id :");
				ls1.userID=ch4.nextInt();
				us.forgetPassword(ls1);
				System.out.println("\n-----------------------------------------------");
			default:
				break;
			}
			break;
		case 2:
			System.out.println("Your in admin page\n1.Create account \n2.View all transaction details");			
			System.out.print("Enter here  :");
			int ch2=ch.nextInt();
			System.out.println("\n-----------------------------------------------");
			switch (ch2) {
			case 1:
				System.out.println("create account");
				System.out.println("\n-----------------------------------------------");
				break;
			case 2:
				System.out.println("view transaction details");
				System.out.println("\n-----------------------------------------------");
			default:
				break;
			}
			break;
		default:
			break;
		}
	}
	public LoginScreen new_password()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("enter new password : ");
		ls.new_password=scan.next();
		System.out.print("Enter your new password again : ");
		ls.new_password_again=scan.next();
		System.out.print("password changed succesfully");
		return ls;
	}
	public void printStatement(String msg)
	{
		System.out.println(msg);
	}

	public LoginScreen scan(int i) {
		Scanner sc=new Scanner(System.in);
		if(i==1)
		{
			ls.answer=sc.next();
		}
		return ls;
	}
}
