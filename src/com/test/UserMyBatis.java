package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.entity.User;
import com.util.MyBatisUtil;


public class UserMyBatis {
	public static void main(String[] args) {
		//insert();
		//update();
		//delete();
		selectOne();//单条记录
		//selectAll();//多条记录
	}
	public static void selectAll(){
		//1.获取SqlSession
	    SqlSession session = MyBatisUtil.getSqlSession();
		List<User> users = session.selectList("queryByAge",20);	
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	private static void selectOne() {
		//1.获取SqlSession
		SqlSession session = MyBatisUtil.getSqlSession();
		//2.调用API
		User user = session.selectOne("queryByAddress");
		System.out.println(user);
		
		User u = session.selectOne("queryById",1);
		System.out.println(u);
		
		
	}

	
	private static void delete() {
		//1.获取SqlSession
		SqlSession session = MyBatisUtil.getSqlSession();
		//2.调用API
		int rs = session.delete("delete", 6);
		session.commit();
		System.out.println("影响的行数:"+rs);
	}

	public static  void update(){
		//1.获取SqlSession
		SqlSession session = MyBatisUtil.getSqlSession();
		//2.调用API
		User u = new User(6,"lucy","666666",21);
		int rs = session.update("updateName",u);
		session.commit();
		System.out.println("影响的行数:"+rs);
		
	}
	
	public void insert(){
		//1.获取SqlSession
		SqlSession session = MyBatisUtil.getSqlSession();
		//2.SqlSession的API
		session.insert("insertUser");
		session.commit();
		//insert(String,Object) String:配置文件中的id Object:参数
		session.insert("insertUser1", new User(6,"lucy","888888",21));
		session.commit();
	}

}
