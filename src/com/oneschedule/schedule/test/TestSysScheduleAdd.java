package com.oneschedule.schedule.test;

import com.oneschedule.schedule.dao.SysScheduleDao;
import com.oneschedule.schedule.dao.impl.SysScheduleDaoImpl;
import com.oneschedule.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: TestSysScheduleAdd
 * Package: com.oneschedule.schedule.test
 * Description:
 *
 * @Author wind
 * @Create 2023/11/30 22:51
 * @Version 1.0
 */
public class TestSysScheduleAdd {
   static SysScheduleDao sysScheduledao;

    @BeforeClass
    public static void init(){
        sysScheduledao=new SysScheduleDaoImpl();
    }
    @Test
    public void test(){
        final int rows = sysScheduledao.addSchedule(new SysSchedule(null, 2, "learn database", 1));
        System.out.println(rows);
        final List<SysSchedule> all = sysScheduledao.findAll();
        all.forEach(System.out::println);


    }
}
