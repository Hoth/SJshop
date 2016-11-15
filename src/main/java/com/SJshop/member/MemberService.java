package com.SJshop.member;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.SJshop.Question.Question;
import com.SJshop.Question.QuestionDAO;
import com.bitacademy.dept.Dept;
import com.bitacademy.dept.DeptDAO;
import com.bitacademy.student.Student;
import com.bitacademy.student.StudentDAO;

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
	public ModelAndView addStudentForm()throws Exception {
		ModelAndView mav=new ModelAndView();
		ArrayList<Question> qList=QuestionDAO.selectQuestionList();	
		mav.addObject("QUESTION_LIST", qList);
		mav.setViewName("/Member/addMemberForm.jsp");
		return mav;
	}
	//학생 추가 
	
	@RequestMapping(value="/insertMember.do")
	public ModelAndView addStudent(Member member)throws Exception {
		ModelAndView mav=new ModelAndView();
		MemberDAO.insertMember(member);
		mav.addObject("mNum",member.mNum);
		mav.setViewName("forward:/viewMember.do");
		return mav;
	}
	
	@RequestMapping(value="/editStudentForm.do")
	public ModelAndView editStudentForm(@RequestParam(value="studno")String studno)throws Exception {
		ModelAndView mav=new ModelAndView();
		ArrayList<Dept> studentEdit =DeptDAO.selectDeptList();
		Student student=StudentDAO.selectStudent(studno)
		mav.addObject("DEPT_LIST",studentEdit);
		mav.addObject("STUDENT", student)
		mav.setViewName("/student/editStudentForm.jsp");
		return mav;
		
	}
	
	
}
	

