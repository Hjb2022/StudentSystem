package Ajax;

import Modet.Course;
import Modet.User;
import Utils.JDBCUtlis;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "CourseAjax", value = "/CourseAjax")
public class CourseAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course course=new Course();
        PrintWriter out=resp.getWriter();
        String cno=req.getParameter("cno");
        System.out.println("nihao");

        System.out.println(cno);
        try {
            con= JDBCUtlis.getConnection();
            String sql= "select * from course where cno=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,cno);
            rs=ps.executeQuery();
            while (rs.next()){
                cno=rs.getString("cno");
                course.setCno(cno);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
        JSONObject jo=JSONObject.fromObject(course);
        System.out.println(String.valueOf(jo));;
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        out.write(String.valueOf(jo));
    }
}
