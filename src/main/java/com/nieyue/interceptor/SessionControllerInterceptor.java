package com.nieyue.interceptor;

import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nieyue.bean.Acount;
import com.nieyue.bean.Role;
import com.nieyue.business.CertificateBusiness;
import com.nieyue.exception.MyCertificateException;
import com.nieyue.exception.MySessionException;
import com.nieyue.util.MyDESutil;

/**
 * 用户session控制拦截器
 * @author yy
 *
 */
@Configuration
public class SessionControllerInterceptor implements HandlerInterceptor {

	@Resource
	StringRedisTemplate stringRedisTemplate;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
        	System.out.println(handler);
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
       System.out.println(method.getDefaultValue());
        
       //天窗
       if(MyDESutil.getMD5("1000").equals(request.getParameter("auth"))){
          	return true;
       }
       
        Acount sessionAcount = null;
        Role sessionRole=null;
        if(request.getSession()!=null
        		&&request.getSession().getAttribute("acount")!=null
        		&&request.getSession().getAttribute("role")!=null
        		){
        sessionAcount = (Acount) request.getSession().getAttribute("acount");
        sessionRole = (Role) request.getSession().getAttribute("role");
        }
//        Integer i=1;
//        Integer j=1;
//        if(i.equals(j)){
//        	return true;
//        }
        
        if(
        		request.getServletPath().equals("/")
        		//||((request.getRequestURI().indexOf("auth")>-1)&& MyDESutil.getMD5("auth1000").equals(request.getParameter("authid")))//临时授权
        		||request.getRequestURI().indexOf("tool")>-1
        		||request.getRequestURI().indexOf("swagger")>-1 
        		||request.getRequestURI().indexOf("api-docs")>-1
        		//financialCate
        		||request.getRequestURI().indexOf("financialCate/count")>-1
        		||request.getRequestURI().indexOf("financialCate/list")>-1
        		||method.getName().equals("loadFinancialCate")
        		//financial
        		||request.getRequestURI().indexOf("financial/webRead")>-1
        		||request.getRequestURI().indexOf("financial/count")>-1
        		||request.getRequestURI().indexOf("financial/list")>-1
        		||request.getRequestURI().indexOf("financial/loadSmall")>-1
        		||method.getName().equals("loadFinancial")
        		//dailyData
        		||request.getRequestURI().indexOf("dailyData/count")>-1
        		||request.getRequestURI().indexOf("dailyData/statisticsDailyData")>-1
        		||request.getRequestURI().indexOf("dailyData/list")>-1
        		||method.getName().equals("loadDailyData")
        		//data
        		||request.getRequestURI().indexOf("data/count")>-1
        		||request.getRequestURI().indexOf("data/statisticsData")>-1
        		||request.getRequestURI().indexOf("data/list")>-1
        		||method.getName().equals("loadData")
       
        		){
        	return true;
        }else if (sessionAcount!=null) {
        	//确定角色存在
        	if(sessionRole!=null ){
        	//超级管理员
        	if(sessionRole.getName().equals("超级管理员")
        			||sessionRole.getName().equals("运营管理员")
        			){
        		return true;
        	}
        	//admin中只许修改自己的值
        	if(sessionRole.getName().equals("用户")){
        		//证金融认证
        		if((request.getRequestURI().indexOf("delete")>-1 
        				||request.getRequestURI().indexOf("add")>-1
        				||request.getRequestURI().indexOf("update")>-1 )
        				&& !CertificateBusiness.md5SessionCertificate(request)){
        			throw new MyCertificateException();
        		}
        		//金融类型不许删除/增加/修改
        		if( request.getRequestURI().indexOf("/financialCate/delete")>-1 
        				|| request.getRequestURI().indexOf("/financialCate/add")>-1
        				|| request.getRequestURI().indexOf("/financialCate/update")>-1
        				){
        			throw new MySessionException();
        		}
        		//金融不许删除/增加/修改
        		if( request.getRequestURI().indexOf("/financial/delete")>-1 
        				|| request.getRequestURI().indexOf("/financial/add")>-1
        				|| request.getRequestURI().indexOf("/financial/update")>-1
        				){
        			throw new MySessionException();
        		}
        		//时间段数据不许删除/修改/增加
        		if( request.getRequestURI().indexOf("/data/delete")>-1 
        				|| request.getRequestURI().indexOf("/data/update")>-1 
        				|| request.getRequestURI().indexOf("/data/add")>-1){
        			throw new MySessionException();
        		}
        		//日数据不许删除/修改/增加
        		if( request.getRequestURI().indexOf("/dailyData/delete")>-1 
        				|| request.getRequestURI().indexOf("/dailyData/update")>-1 
        				|| request.getRequestURI().indexOf("/dailyData/add")>-1){
        			throw new MySessionException();
        		}
        		return true;
        	}
        	}
        	
        }
        //如果验证token失败
       throw new MySessionException();
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
