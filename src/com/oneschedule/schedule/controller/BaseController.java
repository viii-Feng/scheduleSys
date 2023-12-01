package com.oneschedule.schedule.controller;

import com.oneschedule.schedule.service.SysUserService;
import com.oneschedule.schedule.service.impl.SysUserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: BaseController
 * Package: com.oneschedule.schedule.controller
 * Description:
 *
 * @Author wind
 * @Create 2023/12/1 21:35
 * @Version 1.0
 */
public class BaseController extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String requestURI = req.getRequestURI();  //获得： (上下文定义路径)/schedule/xxx
        final String[] split = requestURI.split("/");
        String method=split[split.length-1];
        final Class aClass = this.getClass();
        //获取方法
        try {
            final Method declaredMethod = aClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //暴力破解方法的访问修饰符的限制
            declaredMethod.setAccessible(true);
            //执行方法
            declaredMethod.invoke(this,req,resp);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
