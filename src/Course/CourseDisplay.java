package Course;
import Modet.Course;
import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CourseDisplay", value = "/CourseDisplay")
public class CourseDisplay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> list=new ArrayList<>();
        HttpSession session=req.getSession();
        try {
         con= JDBCUtlis.getConnection();
            String sql= "select * from Course ";
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Course course=new Course();
                course.setCno(rs.getString("cno"));
                course.setCname(rs.getString("cname"));
                course.setScore(rs.getInt("score"));
                course.setXs(rs.getInt("xs"));
                course.setTeacher(rs.getString("teacher"));
                list.add(course);
                session.setAttribute("list",list);
                req.setAttribute("list",list);
            }
            req.getRequestDispatcher("Course/CDisplay.jsp").forward(req,resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
