package com.oneschedule.schedule.controller;

import com.oneschedule.schedule.common.Result;
import com.oneschedule.schedule.pojo.SysSchedule;
import com.oneschedule.schedule.service.SysScheduleService;
import com.oneschedule.schedule.service.impl.SysScheduleServiceImpl;
import com.oneschedule.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@WebServlet(value="/schedule/*",name="scheduleServlet")
public class SysScheduleController  extends BaseController {
    private SysScheduleService scheduleService=new SysScheduleServiceImpl();
    /*
    找到当前用户所有日程
     */
    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受请求中的uid
        final int uid = Integer.parseInt(req.getParameter("uid"));
        // 查询用户所有日程
        List<SysSchedule> scheduleList=scheduleService.findItemListByUid(uid);
        // 将所有日程放入result对象
        //final Result<List<SysSchedule>> result = Result.ok(scheduleList);
        //最好不放list集合，放map，后续操作会简单些
        Map data=new HashMap();
        data.put("itemList",scheduleList);
        final Result result = Result.ok(data);
        // 将result对象转换为json响应给客户端
        WebUtil.writeJson(resp,result);


    }
    /*
    增加空白日程
    */
    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受请求中的uid
        final int uid = Integer.parseInt(req.getParameter("uid"));
        // 调用服务层方法向数据库增加空记录
        scheduleService.addDefaultSchedule(uid);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受请求中的JSON转换成sysSchedule
        final SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        // 调用服务层方法向数据库更改记录
        scheduleService.updateSchedule(sysSchedule);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受请求中的sid
        final int sid = Integer.parseInt(req.getParameter("sid"));
        // 调用服务层方法向数据库增加空记录
        scheduleService.removeSchedule(sid);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

