package Admin;

import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "AdminUpdate", value = "/AdminUpdate")
public class AdminUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");
        String sex=req.getParameter("sex");
        String birthday=req.getParameter("birthday");

        System.out.println("你好");
        try {
           con= JDBCUtlis.getConnection();
            String sql= "update user set password=?,email=?,phone=?,sex=? ,birthday=?where username=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,password);
            ps.setString(2,email);
            ps.setString(3,phone);
            ps.setString(4,sex);
            ps.setString(5,birthday);
            ps.setString(6,username);

            int number=ps.executeUpdate();
            if(number>0){
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.println(
                        "<script language='javascript'>alert('修改成功！');window.location='Admin'</script>");
//                req.getRequestDispatcher("Admin").forward(req,resp);
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
