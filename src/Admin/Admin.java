package Admin;

import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Admin", value = "/Admin")
public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        HttpSession session=req.getSession();
         String username3= (String) session.getAttribute("username");
         System.out.println(username3);

        String username2=req.getParameter("username");
        System.out.println(username2);
        try {
          con= JDBCUtlis.getConnection();
            String sql= "select * from user where username=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,username3);
            rs=ps.executeQuery();
            while(rs.next()){
                String username = rs.getString("username");
                String password1 = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String sex = rs.getString("sex");
                String birthday = rs.getString("birthday");
                req.setAttribute("username", username);
                req.setAttribute("password1", password1);
                req.setAttribute("email", email);
                req.setAttribute("phone", phone);
                req.setAttribute("sex", sex);
                req.setAttribute("birthday", birthday);

            }

          req.getRequestDispatcher("/Admin/Admin.jsp").forward(req,resp);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
