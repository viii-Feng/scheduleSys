package com.oneschedule.schedule.dao.impl;

import com.oneschedule.schedule.dao.BaseDao;
import com.oneschedule.schedule.dao.SysUserDao;
import com.oneschedule.schedule.pojo.SysUser;

import java.util.List;

/**
 * ClassName: SysUserDaoImpl
 * Package: com.oneschedule.schedule.dao.impl
 * Description:
 *
 * @Author wind
 * @Create 2023/11/30 21:52
 * @Version 1.0
 */
public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) {
        String sql="insert into sys_user values(DEFAULT,?,?)";
        return baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd());

    }

    @Override
    public SysUser findByUsername(String username) {
        String sql="select uid,username,user_pwd userPwd from sys_user where username=?";
        final List<SysUser> sysUserList = baseQuery(SysUser.class, sql,username);
        return sysUserList!=null && sysUserList.size()>0?sysUserList.get(0):null;
    }


}
