package Task;

import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
@WebServlet(name = "TaskUpdate", value = "/TaskUpdate")
public class TaskUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String cno=req.getParameter("cno");
        String sno=req.getParameter("sno");
        String t1=req.getParameter("t1");
        String t2=req.getParameter("t2");
        String t3=req.getParameter("t3");
        System.out.println("你好");
        try {
         con= JDBCUtlis.getConnection();
            String sql= "update task set cno=?,t1=?,t2=?,t3=? where sno=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,cno);
            ps.setString(2,t1);
            ps.setString(3,t2);
            ps.setString(4,t3);
            ps.setString(5,sno);
            int number=ps.executeUpdate();
            if(number>0){
                req.getRequestDispatcher("TaskDisplay").forward(req,resp);
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
