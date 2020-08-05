package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.jdbc;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * Servlet implementation class apply
 */
@WebServlet("/apply")
public class apply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public apply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		String type=request.getQueryString();
		String sql="";	
		if(type.equals("1")){
			System.out.println("ok");
			sql=("select * from apply");
			
			JSONArray ja=new JSONArray();
			JSONObject jo=null;
			try{
				ResultSet rs=jdbc.readsql(sql);
				while(rs.next()){
					jo=new JSONObject();
					jo.put("applyid",rs.getString(1));
					jo.put("room", rs.getString(2));
					jo.put("name", rs.getString(3));
					jo.put("sex", rs.getString(4));
					jo.put("tel", rs.getString(5));
					jo.put("intime", rs.getString(6));
					jo.put("idcard", rs.getString(7));
					
					ja.add(jo);
				}
			}catch(SQLException e){
				
			}
			System.out.println(ja.toString());
			response.getWriter().print(ja);
			response.getWriter().flush();
			response.getWriter().close();
		}else if(type.equals("2")){
			String name=new String(request.getParameter("name"));
			String sex = new String(request.getParameter("sex"));
			String tel=new String(request.getParameter("tel"));
			String idcard=new String(request.getParameter("idcard"));
			String room=new String(request.getParameter("room"));
			String intime=new String(request.getParameter("intime"));
			
			Random random = new Random();
			
			if(name!=null&&tel!=null){
				try {
					sql=("insert into apply values('"+random.nextInt(100)+"','"+room+"','"+name+"','"+sex+"','"+tel+"','"+intime+"','"+idcard+"')");
					int rs=jdbc.writesql(sql);
					System.out.println(rs+sql);
					response.sendRedirect("http://localhost/RoomManage/index.html?1");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				System.out.println("信息不全");
			}
		}else if(type.equals("3")){
			System.out.println("delate");
			String applyid=new String(request.getParameter("applyid"));
			sql=("delete from apply where applyid="+applyid);
			System.out.println(sql);
			try {
				int rs=jdbc.writesql(sql);
				response.sendRedirect("/RoomManage/manage/apply.jsp?msg=3");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("/RoomManage/manage/apply.jsp?msg=-3");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
