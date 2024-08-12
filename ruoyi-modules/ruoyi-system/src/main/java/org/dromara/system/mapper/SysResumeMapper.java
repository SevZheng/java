package org.dromara.system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.dromara.common.mybatis.annotation.DataColumn;
import org.dromara.common.mybatis.annotation.DataPermission;
import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;
import org.dromara.system.domain.SysResume;
import org.dromara.system.domain.vo.SysResumeVo;

/**
 * @author pbb
 * @date 2024/8/12
 */
public interface SysResumeMapper extends BaseMapperPlus<SysResume, SysResumeVo> {
    @DataPermission({
        @DataColumn(key = "deptName", value = "dept_id"),
        @DataColumn(key = "userName", value = "create_by")
    })
    Page<SysResumeVo> selectPageResumeList(@Param("page") Page<SysResumeVo> page, @Param(Constants.WRAPPER) Wrapper<SysResume> queryWrapper);

}
