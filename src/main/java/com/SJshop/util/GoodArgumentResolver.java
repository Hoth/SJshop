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
			
			String name = request.getParameter("name");
			String detail = request.getParameter("detail");
			String price = request.getParameter("price");
			String img = request.getParameter("img");
			
			Good g = new Good();
			
			g.setName(name);
			g.setDetail(detail);
			g.setPrice(Long.parseLong(price));
			return g;
		
		
		}
		return WebArgumentResolver.UNRESOLVED;
	}

}
