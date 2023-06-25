package Student;

import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

@WebServlet(name = "Select", value = "/Select")
public class Select extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        HttpSession session=req.getSession();
        String sno1=req.getParameter("stusno");
        try {
         con= JDBCUtlis.getConnection();
            String sql= "select * from student where sno=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,sno1);
            rs= ps.executeQuery();
            while (rs.next()){
                String sno=rs.getString("sno");
                String sname=rs.getString("sname");
                String sex=rs.getString("sex");
                String  clazz=rs.getString("clazz");
                Date birthday=rs.getDate("Birthday");
                String tel=rs.getString("Tel");
                req.setAttribute("sno",sno);
                req.setAttribute("sname",sname);
                req.setAttribute("sex",sex);
                req.setAttribute("clazz",clazz);
                req.setAttribute("birthday",birthday);
                req.setAttribute("tel",tel);
            }
            req.getRequestDispatcher("/Student/Update.jsp").forward(req,resp);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);

        }


    }
}
