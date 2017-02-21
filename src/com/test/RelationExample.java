package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.entity.User;
import com.util.MyBatisUtil;

/**
 * 关联关系:
 *   1:1
 *   1:n
 *   n:n
 * @author andy
 *
 */
public class RelationExample {

	public static void main(String[] args) {
		oneToone();
 	}
	
	/**
	 * 1:1关系
	 * User:Address
	 *  SQL: select u.userid id,u.name,u.password,u.age,a.province,a.city
        on u.addressid = a.addressid where  u.age = 20
	 */
	public static void oneToone(){
		//1.创建一个SqlSession对象
		SqlSession session = MyBatisUtil.getSqlSession();
		//2.API
		List<User> users = session.selectList("queryByAddress", 20);
		for (User user : users) {
			System.out.println(user);
		}
	}
	

}
