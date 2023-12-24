package com.oneschedule.schedule.service.impl;

import com.oneschedule.schedule.dao.SysUserDao;
import com.oneschedule.schedule.dao.impl.SysUserDaoImpl;
import com.oneschedule.schedule.pojo.SysUser;
import com.oneschedule.schedule.service.SysUserService;
import com.oneschedule.schedule.util.MD5Util;

/**
 * ClassName: SysUserServiceImpl
 * Package: com.oneschedule.schedule.service.impl
 * Description:
 *
 * @Author wind
 * @Create 2023/12/1 11:13
 * @Version 1.0
 */
public class SysUserServiceImpl implements SysUserService {

private SysUserDao userDao=new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {
        //将用户的明文密码转化为密文密码
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        //调用dao层将数据存入数据库
        return userDao.addSysUser(sysUser);

    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }


}
