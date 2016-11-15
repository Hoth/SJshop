package com.SJshop.Question;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.SJshop.Question.Question;

public class QuestionDAO {
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
	
	public static Question selectQuestion(int qNum) throws Exception {
		
		Question Question= null;
		SqlSession sqlSession = sqlMapper.openSession(true);	
		ArrayList<Question> QuestionList =
				(ArrayList) sqlSession.selectList("selectQuestion");
		sqlSession.close();

		return Question;
  }
	
	public static ArrayList<Question> selectQuestionList() throws Exception {
		SqlSession sqlSession = sqlMapper.openSession(true);
		ArrayList<Question>QuestionList = null;
		QuestionList = (ArrayList)sqlSession.selectList("selectQuestionList");
		sqlSession.close();
		return QuestionList;
  }
	
}
