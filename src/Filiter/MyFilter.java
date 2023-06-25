package Filiter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1=(HttpServletRequest)request;
        System.out.println("ÄãºÃ");
        System.out.println(request1.getServletPath());
        if("/LoginGo".equalsIgnoreCase(request1.getServletPath())
                ||"/Admin/Login.jsp".equalsIgnoreCase(request1.getServletPath())
                ||"/index.jsp".equalsIgnoreCase(request1.getServletPath())
                ||"/Admin/Register.jsp".equalsIgnoreCase(request1.getServletPath())
                ||"/Register".equalsIgnoreCase(request1.getServletPath())
                ||"/RegisterAjax".equalsIgnoreCase(request1.getServletPath())

        ){
            chain.doFilter(request, response);

        }else{
            if (request1.getSession().getAttribute("user")==null){
                request1.getRequestDispatcher("/Admin/Login.jsp").forward(request,response);
            }else{
                chain.doFilter(request, response);
            }
        }
    }
}
