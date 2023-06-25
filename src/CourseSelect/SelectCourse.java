package CourseSelect;
import Utils.JDBCUtlis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name = "SelectCourse", value = "/SelectCourse")
public class SelectCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        HttpSession session=req.getSession();
       String sno= (String) session.getAttribute("sno");
        String cno=req.getParameter("cno");
        System.out.println(cno);
        System.out.println(sno);
        try {
       con= JDBCUtlis.getConnection();

            String sql= "INSERT INTO task(cno,sno)\n" +
                    "VALUES(?,?)" ;
            ps = con.prepareStatement(sql);
            ps.setString(1,cno);
            ps.setString(2,sno);
            int num= ps.executeUpdate();
            if(num>0){
                System.out.println("添加成功");
                req.getRequestDispatcher("StudentQuery").forward(req,resp);
            }else{
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.println(
                        "<script language='javascript'>alert('该学生已选择了课程');window.location='admin/Login.jsp'</script>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
