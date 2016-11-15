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
			sqlReader=Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}				
	private static SqlSessionFactory sqlMapper =
			new SqlSessionFactoryBuilder().build(
					sqlReader);
	
	public static Member selectMember(int mNum) throws Exception {
		
		Member member= null;
		SqlSession sqlSession = sqlMapper.openSession(true);	
		ArrayList<Member>memList =
				(ArrayList) sqlSession.selectList("selectMember", mNum);
		if(memList!=null&&memList.size()>0){
		member=memList.get(0);
		}
		sqlSession.close();
		return member;
  }
	public static Member selectMember(String mId) throws Exception {
		
		Member member= null;
		SqlSession sqlSession = sqlMapper.openSession(true);	
		ArrayList<Member>memList =
				(ArrayList) sqlSession.selectList("selectMember_Id", mId);
		if(memList!=null&&memList.size()>0){
		member=memList.get(0);
		}
		sqlSession.close();
		return member;
  }
	
	public static ArrayList<Member> selectMemberList() throws Exception {
		SqlSession sqlSession = sqlMapper.openSession(true);
		ArrayList<Member>memberList = null;
		memberList = (ArrayList)sqlSession.selectList("selectMemberList");
		sqlSession.close();
		return memberList;
  }
	
	public static void insertMember(Member member) throws Exception {
		SqlSession sqlSession = sqlMapper.openSession(true);
		sqlSession.insert("insertMember", member);
		sqlSession.close();
	}
	
	public static void deleteMember(int mNum) throws Exception{
		SqlSession sqlSession = sqlMapper.openSession(true);
		sqlSession.insert("deleteMember",mNum);
		sqlSession.close();
	}
	
	public static void updateMember(Member member) {
		SqlSession sqlSession = sqlMapper.openSession(true);
		sqlSession.insert("updateMember",member.mNum);
		sqlSession.close();
	}

}
