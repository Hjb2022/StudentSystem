package Course;

import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "CourseSelect", value = "/CourseSelect")
public class CourseSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sno1 = req.getParameter("stusno");
        try {
         con= JDBCUtlis.getConnection();
            String sql = "select * from Course where cno=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, sno1);
            rs = ps.executeQuery();
            while (rs.next()) {
                String cno = rs.getString("cno");
                String cname = rs.getString("cname");
                String score = rs.getString("score");
                String xs = rs.getString("xs");
                String teacher = rs.getString("teacher");
                req.setAttribute("cno", cno);
                req.setAttribute("cname", cname);
                req.setAttribute("score", score);
                req.setAttribute("xs", xs);
                req.setAttribute("teacher", teacher);
            }
            req.getRequestDispatcher("/Course/CUpdate.jsp").forward(req, resp);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}