package com.SJshop.util;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;


public class MemberArgumentResolver {




	public class GoodArgumentResolver 
	     implements WebArgumentResolver {

		public Object resolveArgument(
				MethodParameter parameter,
				NativeWebRequest request) throws Exception {
			if(Member.class == parameter.getParameterType()){
				String gNum = request.getParameter("gNum");
				String gName = request.getParameter("gName");//��ǰ��
				String gPrice = request.getParameter("gPrice");//����
				String gMainImg = request.getParameter("gMainImg");//��ǥ����
				String gMainDetail = request.getParameter("gMainDetail");//��ǥ����
				String gImg = request.getParameter("gImg");//���λ���
				String gDetail = request.getParameter("gDetail");//���μ���
				int gCount = Integer.parseInt(request.getParameter("gCount"));//�Ǹŷ�
				int gStock = Integer.parseInt(request.getParameter("gStock"));//���
				
				
				Good g = new Good();
				g.setgNum(Integer.parseInt(gNum));
				g.setgName(gName);
				g.setgPrice(gPrice);
				g.setgMainImg(gMainImg);
				g.setgMainDetail(gMainDetail);
				g.setgImg(gImg);
				g.setgDetail(gDetail);
				g.setgCount(gCount);
				g.setgStock(gStock);
				return g;
			
			
			}
			return WebArgumentResolver.UNRESOLVED;
		}

	

}
