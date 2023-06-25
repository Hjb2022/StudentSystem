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

@WebServlet(name = "Register", value = "/Register")

public class Register extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String username1=req.getParameter("username");
        String password1=req.getParameter("password");
        String email1=req.getParameter("email");
        String phone1=req.getParameter("phone");
        String sex1=req.getParameter("sex");
        String birthday1=req.getParameter("birthday");
        try {
            con= JDBCUtlis.getConnection();
            String sql= "INSERT INTO user (username,password,email,phone,sex,birthday) " +
                    "values(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,username1);
            ps.setString(2,password1);
            ps.setString(3,email1);
            ps.setString(4,phone1);
            ps.setString(5,sex1);
            ps.setString(6,birthday1);
            int num= ps.executeUpdate();
            if(num>0){
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.println(
                        "<script language='javascript'>alert('¹§Ï²Äã£¬×¢²áÕËºÅ³É¹¦£¡');window.location='Admin/Login.jsp'</script>");
//                req.getRequestDispatcher("/Admin/Login.jsp").forward(req,resp);
            }else{
                System.out.println("Ìí¼ÓÊ§°Ü");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
