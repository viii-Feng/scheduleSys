package com.oneschedule.schedule.controller;

import com.oneschedule.schedule.pojo.SysUser;
import com.oneschedule.schedule.service.SysUserService;
import com.oneschedule.schedule.service.impl.SysUserServiceImpl;
import com.oneschedule.schedule.util.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * ClassName: SysUserController
 * Package: com.oneschedule.schedule.controller
 * Description:
 *
 * @Author wind
 * @Create 2023/12/1 20:49
 * @Version 1.0
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {
    private SysUserService userService=new SysUserServiceImpl();
    /**
     * 接受用户注册请求接口（业务处理接口）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //接受客户端参数
        final String username = req.getParameter("username");
        final String userPwd =  req.getParameter("userPwd");
       //将参数放入一个sysuser对象中，防止参数过多代码难写
        SysUser  sysUser=new SysUser(null,username,userPwd);
        //调用服务层方法，完成注册功能
        int rows=userService.regist(sysUser);
        //根据结果跳转页面
        if(rows>0){
            resp.sendRedirect("/registSuccess.html");
        }
        else{
            resp.sendRedirect("/registFail.html");
        }
    }

    /**
     * 接受用户登录请求接口（业务处理接口）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受客户端参数
        final String username = req.getParameter("username");
        final String userPwd =  req.getParameter("userPwd");
        SysUser  sysUser=userService.findByUsername(username);
        //根据结果跳转页面
        if(sysUser==null){
            resp.sendRedirect("/loginUsernameError.html");
        }

        else if(!MD5Util.encrypt(userPwd).equals(sysUser.getUserPwd())){
            resp.sendRedirect("/loginUserPwdError.html");
        }
        else {
            //登录成功后，把用户信息放入session
            final HttpSession session = req.getSession();
            session.setAttribute("sysUser",sysUser);

            resp.sendRedirect("/showSchedule.html");
        }
    }
}
