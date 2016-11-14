package com.SJshop.member;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.SJshop.good.Good;

public class MemberDAO {
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
	
	public static Member selectMember(String mNum) throws Exception {
		
		Member member= null;
		//1.sql 쿼리를 실행하는 SqlSession 객체 생성해서 변수에 저장
		//sqlMapper.openSession(true)
		
		SqlSession sqlSession = sqlMapper.openSession(true);
		//2.1변수를 이용해서 Good.xml에 id 속성을 selectGood 이라고 작성한 쿼리 실행해서 조회결과를 ArrayList<Good> 변수에 저장
		// (ArrayList)1변수.selectList("selectGood",gnum)
		
		ArrayList<Member>memList =
				(ArrayList) sqlSession.selectList("selectMember", mNum);
		//3. 2의 변수가 null 이 아니고 2변수.size()가 0초과면
		if(memList!=null&&memList.size()>0){
		// 3.1 2변수의 index 0에 해당하는 객체를 변수 good에 저장
		//  2변수.get(0)
		member=memList.get(0);
		}
		//4. 데이터 베이스 연결 종료
		// 1의 변수.close()
		sqlSession.close();

		return member;//물건 정보 리턴
  }
	
	public static void insertMember(Member member) throws Exception {
		//1.sql 쿼리를 실행하는 SqlSession 객체 생성해서 변수에 저장
		//sqlMapper.openSession(true)
		SqlSession sqlSession = sqlMapper.openSession(true);
		//2.1변수를 이용해서 Good.xml에 id 속성을 insertGood 이라고 작성한 쿼리 실행
		// 1변수.insert("insertGood",good)
		sqlSession.insert("insertMember", member);
		//4. 데이터 베이스 연결 종료
		// 1의 변수.close()
		sqlSession.close();

	}//end method
	
	public static void deleteMember(Member member) throws Exception{
		SqlSession sqlSession = sqlMapper.openSession(true);
		sqlSession.insert("deleteMember",member);
		sqlSession.close();
	}

}
