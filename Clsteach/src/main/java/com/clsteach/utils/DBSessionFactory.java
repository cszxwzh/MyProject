package com.clsteach.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBSessionFactory {
	private static SqlSessionFactory sqlSessionFactory = null;
	static{
		try {
			if(sqlSessionFactory==null){
			String path = "mybatis/Configuration.xml";
			Reader reader = Resources.getResourceAsReader(path);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static SqlSessionFactory getSessionFactory() {
		return sqlSessionFactory;
	}

}
