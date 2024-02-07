package com.oneschedule.schedule.service.impl;

import com.oneschedule.schedule.dao.SysScheduleDao;
import com.oneschedule.schedule.dao.impl.SysScheduleDaoImpl;
import com.oneschedule.schedule.pojo.SysSchedule;
import com.oneschedule.schedule.service.SysScheduleService;

import java.util.List;

/**
 * ClassName: SysScheduleServiceImpl
 * Package: com.oneschedule.schedule.service.impl
 * Description:
 *
 * @Author wind
 * @Create 2023/12/1 11:14
 * @Version 1.0
 */
public class SysScheduleServiceImpl implements SysScheduleService {
    private SysScheduleDao scheduleDao=new SysScheduleDaoImpl();
    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        return scheduleDao.findItemListByUid(uid);
    }

    @Override
    public Integer addDefaultSchedule(int uid) {
        return scheduleDao.addDefaultSchedule(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule sysSchedule) {
        return scheduleDao.updateSchedule(sysSchedule);
    }

    @Override
    public Integer removeSchedule(int sid) {
        return scheduleDao.removeSchedule(sid);
    }
}
