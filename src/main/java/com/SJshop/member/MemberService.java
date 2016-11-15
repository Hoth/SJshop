package com.SJshop.member;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SJshop.member.Member;
import com.SJshop.member.MemberDAO;

public class MemberService {
	@RequestMapping(value="/viewMemberList.do")
	public ModelAndView viewMemberListList() throws Exception {
		ModelAndView mav=new ModelAndView();
		//1. GoodDAO.selectGoodList()메서드를 호출하고 
		//리턴된 전체 물건정보를  ArrayList 변수에 저장
		

		ArrayList<Member> list = MemberDAO.selectMemberList();
		
		//2. 1의 객체를 JSP에서 출력할수 있도록 설정
		mav.addObject("Member_LIST",list);	
		
		//3./good/viewGoodList.jsp로 페이지 이동 하도록
		// mav의 setViewName을 /good/viewGoodList.jsp 으로 설정
		mav.setViewName("/member/viewMemberList.jsp");
		return mav;
	}
}
