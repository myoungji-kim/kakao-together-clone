package com.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
	 static SqlSessionFactory sqlSessionFactory;
		static {
			String resource = "com/config/Configuration.xml";
			InputStream inputStream=null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			  sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
		}//end static 블럭
		
		public static SqlSession getSession() {
			return sqlSessionFactory.openSession();
		}
}
