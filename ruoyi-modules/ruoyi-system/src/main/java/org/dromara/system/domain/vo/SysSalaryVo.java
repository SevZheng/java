package org.dromara.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.common.translation.annotation.Translation;
import org.dromara.common.translation.constant.TransConstant;
import org.dromara.system.domain.SysSalary;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 工资信息视图对象 sys_salary
 *
 * @author pbb
 * @date 2024-08-12
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SysSalary.class)
public class SysSalaryVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 工资ID
     */
    @ExcelProperty(value = "工资ID")
    private Long salaryId;

    /**
     * 岗位id
     */
    @ExcelProperty(value = "岗位id")
    private Long postId;

    /**
     * 名称
     */
    @Translation(type = TransConstant.POST_ID_TO_NAME, mapper = "postId")
    private String postName;

    /**
     * 身份证号
     */
    @ExcelProperty(value = "身份证号")
    private String idNumber;

    /**
     * 员工编号
     */
    @ExcelProperty(value = "员工编号")
    private String empNumber;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名")
    private String name;

    /**
     * 手机号
     */
    @ExcelProperty(value = "手机号")
    private String phone;

    /**
     * 邮箱
     */
    @ExcelProperty(value = "邮箱")
    private String email;

    /**
     * 工资名称
     */
    @ExcelProperty(value = "工资名称")
    private String salaryName;

    /**
     * 发放月份
     */
    @ExcelProperty(value = "发放月份")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date salaryMon;

    /**
     * 工资
     */
    @ExcelProperty(value = "工资")
    private Double salary;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
