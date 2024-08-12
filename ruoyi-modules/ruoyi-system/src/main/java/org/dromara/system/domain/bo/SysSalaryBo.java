package org.dromara.system.domain.bo;

import org.dromara.system.domain.SysSalary;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 工资信息业务对象 sys_salary
 *
 * @author pbb
 * @date 2024-08-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SysSalary.class, reverseConvertGenerate = false)
public class SysSalaryBo extends BaseEntity {

    /**
     * 工资ID
     */
    @NotNull(message = "工资ID不能为空", groups = { EditGroup.class })
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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date salaryMon;

    /**
     * 工资
     */
    private Double salary;


}
