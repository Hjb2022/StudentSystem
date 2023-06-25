package CourseSelect;

import Modet.Information;
import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentQuery", value = "/StudentQuery")
public class StudentQuery extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        System.out.println("11");
        HttpSession session=req.getSession();

        List<Information> list=new ArrayList<>();
        try {
        con= JDBCUtlis.getConnection();
            String sql= "SELECT student.SNo,SName,clazz,CName,t1,t2,t3 FROM student\n" +
                    "                    LEFT JOIN  task\n" +
                    "                    ON student.SNo=task.SNo\n" +
                    "                    LEFT JOIN course\n" +
                    "                    ON task.CNo=course.CNo";
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Information  info=new Information();
                info.setSno(rs.getString("sno"));
                info.setSname(rs.getString("sname"));
                info.setClazz(rs.getString("clazz"));
                info.setCname(rs.getString("cname"));
                info.setT1(rs.getInt("t1"));
                info.setT2(rs.getInt("t2"));
                info.setT3(rs.getInt("t3"));
                list.add(info);
                session.setAttribute("list",list);
                req.setAttribute("list",list);

            }
        req.getRequestDispatcher("/SelectCourse/StuInfo.jsp").forward(req,resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
