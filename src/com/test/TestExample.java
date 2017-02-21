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
		
		//1.����SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		//2.����һ��SqlSessionFactory
		/*InputStream is = TestExample.class.getResourceAsStream("configuration.xml");
		SqlSessionFactory sf = sfb.build(is);
		System.out.println(sf);
		*/
		//3.����һ��SqlSessionFactory���Ҽ���Properties�����ļ�
		InputStream is = TestExample.class.getResourceAsStream("/configuration.xml");
		SqlSessionFactory sf = sfb.build(is,pro);
		
		//4.����SqlSession�Ự 
		SqlSession session = sf.openSession();
		System.out.println(session);
		
		//5.��ѯ����  List selectList(String,Object) ����ָ�����ƻ�ȡsql
		//���ҽ�����װ�䵽sql���,Ȼ���ȡ���ݼ��� 
		//��ѯ��ǰ�û������������ select * from t_user
		List<User> users =session.selectList("queryAll");
		for (User user : users) {
			System.out.println(user);
		}
		
		//6.����������ѯ���
		User u = session.selectOne("queryById", 1);
		System.out.println(u);
		
	}

}
