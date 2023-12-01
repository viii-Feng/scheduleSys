package com.oneschedule.schedule.service;

/**
 * ClassName: SysUserService
 * Package: com.oneschedule.schedule.service
 * Description:
 *
 * @Author wind
 * @Create 2023/12/1 11:10
 * @Version 1.0
 */

import com.oneschedule.schedule.pojo.SysUser;

/**
 * 该接口定义了以sys_user为核心的业务处理
 */
public interface SysUserService {


    /**
     * 注册用户方法
     * @param sysUser 注册用户名和密码
     * @return 成功=1，失败返回0
     */
    int regist(SysUser sysUser);

    /**
     * 登录用户方法
     * @param username 根据用户名查询用户
     * @return 成功=1，失败返回0
     */
    SysUser findByUsername(String username);
}
