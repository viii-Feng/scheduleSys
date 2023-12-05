package com.oneschedule.schedule.filter;


import com.oneschedule.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * ClassName: LoginFilter
 * Package: com.oneschedule.schedule.filter
 * Description:
 *
 * @Author wind
 * @Create 2023/12/5 15:44
 * @Version 1.0
 */
@WebFilter(urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获得session对象

        //参数父转子：向下转型
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        final HttpSession session = request.getSession();

        //获得用户对象
        final SysUser sysUser = (SysUser)session.getAttribute("sysUser");

        //若为空，跳回登陆界面，有，放行
        if(null==sysUser){
            response.sendRedirect("/login.html");
        }
        else{
            filterChain.doFilter(request,response);
        }
    }
}
