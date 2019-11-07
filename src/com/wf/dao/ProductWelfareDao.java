package com.wf.dao;

import com.wf.DaoImp.DBConnect;

public interface ProductWelfareDao  {
    public int getCurrentId();

	String addWelfare(int id, String code, String name, String price, String amount, String type, String content,
			int limit, int dailypool, int showtype, String starttime, String endtime, int enable, String creattime,
			String updatetime, int deteflag);
	 
}
