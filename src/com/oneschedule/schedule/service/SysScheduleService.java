package com.oneschedule.schedule.service;

/**
 * ClassName: SysScheduleService
 * Package: com.oneschedule.schedule.service
 * Description:
 *
 * @Author wind
 * @Create 2023/12/1 11:14
 * @Version 1.0
 */

import com.oneschedule.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * 该接口定义了以Sys_Schedule为核心的业务处理
 */
public interface SysScheduleService {
    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefaultSchedule(int uid);

    Integer updateSchedule(SysSchedule sysSchedule);

    Integer removeSchedule(int sid);
}
