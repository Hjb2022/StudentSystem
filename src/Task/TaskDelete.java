package Task;

import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "TaskDelete", value = "/TaskDelete")
public class TaskDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sno1=req.getParameter("stusno");
        System.out.println(sno1);
        try {
        con= JDBCUtlis.getConnection();
            String sql= "delete from task where sno=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,sno1);
            int num= ps.executeUpdate();
            if(num>0){
                System.out.println("É¾³ý³É¹¦");
                req.getRequestDispatcher("/TaskDisplay").forward(req,resp);
            }else{
                System.out.println("É¾³ýÊ§°Ü");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
