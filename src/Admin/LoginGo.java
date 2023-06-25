package Admin;

import Modet.User;
import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginGo", value = "/LoginGo")
public class LoginGo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        HttpSession session=req.getSession();
        String URL;
        String username2=req.getParameter("username");
        String password2=req.getParameter("password");
        int flag=0;
        User user=new User();
        try {
            con= JDBCUtlis.getConnection();

            String sql = "select * from user where username=? and password=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,username2);
            ps.setString(2,password2);
            rs = ps.executeQuery();
            while (rs.next()) {
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                req.setAttribute("username", username1);
                req.setAttribute("password1", password1);
                session.setAttribute("username",username1);
                session.setAttribute("password",password1);
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                session.setAttribute("user",user);
                flag=1;
            }
            if(flag==1){
                req.getRequestDispatcher("/Menu/Menu.jsp").forward(req,resp);

            }else{
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.println(
                        "<script language='javascript'>alert('密码或用户名不正确');window.location='admin/Login.jsp'</script>");

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
