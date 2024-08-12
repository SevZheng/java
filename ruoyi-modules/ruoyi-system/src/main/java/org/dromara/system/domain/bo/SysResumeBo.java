package org.dromara.system.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.SysResume;

import java.util.Date;

/**
 * @author pbb
 * @date 2024/8/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SysResume.class, reverseConvertGenerate = false)
public class SysResumeBo extends BaseEntity {
    /**
     * 简历序号
     */
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

}
