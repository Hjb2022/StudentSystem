package Task;

import Modet.Task;
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


@WebServlet(name = "TaskDisplay", value = "/TaskDisplay")

public class TaskDisplay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Task> list=new ArrayList<>();
        HttpSession session=req.getSession();
        try {
           con= JDBCUtlis.getConnection();
            String sql= "select * from task ";
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Task task=new Task();
                task.setCno(rs.getString("cno"));
                task.setSno(rs.getString("sno"));
                task.setT1(rs.getInt("t1"));
                task.setT2(rs.getInt("t2"));
                task.setT3(rs.getInt("t3"));
                list.add(task);
                session.setAttribute("list",list);
                req.setAttribute("list",list);
            }
            req.getRequestDispatcher("/Task/TaskDisplay.jsp").forward(req,resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
