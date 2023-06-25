package Student;
import Modet.Student;
import Modet.User;
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
@WebServlet(name = "Display", value = "/Display")
public class Display extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user=new User();
        List<Student> list=new ArrayList<>();
        HttpSession session=req.getSession();
        try {
           con= JDBCUtlis.getConnection();
            String sql= "select * from student ";
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Student stu=new Student();
                stu.setSno(rs.getInt("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSex(rs.getString("sex"));
                stu.setClazz(rs.getString("clazz"));
                stu.setBirthday(rs.getDate("Birthday"));
                stu.setTel(rs.getString("Tel"));
                list.add(stu);
                session.setAttribute("list",list);
                req.setAttribute("list",list);
            }
            req.getRequestDispatcher("/Student/Display.jsp").forward(req,resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
