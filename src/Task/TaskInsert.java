package Task;

import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "TaskInsert", value = "/TaskInsert")
public class TaskInsert extends HttpServlet {
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
        try {

        con= JDBCUtlis.getConnection();

            String sql= "INSERT INTO task (cno,sno,t1,t2,t3) " +
                    "values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,cno);
            ps.setString(2,sno);
            ps.setString(3,t1);
            ps.setString(4,t2);
            ps.setString(5,t3);
            int num= ps.executeUpdate();
            if(num>0){
                System.out.println("添加成功");
                req.getRequestDispatcher("TaskDisplay").forward(req,resp);
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
