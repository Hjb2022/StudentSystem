package CourseSelect;

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

@WebServlet(name = "CourseDisplay1", value = "/CourseDisplay1")
public class CourseDisplay1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> list=new ArrayList<>();
        HttpSession session=req.getSession();
        String sno=req.getParameter("sno");
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
                req.setAttribute("sno",sno);
                session.setAttribute("sno",sno );
                list.add(course);
                session.setAttribute("list",list);
                req.setAttribute("list",list);
            }
            req.getRequestDispatcher("/SelectCourse/CourseInfo.jsp").forward(req,resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
