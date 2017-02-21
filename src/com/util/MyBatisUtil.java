package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.test.TestExample;
import com.test.UserMyBatis;

public class MyBatisUtil {
	private static Properties pro = new Properties();
	private static SqlSessionFactory factory;
	static{
		InputStream is = MyBatisUtil.class.getResourceAsStream("db.properties");
		try {
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//1.����SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sfb  =
					new SqlSessionFactoryBuilder();
		//2.��ȡ�����ļ����Ҵ���SqlSessionFactory
	      factory = 
	    		  sfb.build(UserMyBatis.class.getResourceAsStream("/configuration.xml"),pro);
	}
	
	public static SqlSession  getSqlSession(){
		//3.�����ỰSqlSession
		SqlSession session = factory.openSession();
		return session;				
	}
}
