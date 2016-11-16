package com.SJshop.good;

import java.io.File;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.SJshop.category.Category;
import com.SJshop.category.CategoryDAO;

@Controller
public class GoodService  {
	

	//전체 물건 조회
	@RequestMapping(value="/viewGoodList.do")
	public ModelAndView viewGoodList() throws Exception {
		ModelAndView mav=new ModelAndView();
		ArrayList<Good> gList = GoodDAO.selectGoodList();
		mav.addObject("GOOD_LIST",gList);	
		mav.setViewName("/good/viewGoodList.jsp");
		return mav;
	}
	
	@RequestMapping(value="/viewGoodList_cNum.do")
	public ModelAndView viewGoodList(@RequestParam(value="cNum")int cNum) throws Exception {
		ModelAndView mav=new ModelAndView();
		ArrayList<Good> gList = GoodDAO.selectGoodList(cNum);
		mav.addObject("GOOD_LIST",gList);	
		mav.setViewName("/good/viewGoodList.jsp");
		return mav;
	}
	
	//물건 1개 조회
	@RequestMapping(value="/viewGood.do")
	public ModelAndView viewGood(@RequestParam(value="gnum")int gnum) throws Exception {
		ModelAndView mav=new ModelAndView();
		Good good = GoodDAO.selectGood(gnum);
		mav.addObject("GOOD",good);
		mav.setViewName("/good/viewGood.jsp");
		return mav;
	}
	@RequestMapping(value="/insertGoodForm.do")
	public ModelAndView insertGoodForm() throws Exception {
		ModelAndView mav=new ModelAndView();
		ArrayList<Category> cList=CategoryDAO.selectCategoryList();
		mav.addObject("CATEGORY_LIST", cList);
		mav.setViewName("/good/insertGoodForm.jsp");
		return mav;
	}
	@RequestMapping(value="/insertGood.do")
	public ModelAndView insertGood(Good g,@RequestParam(value="file") MultipartFile file) throws Exception {
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