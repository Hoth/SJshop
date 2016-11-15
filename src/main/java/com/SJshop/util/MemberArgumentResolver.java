package com.SJshop.util;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import com.SJshop.member.*;


	public class MemberArgumentResolver 
	     implements WebArgumentResolver {

		public Object resolveArgument(
				MethodParameter parameter,
				NativeWebRequest request) throws Exception {
			if(Member.class == parameter.getParameterType()){
				int mNum = Integer.parseInt(request.getParameter("mNum"));
				String mName = request.getParameter("mName");
				String mId = request.getParameter("mId");
				String mPw = request.getParameter("mPw");
				String mAddress = request.getParameter("mAddress");
				String mMileage = request.getParameter("mMileage");
				String mCount = request.getParameter("mCount");
				Member m = new Member();
				m.setmName(mName);
				m.setmId(mId);
				m.setmPw(mPw);
				m.setmAddress(mAddress);
				m.setmMileage(mMileage);
				m.setmCount(mCount);
				return m;
			}
			return WebArgumentResolver.UNRESOLVED;
		}

	

}
