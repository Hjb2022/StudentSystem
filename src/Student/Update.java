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

@WebServlet(name = "Update", value = "/Update")

public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sno=req.getParameter("sno");
        String sname=req.getParameter("username");
        String sex=req.getParameter("sex");
        String clazz=req.getParameter("clazz");
        String birthday=req.getParameter("birthday");
        String tel=req.getParameter("tel");
        User user=new User();
        System.out.println("你好");
        List<Student> list=new ArrayList<>();
        HttpSession session=req.getSession();
        try {
        con= JDBCUtlis.getConnection();
            String sql= "update student set sname=?,sex=?,clazz=?,Birthday=?,Tel=? where sno=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,sname);
            ps.setString(2,sex);
            ps.setString(3,clazz);
            ps.setString(4,birthday);
            ps.setString(5,tel);
            ps.setString(6,sno);
            int number=ps.executeUpdate();
            if(number>0){
                req.getRequestDispatcher("Display").forward(req,resp);
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
