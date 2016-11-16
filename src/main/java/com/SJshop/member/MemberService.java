package com.SJshop.member;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.SJshop.question.Question;
import com.SJshop.question.QuestionDAO;

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
		
		Member check=null;
		check=MemberDAO.selectMember(member.mId);
		if(check!=null){
			mav.addObject("ERROR","ID가 이미 존재합니다.");
			mav.setViewName("forward:/insertMemberForm.do");
			return mav;
		}
		System.out.println(member.mPw+"\n");
		System.out.println(member.mPw2);
		if(!member.mPw.equals(member.mPw2)){
			mav.addObject("ERROR", "비밀번호가 다릅니다.");
			mav.setViewName("forward:/insertMemberForm.do");
			return mav;
		}if(!member.mEmail.contains("@")){
			mav.addObject("ERROR", "잘못된 이메일 형식입니다.");
			mav.setViewName("forward:/insertMemberForm.do");
			return mav;
		}
		MemberDAO.insertMember(member);
		mav.addObject("mNum",member.mNum);
		mav.setViewName("/index.jsp");
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
	
	@RequestMapping(value="/loginForm.do")
	   public ModelAndView LoginForm() throws Exception {
	      ModelAndView mav=new ModelAndView();
	      mav.setViewName("/member/loginForm.jsp");
	      return mav;
	   }
	///////////////////////////////////여기부터 다슬건드림
	@RequestMapping(value="/loginMember.do")
	public ModelAndView loginMember(
			@RequestParam(value="mId")String mId,
			@RequestParam(value="mPw")String mPw,
			HttpSession session) throws Exception{
		ModelAndView mav=new ModelAndView();
		Member loginMember = MemberDAO.selectMember(mId); 
		if(loginMember==null){ 
			mav.addObject("ERROR","존재하지 않는 아이디 입니다");	
			mav.setViewName("forward:/loginMemberForm.do");
			return mav;
		}

		if(!loginMember.mPw.equals(mPw)){
			mav.addObject("ERROR","비밀번호 오류 입니다");		
			mav.setViewName("forward:/LoginForm.do");
			return mav;
		}
		session.setAttribute("LOGIN_MEMBER",loginMember);
		mav.setViewName("forward:/Menu.do");	
		return mav;
	}
	//로그아웃
	@RequestMapping(value="/logoutMember.do")
	public ModelAndView logoutMember(HttpSession session) throws Exception{
		ModelAndView mav=new ModelAndView();
		session.removeAttribute("LOGIN_MEMBER");
		mav.setViewName("forward:/index.do");
		return mav;
	}
	
	
	
}
	

