package com.wf.ServiceImp;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wf.DaoImp.ProductWelfareDaoImp;
import com.wf.Service.ProductWelfareService;
import com.wf.util.DateUtil;

public class ProductWelfareServiceImp implements ProductWelfareService{
	ProductWelfareDaoImp prow=new ProductWelfareDaoImp();
	String regex = "\\d+\\.?\\d";
	Pattern p = Pattern.compile(regex);
	String  creattime=new DateUtil().getnowDate("yyyy-MM-dd hh:mm:ss");
	String endtime=new DateUtil().getDate("yyyy-MM-dd hh:mm:ss",30);
	@Override
	public void addWelfare(List<List> list,String type) {
		ProductWelfareDaoImp pw=new ProductWelfareDaoImp();
	    for(int i=0;i< list.size();i++){
	    	int id=pw.getCurrentId()+1;
	    	System.out.println("*********"+id+"***");
		    String code=new DateUtil().getnowDate("yyyyMMdd")+new Random().nextInt(99);
		    List sublist=list.get(i);
		    String name =sublist.get(0).toString();
		    String price=sublist.get(1).toString().substring(1);
		    String content=sublist.get(3).toString();
		    
		    Matcher m = p.matcher(sublist.get(2).toString());
//		    String amount=m.group(0).toString();
		    String amount=sublist.get(2).toString();
		    prow.addWelfare(id,code,name,price,amount,type,content,3,10,1,creattime,endtime,1,creattime,creattime,0);
			 
	    }
	}

}
