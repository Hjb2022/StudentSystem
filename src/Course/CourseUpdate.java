package Course;

import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "CourseUpdate", value = "/CourseUpdate")

public class CourseUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String cno=req.getParameter("cno");
        String cname=req.getParameter("cname");
        String score=req.getParameter("score");
        String xs=req.getParameter("xs");
        String teacher=req.getParameter("teacher");


        System.out.println("你好");
        try {
          con= JDBCUtlis.getConnection();
            String sql= "update course set cno=?,cname=?,score=?,xs=?,teacher=?where cno=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,cno);
            ps.setString(2,cname);
            ps.setString(3,score);
            ps.setString(4,xs);
            ps.setString(5,teacher);
            ps.setString(6,cno);
            int number=ps.executeUpdate();
            if(number>0){
                req.getRequestDispatcher("CourseDisplay").forward(req,resp);
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
