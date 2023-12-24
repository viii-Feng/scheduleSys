package com.oneschedule.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: sysSchedule
 * Package: com.oneschedule.schedule.pojo
 * Description:
 *
 * @Author wind
 * @Create 2023/11/30 21:37
 * @Version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule implements Serializable {
    private Integer sid;
    private  Integer uid;
    private String title;
    private Integer completed;
}
