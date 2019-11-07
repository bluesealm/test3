package com.wf.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wf.ServiceImp.ProductWelfareServiceImp;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     String zhi=null;
			 FileItemFactory factory = new DiskFileItemFactory();
		     ServletFileUpload upload = new ServletFileUpload(factory);
		     String type=request.getParameter("type");
		     
		     try {
		            List<FileItem>  items = (List) upload.parseRequest(request);
		            InputStream is = null;
		            Iterator<FileItem> iter = items.iterator();
		          
		            while (iter.hasNext()) {
		                FileItem item = (FileItem) iter.next();
		                if (!item.isFormField()) {
		                	 //创建输入流
		                    is = item.getInputStream();
		                }else{
		                    if(item.getFieldName().equals("qwe")){
		                    zhi=item.getString("gb2312");
		                    System.out.println(zhi);
		                  }
		                }
		            }
		            Workbook workbook = Workbook.getWorkbook(is);
		            Sheet sheet = workbook.getSheet(0);
		            int cols=sheet.getColumns();
		            int rows=sheet.getRows();
		            
		            List<List> list=new ArrayList<List>();
                    List sublist=new ArrayList();

		            for(int i=0;i<rows;i++){
		            	sublist=new ArrayList();
		            	for(int j=0;j<cols;j++){
		            		 Cell excelRows = sheet.getCell(j, i);
		            		 String s=excelRows.getContents();
		            		 sublist.add(s);
		            	}
		            	list.add(sublist);
		            }
		      new ProductWelfareServiceImp().addWelfare(list,type);  
		 }catch (FileUploadException e) {
	            e.printStackTrace();
	        } catch (BiffException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		     response.sendRedirect("/test/addsuccess.jsp");
//		     request.getRequestDispatcher("/a.jsp");
//		     request.setAttribute("", "");
//		     RequestDispatcher.forward(request, response);
	}

}
