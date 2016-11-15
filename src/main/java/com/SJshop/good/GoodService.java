package com.SJshop.good;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class GoodService  {
	

	//전체 물건 조회
	@RequestMapping(value="/viewGoodList.do")
	public ModelAndView viewGoodList() throws Exception {
		ModelAndView mav=new ModelAndView();
		//1. GoodDAO.selectGoodList()메서드를 호출하고 
		//리턴된 전체 물건정보를  ArrayList 변수에 저장
		

		ArrayList<Good> list = GoodDAO.selectGoodList();
		
		//2. 1의 객체를 JSP에서 출력할수 있도록 설정
		mav.addObject("GOOD_LIST",list);	
		
		//3./good/viewGoodList.jsp로 페이지 이동 하도록
		// mav의 setViewName을 /good/viewGoodList.jsp 으로 설정
		mav.setViewName("/good/viewGoodList.jsp");
		return mav;
	}
	
	//물건 1개 조회
	@RequestMapping(value="/viewGood.do")
	public ModelAndView viewGood(@RequestParam(value="gnum")int gnum) throws Exception {
		ModelAndView mav=new ModelAndView();
		// 
		//2. 조회하고자 하는 물건의 번호 가 매개변수 gnum에 저장되 있으므로 GoodDAO.selectGood(조회하려는 물건 번호 ->gnum)를 호출해서
		//조회하고자 하는 물건정보를 Good 타입 변수에 저장
		
		Good good = GoodDAO.selectGood(gnum);
		mav.addObject("GOOD",good);
		//2. 2의 객체를 JSP에서 출력할수 있도록 설정
		//  mav.addObject("JSP에서 사용할 이름:GOOD",2의 객체);
	
		//3./good/viewGood.jsp로 페이지 이동 하도록 
		// mav의 setViewName을 /good/viewGood.jsp 으로 설정
		mav.setViewName("/good/viewGood.jsp");
		return mav;
	}
	@RequestMapping(value="/InsertGood.do")
	public ModelAndView InsertGood() throws Exception {
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("/good/InsertGood.jsp");
		return mav;
	}
	@RequestMapping(value="/AddGood.do")
	public ModelAndView AddGood(Good g,@RequestParam(value="file") MultipartFile file) throws Exception {
		ModelAndView mav=new ModelAndView();
		 String uploadPath = "C:/Users/bit-user/git/SJshop/WebContent/photo";
		//       /home/hosting_users/feelk22/photo
//D:/workspace3/www/WebContent/photo
		//C:\Users\bit-user\git\SJshop\WebContent\photo
		File destFile=new File(uploadPath+"/"+file.getOriginalFilename());
		
		file.transferTo(destFile); 
		
		g.gMainImg = file.getOriginalFilename();
		
		
		
		
		
		GoodDAO.insertGood(g);
		mav.setViewName("/good/viewGoodList.jsp");
		return mav;
	}
	
	


}