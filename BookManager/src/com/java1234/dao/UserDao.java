package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.User;

/**
 * 用户Dao类，即对数据库进行操作的类
 * @author 86150
 *
 */
public class UserDao {
	
	/**
	 * 登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
		public User login(Connection con,User user) throws Exception
		{
			User resultUser=null;
			String sql="select * from t_user where userName=? and password=?";//将被发送到数据库的一段语句
			PreparedStatement pstmt=con.prepareStatement(sql); //定义执行mysql简单语句的对象
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getPassword());
			ResultSet rs=pstmt.executeQuery();  //读取数据库的结果集
			if(rs.next())
			{
				resultUser=new User();
				resultUser.setId(rs.getInt("id"));
				resultUser.setUserName(rs.getString("userName"));
				resultUser.setPassword(rs.getString("password"));
			}
			return resultUser;
		}
}
