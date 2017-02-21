package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.entity.User;

public class TestExample {
	private static Properties pro = new Properties();
	static{
		InputStream is = TestExample.class.getResourceAsStream("db.properties");
		try {
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		//1.创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		//2.创建一个SqlSessionFactory
		/*InputStream is = TestExample.class.getResourceAsStream("configuration.xml");
		SqlSessionFactory sf = sfb.build(is);
		System.out.println(sf);
		*/
		//3.创建一个SqlSessionFactory并且加载Properties配置文件
		InputStream is = TestExample.class.getResourceAsStream("/configuration.xml");
		SqlSessionFactory sf = sfb.build(is,pro);
		
		//4.创建SqlSession会话 
		SqlSession session = sf.openSession();
		System.out.println(session);
		
		//5.查询数据  List selectList(String,Object) 根据指定名称获取sql
		//并且将对象装配到sql语句,然后获取数据集。 
		//查询当前用户表的所有数据 select * from t_user
		List<User> users =session.selectList("queryAll");
		for (User user : users) {
			System.out.println(user);
		}
		
		//6.根据条件查询结果
		User u = session.selectOne("queryById", 1);
		System.out.println(u);
		
	}

}
