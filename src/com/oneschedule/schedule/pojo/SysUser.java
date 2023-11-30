package com.oneschedule.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * ClassName: SysUser
 * Package: com.oneschedule.schedule.pojo
 * Description:
 *
 * @Author wind
 * @Create 2023/11/30 21:21
 * @Version 1.0
 */
@AllArgsConstructor /**添加了全参构造**/
@NoArgsConstructor  /**添加了无参构造**/
@Data               /**添加了get set equals hashcode toString**/
public class SysUser {
    private Integer uid;
    private String username;
    private String userPwd;

}
