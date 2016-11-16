package com.SJshop.category;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CategoryDAO {
	private  static String resource= "sqlmap-config.xml";
	private static Reader sqlReader=null;
	static{
		try {
			sqlReader=Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}				
	private static SqlSessionFactory sqlMapper =
			new SqlSessionFactoryBuilder().build(
					sqlReader);
	public static Category selectCategory(int cNum) throws Exception {
		
		Category category= null;
		SqlSession sqlSession = sqlMapper.openSession(true);	
		ArrayList<Category>cList =
				(ArrayList) sqlSession.selectList("selectCategory", cNum);
		if(cList!=null&&cList.size()>0){
		category=cList.get(0);
		}
		sqlSession.close();
		return category;
  }
	public static ArrayList<Category> selectCategoryList() throws Exception {
		SqlSession sqlSession = sqlMapper.openSession(true);
		ArrayList<Category>cList = null;
		cList = (ArrayList)sqlSession.selectList("selectCategoryList");
		sqlSession.close();
		return cList;
  }
	
}
