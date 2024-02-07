package com.oneschedule.schedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneschedule.schedule.common.Result;
import com.oneschedule.schedule.common.ResultCodeEnum;
import com.oneschedule.schedule.pojo.SysUser;
import com.oneschedule.schedule.service.SysUserService;
import com.oneschedule.schedule.service.impl.SysUserServiceImpl;
import com.oneschedule.schedule.util.MD5Util;
import com.oneschedule.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.runner.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

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
       //修改前端为vue+vite后，接受客户端json参数，并转化为user对象
        //final String username = req.getParameter("username");
        //final String userPwd =  req.getParameter("userPwd");
        //webutil实例化如下方法：
       /* final BufferedReader reader = req.getReader();
        StringBuffer sbf=new StringBuffer();
        String line = reader.readLine();
        while(line!=null){
            sbf.append(line);
            line = reader.readLine();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        final SysUser sysUser1 = objectMapper.readValue(sbf.toString(), SysUser.class);*/
        final SysUser registUser = WebUtil.readJson(req, SysUser.class);
        //将参数放入一个sysuser对象中，防止参数过多代码难写
        //SysUser  sysUser=new SysUser(null,username,userPwd);
        //调用服务层方法，完成注册功能
        //int rows=userService.regist(sysUser);
        int rows=userService.regist(registUser);
        //根据结果跳转页面
        //因为重写了前端，所以以下跳转失效
        /*if(rows>0){
            resp.sendRedirect("/registSuccess.html");
        }
        else{
            resp.sendRedirect("/registFail.html");
        }*/
        //重新返回：
        Result result=Result.ok(null);
        if(rows<1){
            Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
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
        //修改前端为vue+vite后，接受客户端json参数，并转化为user对象
       /* final String username = req.getParameter("username");
        final String userPwd =  req.getParameter("userPwd");*/
        final SysUser sysUser1 = WebUtil.readJson(req, SysUser.class);
        SysUser  sysUser=userService.findByUsername(sysUser1.getUsername());
        //根据结果跳转页面
        //不再用页面跳转形式做响应
        Result result=null;
        if(sysUser==null){
            /*resp.sendRedirect("/loginUsernameError.html");*/
            result=Result.build(null,ResultCodeEnum.USERNAEM_ERROR);

        }

        else if(!MD5Util.encrypt(sysUser1.getUserPwd()).equals(sysUser.getUserPwd())){
            /*resp.sendRedirect("/loginUserPwdError.html");*/
            result=Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }
        else {
           /* //登录成功后，把用户信息放入session
            final HttpSession session = req.getSession();
            session.setAttribute("sysUser",sysUser);

            resp.sendRedirect("/showSchedule.html");*/
            //登陆成功，将用户uid和username响应给客户端
            Map data=new HashMap();
            sysUser.setUserPwd("");
            data.put("loginUser",sysUser);
            result=Result.ok(data);
        }
        //改成result后，将登录结果返回给客户端
        WebUtil.writeJson(resp,result);
    }

    /**
     * 校验注册用户名是否被占用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受用户名
        final String username = req.getParameter("username");
        //调用服务层方法
        final SysUser sysUser = userService.findByUsername(username);
        //如果有，响应已占用，没有，响应可用
        Result result=Result.ok(null);
        if(null !=sysUser){
            result=Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }
}
