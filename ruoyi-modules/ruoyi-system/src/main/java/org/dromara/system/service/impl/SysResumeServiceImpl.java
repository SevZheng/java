package org.dromara.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.dromara.common.core.exception.ServiceException;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.helper.DataBaseHelper;
import org.dromara.system.domain.SysDept;
import org.dromara.system.domain.SysPost;
import org.dromara.system.domain.SysResume;
import org.dromara.system.domain.bo.SysPostBo;
import org.dromara.system.domain.bo.SysResumeBo;
import org.dromara.system.domain.vo.SysPostVo;
import org.dromara.system.domain.vo.SysResumeVo;
import org.dromara.system.mapper.SysResumeMapper;
import org.dromara.system.service.ISysResumeService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pbb
 * @date 2024/8/12
 */
@Service
public class SysResumeServiceImpl implements ISysResumeService {

    @Resource
    private SysResumeMapper sysResumeMapper;

    @Override
    public TableDataInfo<SysResumeVo> selectPageResumeList(SysResumeBo post, PageQuery pageQuery) {
        Page<SysResumeVo> page = sysResumeMapper.selectPageResumeList(pageQuery.build(), buildQueryWrapper(post));
        return TableDataInfo.build(page);
    }

    @Override
    public SysResumeVo selectPostById(Long resumeId) {
        return sysResumeMapper.selectVoById(resumeId);
    }

    @Override
    public int insertPost(SysResumeBo bo) {
        SysResume resume = MapstructUtils.convert(bo, SysResume.class);
        return sysResumeMapper.insert(resume);
    }

    @Override
    public int deleteResumeByIds(Long[] resumeIds) {
        return sysResumeMapper.deleteByIds(Arrays.asList(resumeIds));
    }

    @Override
    public int updatePost(SysResumeBo bo) {
        SysResume resume = MapstructUtils.convert(bo, SysResume.class);
        return sysResumeMapper.updateById(resume);
    }

    /**
     * 根据查询条件构建查询包装器
     *
     * @param bo 查询条件对象
     * @return 构建好的查询包装器
     */
    private LambdaQueryWrapper<SysResume> buildQueryWrapper(SysResumeBo bo) {
        LambdaQueryWrapper<SysResume> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(bo.getName()), SysResume::getName, bo.getName())
            .like(StringUtils.isNotBlank(bo.getPhone()), SysResume::getPhone, bo.getPhone())
            .like(StringUtils.isNotBlank(bo.getEmail()), SysResume::getEmail, bo.getEmail())
            .like(StringUtils.isNotBlank(bo.getEnglishLevel()), SysResume::getEnglishLevel, bo.getEnglishLevel())
            .eq(StringUtils.isNotBlank(bo.getStatus()), SysResume::getStatus, bo.getStatus())
            .eq(ObjectUtil.isNotNull(bo.getPostId()), SysResume::getPostId, bo.getPostId())
            .eq(ObjectUtil.isNotNull(bo.getDeliver()), SysResume::getDeliver, bo.getDeliver())
            .orderByAsc(SysResume::getCreateTime);
        return wrapper;
    }
}
