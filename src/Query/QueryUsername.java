package Query;

import Utils.JDBCUtlis;

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

@WebServlet(name = "QueryUsername", value = "/QueryUsername")
public class QueryUsername extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String id=req.getParameter("username");
        System.out.println(id);
        int flag=0;
        try {
            con= JDBCUtlis.getConnection();
            String sql= "SELECT student.SNo,SName,clazz,CName,t1,t2,t3 FROM student\n" +
                    "LEFT JOIN  task\n" +
                    "ON student.SNo=task.SNo\n" +
                    "LEFT JOIN course\n" +
                    "ON task.CNo=course.CNo\n" +
                    "WHERE student.sname=?\n";

            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String clazz = rs.getString("clazz");
                String cname = rs.getString("cname");
                String t1 = rs.getString("t1");
                String t2 = rs.getString("t2");
                String t3 = rs.getString("t3");

                req.setAttribute("sno1", sno);
                req.setAttribute("sname", sname);
                req.setAttribute("clazz", clazz);
                req.setAttribute("cname", cname);
                req.setAttribute("t1", t1);
                req.setAttribute("t2", t2);
                req.setAttribute("t3", t3);
                flag=1;
            }
            if(flag==1){
                req.getRequestDispatcher("/Query/query.jsp").forward(req,resp);
            }else{
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.println(
                        "<script language='javascript'>alert('查询不到该姓名！');window.location='Query/query.jsp'</script>");

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
