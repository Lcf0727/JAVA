package com.tedu.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import com.tedu.util.JdbcUtil;

/**
 * PreparedStatement：模拟登录案例
 */
public class LoginUser {
	public static void main(String[] args) {
		/* 思路:提示用户在控制台输入用户名和密码
		 * 并接受用户输入的用户名和密码
		 * 调用方法根据用户名和密码查询用户是否存在
		 * 如果存在则模拟登录
		 * 如果不存在则提示用户名或密码不正确!!
		 */
		//0.声明一个Scanner对象
		Scanner in = new Scanner(System.in);
		//1.提示用户登录
		System.out.println("请登录...");
		//2.提示用户输入用户名并接收用户名
		System.out.println("请输入用户名:");
		String username = in.nextLine();
		//3.提示用户输入密码并接收密码
		System.out.println("请输入密码:");
		String password = in.nextLine();
		//4.调用login方法完成登录功能
		loginByPS(username, password);
	}
	
	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 */
	private static void login(String username, String password) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			stat = conn.createStatement();
			
			//执行SQL:根据用户名和密码查询用户
			String sql = "select * from user "
					+ "where username='"+username
					+ "' and password='"+password+"'";
			System.out.println("sql:"+sql);
			rs = stat.executeQuery(sql);
			if(rs.next()){//true:用户名和密码正确
				System.out.println("恭喜您登录成功!");
			}else{//false:用户名或密码不正确
				System.out.println("用户名或密码不正确!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("登录失败!");
		} finally{
			JdbcUtil.close(conn, stat, rs);
		}
	}
}




