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
			//1.sql 쿼리를 실행하는 SqlSession 객체 생성해서 변수에 저장
			//sqlMapper.openSession(true)
			
			SqlSession sqlSession = sqlMapper.openSession(true);
			//2.1변수를 이용해서 Good.xml에 id 속성을 selectGood 이라고 작성한 쿼리 실행해서 조회결과를 ArrayList<Good> 변수에 저장
			// (ArrayList)1변수.selectList("selectGood",gnum)
			
			ArrayList<Good>goodList =
					(ArrayList) sqlSession.selectList("selectGood", gNum);
			//3. 2의 변수가 null 이 아니고 2변수.size()가 0초과면
			if(goodList!=null&&goodList.size()>0){
			// 3.1 2변수의 index 0에 해당하는 객체를 변수 good에 저장
			//  2변수.get(0)
			good=goodList.get(0);
			}
			//4. 데이터 베이스 연결 종료
			// 1의 변수.close()
			sqlSession.close();

			return good;//물건 정보 리턴
	  }

	/*
		전체 물건 조회
		 */
		
		public static ArrayList<Good> selectGoodList() throws Exception {
			//1.sql 쿼리를 실행하는 SqlSession 객체 생성해서 변수에 저장
			//sqlMapper.openSession(true)
			SqlSession sqlSession = sqlMapper.openSession(true);
			
			ArrayList<Good>goodList = null;
			//2.1변수를 이용해서 Good.xml에 id 속성을 selectGoodList 이라고 작성한 쿼리 실행해서 조회결과를 변수 goodList에 저장
			// (ArrayList)1변수.selectList("selectGoodList")
			goodList = (ArrayList)sqlSession.selectList("selectGoodList");
			//4. 데이터 베이스 연결 종료
			// 1의 변수.close()
			sqlSession.close();
			
			return goodList;//전체 물건 정보 리턴
	  }

		/* 물건정보를 DB에 저장하는 메서드
		 * 매개변수 good
		 * -DB 에 저장하고 싶은 물건의 이름,가격,설명,이미지파일이름를 
		 *  속성으로 저장하고있는 객체
		 */
		public static void insertGood(Good good) throws Exception {
			//1.sql 쿼리를 실행하는 SqlSession 객체 생성해서 변수에 저장
			//sqlMapper.openSession(true)
			SqlSession sqlSession = sqlMapper.openSession(true);
			//2.1변수를 이용해서 Good.xml에 id 속성을 insertGood 이라고 작성한 쿼리 실행
			// 1변수.insert("insertGood",good)
			sqlSession.insert("insertGood", good);
			//4. 데이터 베이스 연결 종료
			// 1의 변수.close()
			sqlSession.close();

		}//end method
}