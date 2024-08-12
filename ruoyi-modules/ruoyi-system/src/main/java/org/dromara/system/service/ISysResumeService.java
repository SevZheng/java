package org.dromara.system.service;

import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.SysPostBo;
import org.dromara.system.domain.bo.SysResumeBo;
import org.dromara.system.domain.vo.SysResumeVo;

/**
 * @author pbb
 * @date 2024/8/12
 */
public interface ISysResumeService {
    TableDataInfo<SysResumeVo> selectPageResumeList(SysResumeBo post, PageQuery pageQuery);

    SysResumeVo selectPostById(Long resumeId);

    int insertPost(SysResumeBo bo);

    int updatePost(SysResumeBo bo);

    int deleteResumeByIds(Long[] resumeIds);
}
