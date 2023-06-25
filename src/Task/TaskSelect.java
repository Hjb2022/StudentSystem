package Task;

import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "TaskSelect", value = "/TaskSelect")

public class TaskSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sno1 = req.getParameter("stusno");
        System.out.println("ÄãºÃ");
        try {
         con= JDBCUtlis.getConnection();
            String sql = "select * from task where sno=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, sno1);
            rs = ps.executeQuery();
            while (rs.next()) {
                String cno = rs.getString("cno");
                String sno = rs.getString("sno");
                String t1 = rs.getString("t1");
                String t2 = rs.getString("t2");
                String t3 = rs.getString("t3");
                req.setAttribute("cno", cno);
                req.setAttribute("sno", sno);
                req.setAttribute("t1", t1);
                req.setAttribute("t2", t2);
                req.setAttribute("t3", t3);
            }
            req.getRequestDispatcher("/Task/TaskUpdate.jsp").forward(req, resp);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
