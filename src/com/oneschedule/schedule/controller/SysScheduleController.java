package com.oneschedule.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: SysScheduleController
 * Package: com.oneschedule.schedule.controller
 * Description:
 *
 * @Author wind
 * @Create 2023/12/1 20:51
 * @Version 1.0
 */

/**
 * 判断此次请求是增删改查：路径后缀
 * 增：/schedule/add
 * 删：/schedule/remove
 * 改：/schedule/update
 * 查： /schedule/find
 */
@WebServlet("/schedule/*")
public class SysScheduleController  extends BaseController {

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");


    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

