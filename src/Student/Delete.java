package Student;
import Utils.JDBCUtlis;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Delete", value = "/Delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        HttpSession session=req.getSession();
        String sno1=req.getParameter("stusno");
        System.out.println(sno1);
        try {
         con= JDBCUtlis.getConnection();
            String sql= "delete from student where sno=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,sno1);
           int num= ps.executeUpdate();
            if(num>0){
                System.out.println("ɾ���ɹ�");
                req.getRequestDispatcher("/Display").forward(req,resp);
            }else{
                System.out.println("ɾ��ʧ��");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
    }
}
