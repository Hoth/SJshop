package com.SJshop.good;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GoodDAO {
	
	private  static String resource= "sqlmap-config.xml";
	private static Reader sqlReader=null;
	static{
		try {
			sqlReader=Resources.getResourceAsReader(
								resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}				
	private static SqlSessionFactory sqlMapper =
			new SqlSessionFactoryBuilder().build(
					sqlReader);

	/*
		 * 번호가이 일치하는 물건정보를 DB에서 조회
		 * Good 객체의 속성에 저장해서 
		 * Good 객체를 리턴
		 * 매개변수:gnum 조회하려는 물건 번호
		 */
		public static Good selectGood(int gNum) throws Exception {
			
			Good good = null;
			SqlSession sqlSession = sqlMapper.openSession(true);
			ArrayList<Good>goodList =
					(ArrayList) sqlSession.selectList("selectGood", gNum);
			if(goodList!=null&&goodList.size()>0){
			good=goodList.get(0);
			}
					sqlSession.close();

			return good;
	  }

	
		public static ArrayList<Good> selectGoodList() throws Exception {
			SqlSession sqlSession = sqlMapper.openSession(true);
			ArrayList<Good>goodList = null;
			goodList = (ArrayList)sqlSession.selectList("selectGoodList");
			sqlSession.close();
			return goodList;
	  }

		public static void insertGood(Good good) throws Exception {
			SqlSession sqlSession = sqlMapper.openSession(true);
			sqlSession.insert("insertGood", good);
			sqlSession.close();

		}
		
		public static void deleteGood(Good good) throws Exception{
			SqlSession sqlSession = sqlMapper.openSession(true);
			sqlSession.insert("deleteGood",good.gNum);
			sqlSession.close();
		}
		
		public static void updateGood(Good good) throws Exception{
			SqlSession sqlSession = sqlMapper.openSession(true);
			sqlSession.insert("updateGood",good.gNum);
			sqlSession.close();
		}
}