package Student;

import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Insert", value = "/Insert")

public class Insert extends HttpServlet {
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
        try {
            con= JDBCUtlis.getConnection();

            String sql= "INSERT INTO student (sno,sname,sex,clazz,Birthday,Tel) " +
                    "values(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,sno);
            ps.setString(2,sname);
            ps.setString(3,sex);
            ps.setString(4,clazz);
            ps.setString(5,birthday);
            ps.setString(6,tel);
            int num= ps.executeUpdate();
            if(num>0){
                System.out.println("添加成功");
                req.getRequestDispatcher("Display").forward(req,resp);
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
