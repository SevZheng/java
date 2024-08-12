package org.dromara.system.controller.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.web.core.BaseController;
import org.dromara.system.domain.bo.SysResumeBo;
import org.dromara.system.domain.vo.SysResumeVo;
import org.dromara.system.service.ISysResumeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 简历管理
 *
 * @author pbb
 * @date 2024/8/12
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/resume")
public class SysResumeController extends BaseController {


    @Resource
    private ISysResumeService resumeService;

    /**
     * 获取简历列表
     */
    @SaCheckPermission("system:resume:list")
    @GetMapping("/list")
    public TableDataInfo<SysResumeVo> list(SysResumeBo post, PageQuery pageQuery) {
        return resumeService.selectPageResumeList(post, pageQuery);
    }

    /**
     * 根据简历编号获取详细信息
     *
     * @param resumeId 简历ID
     */
    @SaCheckPermission("system:resume:query")
    @GetMapping(value = "/{resumeId}")
    public R<SysResumeVo> getInfo(@PathVariable Long resumeId) {
        return R.ok(resumeService.selectPostById(resumeId));
    }

    /**
     * 新增简历
     *
     * @param bo
     * @return
     */
    @SaCheckPermission("system:resume:add")
    @Log(title = "简历管理", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@Validated @RequestBody SysResumeBo bo) {
        return toAjax(resumeService.insertPost(bo));
    }

    /**
     * 修改简历
     */
    @SaCheckPermission("system:resume:edit")
    @Log(title = "简历管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@Validated @RequestBody SysResumeBo bo) {
        return toAjax(resumeService.updatePost(bo));
    }

    /**
     * 删除简历
     *
     * @param resumeIds 简历ID串
     */
    @SaCheckPermission("system:resume:remove")
    @Log(title = "简历管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{resumeIds}")
    public R<Void> remove(@PathVariable Long[] resumeIds) {
        return toAjax(resumeService.deleteResumeByIds(resumeIds));
    }
}
