package com.nieyue.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.nieyue.bean.Acount;
import com.nieyue.util.HttpClientUtil;
import com.nieyue.util.MyDESutil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 账户业务
 * @author 聂跃
 * @date 2017年8月19日
 */
@Configuration
public class AcountBusiness {
	@Value("${myPugin.sevenSecondsDomainUrl}")
	public String sevenSecondsDomainUrl;
	
	/**
	 * 获取个人账户信息
	 * @throws Exception 
	 * @re
	 */
	public  Acount getAcountByAcountId(Integer acountId) throws Exception{
		String acountlist = HttpClientUtil.doGet(sevenSecondsDomainUrl+"/acount/"+acountId+"?auth="+MyDESutil.getMD5("1000"));
		JSONObject json=JSONObject.fromObject(acountlist);
		JSONArray jsa = JSONArray.fromObject(json.get("list"));
		Acount acount = (Acount) JSONObject.toBean((JSONObject)jsa.get(0), Acount.class	);
		return acount;
	}
}
