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

    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        String sql="select sid,uid,title,completed from sys_schedule where uid=?";
        final List<SysSchedule> itemList = baseQuery(SysSchedule.class, sql, uid);
        return itemList;
    }

    @Override
    public Integer addDefaultSchedule(int uid) {
        String sql="insert into sys_schedule values (DEFAULT,?,'请输入日程',0)";
        return baseUpdate(sql,uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule sysSchedule) {
        String sql="update sys_schedule set title=?,completed=? where sid=?";
        return baseUpdate(sql,sysSchedule.getTitle(),sysSchedule.getCompleted(),sysSchedule.getSid());
    }

    @Override
    public Integer removeSchedule(int sid) {
        String sql="delete from sys_schedule where sid=?";
        return baseUpdate(sql,sid);
    }
}
