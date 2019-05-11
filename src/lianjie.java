import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class lianjie extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName=request.getParameter("userName");
        String password=request.getParameter("password");
		out.flush();
		out.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动创建成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动创建失败");
			e.printStackTrace();
		}
		try {
			Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/nudb", "root", "123123");
			System.out.println("连接数据库成功" );
			Statement sta=(Statement) con.createStatement();
			sta.executeUpdate("insert user values ('"+userName+"','"+password+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName=request.getParameter("userName");
        String password=request.getParameter("password");
		out.flush();
		out.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动创建成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动创建失败");
			e.printStackTrace();
		}
		try {
			Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/nudb", "root", "123123");
			System.out.println("连接数据库成功" );
			Statement sta=(Statement) con.createStatement();
			sta.executeUpdate("insert user values ('"+userName+"','"+password+"');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

