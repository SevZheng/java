package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 工资信息对象 sys_salary
 *
 * @author pbb
 * @date 2024-08-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_salary")
public class SysSalary extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 工资ID
     */
    @TableId(value = "salary_id")
    private Long salaryId;

    /**
     * 岗位id
     */
    private Long postId;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 员工编号
     */
    private String empNumber;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 工资名称
     */
    private String salaryName;

    /**
     * 发放月份
     */
    private Date salaryMon;

    /**
     * 工资
     */
    private Double salary;


}
