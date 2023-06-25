package Course;
import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
@WebServlet(name = "CourseInsert", value = "/CourseInsert")
public class CourseInsert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        HttpSession session=req.getSession();
        String cno=req.getParameter("cno");
        String cname=req.getParameter("cname");
        String score=req.getParameter("score");
        String xs=req.getParameter("xs");
        String teacher=req.getParameter("teacher");
        try {
         con= JDBCUtlis.getConnection();

            String sql= "INSERT INTO Course (cno,cname,score,xs,teacher) " +
                    "values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,cno);
            ps.setString(2,cname);
            ps.setString(3,score);
            ps.setString(4,xs);
            ps.setString(5,teacher);
            int num= ps.executeUpdate();
            if(num>0){
                System.out.println("添加成功");
                req.getRequestDispatcher("CourseDisplay").forward(req,resp);
            }else{
                System.out.println("添加失败");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
