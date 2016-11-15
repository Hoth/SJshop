package com.SJshop.util;


import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.SJshop.good.*;




public class GoodArgumentResolver 
     implements WebArgumentResolver {

	public Object resolveArgument(
			MethodParameter parameter,
			NativeWebRequest request) throws Exception {
		if(Good.class == parameter.getParameterType()){
			
			String gName = request.getParameter("gName");
			String gDetail = request.getParameter("gDetail");
			String gPrice = request.getParameter("gPrice");
			String gImg = request.getParameter("gImg");
			
			Good g = new Good();
			
			g.setgName(gName);
			g.setgDetail(gDetail);
			g.setgPrice(gPrice);
			return g;
		
		
		}
		return WebArgumentResolver.UNRESOLVED;
	}

}
