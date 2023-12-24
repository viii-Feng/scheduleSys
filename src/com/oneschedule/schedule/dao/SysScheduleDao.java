package com.oneschedule.schedule.dao;

import com.oneschedule.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * ClassName: SysScheduleDao
 * Package: com.oneschedule.schedule.dao
 * Description:
 *
 * @Author wind
 * @Create 2023/11/30 21:47
 * @Version 1.0
 */
public interface SysScheduleDao {
/*    *
     * 该方法用于向数据种增加一条日程记录
     * @param schedule 日程记录以SysSchedule实体类对象形式写入
     * @return 影响数据库的行数，=0增加失败 >0增加成功*/

    int addSchedule(SysSchedule schedule);

    List<SysSchedule> findAll();



}
