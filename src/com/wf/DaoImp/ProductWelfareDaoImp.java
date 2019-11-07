package com.wf.DaoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wf.dao.ProductWelfareDao;

public class ProductWelfareDaoImp implements ProductWelfareDao{
	
	Connection connection=(Connection) new DBConnect().connect("3306", "mall");
	Statement stmt;
	
	@Override
	public String addWelfare(int id,String code,String name,String price,String amount,String type,String content,int limit,int dailypool,int showtype,String starttime,String endtime,int enable,String creattime,String updatetime,int deteflag) {
		String sql="\r\n" + 
				"insert into mall_product_welfare (id,code,name,price,amount,type,content,limit_times,daily_pool,show_type,start_time,end_time,enable,create_time,update_time,delete_flag)"
				+ "values("+id+",\'"+code+"\',\'"+ name+"',"+ price+",'"+ amount+"','"+  type+"','"+ content+"','"+ limit+"','"+ dailypool+"','"+  showtype+"','"+ starttime+"','"+ endtime+"','"+  enable+"','"+ creattime+"','"+ updatetime+"','"+  deteflag+"')";
		System.out.println(sql);
		try {
			stmt=connection.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public int getCurrentId() {
		Connection connection=(Connection) new DBConnect().connect("3306", "mall");
		String sql="select max(id) from mall_product_welfare";
		int id=0;
		try {
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				  id=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	 
}
