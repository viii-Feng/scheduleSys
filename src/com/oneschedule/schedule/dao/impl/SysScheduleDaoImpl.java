package com.oneschedule.schedule.dao.impl;

import com.oneschedule.schedule.dao.BaseDao;
import com.oneschedule.schedule.dao.SysScheduleDao;
import com.oneschedule.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * ClassName: SysScheduleDaoImpl
 * Package: com.oneschedule.schedule.dao.impl
 * Description:
 *
 * @Author wind
 * @Create 2023/11/30 21:52
 * @Version 1.0
 */
public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql="insert into sys_schedule values(DEFAULT,?,?,?)";
        final int rows = baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
        return rows;
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql="select sid,uid,title,completed from sys_schedule";
        return baseQuery(SysSchedule.class,sql);
    }
}
