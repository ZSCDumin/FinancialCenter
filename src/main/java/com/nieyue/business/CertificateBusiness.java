package com.nieyue.business;

import javax.servlet.http.HttpServletRequest;

import com.nieyue.util.MyDESutil;
/**
 * 证书业务
 * @author 聂跃
 * @date 2017年8月19日
 */
public class CertificateBusiness {
	/**
	 *  session证书认证
	 * @param request
	 * @return false为不成功，true为成功
	 */
	public static boolean md5SessionCertificate(HttpServletRequest request){
	//证书验证
     if(request.getParameter("certificate")==null||!request.getParameter("certificate")
    		   .equals(MyDESutil.getMD5SESSIONID("jiaxingyufa",request.getSession().getId()))){
    	   return false;
       }
     return true;
	}
}
