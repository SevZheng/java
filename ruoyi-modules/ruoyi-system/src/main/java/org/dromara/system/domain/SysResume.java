package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.tenant.core.TenantEntity;

import java.util.Date;

/**
 * 简历表 sys_resume
 *
 * @author pbb
 */

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_resume")
public class SysResume extends TenantEntity {

    /**
     * 简历序号
     */
    @TableId(value = "resume_id")
    private Long resumeId;

    /**
     * 岗位id
     */
    private Long postId;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

    /**
     * 简历状态（0未投递 1已投递）
     */
    private Integer deliver;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 工作经验
     */
    private String experience;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 到岗时间
     */
    private Date startDate;

    /**
     * 英语级别
     */
    private String englishLevel;

}
