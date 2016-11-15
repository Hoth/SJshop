package com.SJshop.member;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.SJshop.Question.Question;
import com.SJshop.Question.QuestionDAO;

@Controller
public class MemberService {
	
	@RequestMapping(value="/viewMemberList.do")
	public ModelAndView viewMemberListList() throws Exception {
		ModelAndView mav=new ModelAndView();
		ArrayList<Member> list = MemberDAO.selectMemberList();
		mav.addObject("Member_LIST",list);	
		mav.setViewName("/member/viewMemberList.jsp");
		return mav;
	}
	@RequestMapping(value="/insertMemberForm.do")
	public ModelAndView insertMemberForm()throws Exception {
		ModelAndView mav=new ModelAndView();
		ArrayList<Question> qList=QuestionDAO.selectQuestionList();	
		mav.addObject("QUESTION_LIST", qList);
		mav.setViewName("/member/insertMemberForm.jsp");
		return mav;
	}
	//학생 추가 
	
	@RequestMapping(value="/insertMember.do")
	public ModelAndView insertMember(Member member)throws Exception {
		ModelAndView mav=new ModelAndView();
		MemberDAO.insertMember(member);
		mav.addObject("mNum",member.mNum);
		mav.setViewName("forward:/viewMember.do");
		return mav;
	}
	
	@RequestMapping(value="/updateMemberForm.do")
	public ModelAndView updateMemberForm(@RequestParam(value="mNum")int mNum)throws Exception {
		ModelAndView mav=new ModelAndView();
		ArrayList<Question> qList =QuestionDAO.selectQuestionList();
		Member member=MemberDAO.selectMember(mNum);
		mav.addObject("Qustion_LIST",qList);
		mav.addObject("MEMBER", member);
		mav.setViewName("/member/updateMemberForm.jsp");
		return mav;
	}
	
	@RequestMapping(value="/updateMember.do")
	public ModelAndView updateMember(Member member)throws Exception {
		ModelAndView mav=new ModelAndView();
		MemberDAO.updateMember(member);
		mav.addObject("mNum",member.mNum);
		mav.setViewName("forward:/viewMember.do");
		return mav;
	}
	
	@RequestMapping(value="/removeMember.do")
	public ModelAndView removeMember(@RequestParam("mNum")int mNum)throws Exception {
		ModelAndView mav=new ModelAndView();
		MemberDAO.deleteMember(mNum);
		mav.setViewName("forward:/viewMemberList.do");
		return mav;
	}
	
	@RequestMapping(value="/LoginForm.do")
	   public ModelAndView LoginForm() throws Exception {
	      ModelAndView mav=new ModelAndView();
	      mav.setViewName("/member/LoginForm.jsp");
	      return mav;
	   }
	 
	
}
	

