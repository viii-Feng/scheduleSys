package com.oneschedule.schedule.test;

import com.oneschedule.schedule.dao.BaseDao;
import com.oneschedule.schedule.pojo.SysUser;
import org.testng.annotations.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: testBaseDao
 * Package: com.oneschedule.schedule.test
 * Description:
 *
 * @Author wind
 * @Create 2023/11/30 22:10
 * @Version 1.0
 */
public class testBaseDao {
    private static BaseDao basedao;

    @BeforeClass
    public static void initBaseDao(){
        basedao=new BaseDao();
    }

    @Test
    public void test(){
        String sql="select count(1) from sys_user";
        String sql2="select uid,username,user_pwd userPwd from sys_user";
        String sql3="insert into sys_schedule values(DEFAULT,?,?,?)";
        Long count=basedao.baseQueryObject(Long.class,sql);
        System.out.println(count);
        final List<SysUser> sysUserList = basedao.baseQuery(SysUser.class, sql2);
        sysUserList.forEach(System.out::println);
        final int rows = basedao.baseUpdate(sql3, 1, "learn java", 0);
        System.out.println(rows);


    }
}
