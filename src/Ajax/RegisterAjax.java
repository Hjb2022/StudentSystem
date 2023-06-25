package Ajax;

import Modet.User;
import Utils.JDBCUtlis;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterAjax", value = "/RegisterAjax")
public class RegisterAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user=new User();
        PrintWriter out=resp.getWriter();
        String username1=req.getParameter("username");
        try {
            con=JDBCUtlis.getConnection();
            String sql= "select * from user where username=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,username1);
            rs=ps.executeQuery();
            while (rs.next()){
                username1=rs.getString("username");
                user.setUsername(username1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtlis.release(rs, ps, con);
        }
        JSONObject jo=JSONObject.fromObject(user);
        System.out.println(String.valueOf(jo));;
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        out.write(String.valueOf(jo));

    }
}
