package org.dromara.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import org.dromara.common.translation.annotation.Translation;
import org.dromara.common.translation.constant.TransConstant;
import org.dromara.system.domain.SysResume;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 简历信息视图对象 sys_resume
 *
 * @author Michelle.Chung
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SysResume.class)
public class SysResumeVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 简历序号
     */
    private Long resumeId;

    /**
     * 岗位id
     */
    private Long postId;

    /**
     * 岗位名
     */
    @Translation(type = TransConstant.POST_ID_TO_NAME, mapper = "postId")
    private String postName;

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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;

    /**
     * 英语级别
     */
    private String englishLevel;

    /**
     * 创建时间
     */
    private Date createTime;
}
