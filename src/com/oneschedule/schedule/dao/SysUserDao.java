package com.oneschedule.schedule.dao;

import com.oneschedule.schedule.pojo.SysUser;

/**
 * ClassName: SysUserDao
 * Package: com.oneschedule.schedule.dao
 * Description:
 *
 * @Author wind
 * @Create 2023/11/30 21:46
 * @Version 1.0
 */
public interface SysUserDao {
    /**
     * 向数据库中增加一个用户记录的方法
     * @param sysUser 包括username userPwd
     * @return 成功1，失败0
     */
    int addSysUser(SysUser sysUser);
    /**
     * 在数据库中查询是否有该用户名
     * @param username 包括username userPwd
     * @return 成功1，失败-1
     */
    SysUser findByUsername(String username);
}
