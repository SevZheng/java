package org.dromara.system.controller.system;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.system.domain.vo.SysSalaryVo;
import org.dromara.system.domain.bo.SysSalaryBo;
import org.dromara.system.service.ISysSalaryService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 工资信息
 *
 * @author pbb
 * @date 2024-08-12
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/salary")
public class SysSalaryController extends BaseController {

    private final ISysSalaryService sysSalaryService;

    /**
     * 查询工资信息列表
     */
    @SaCheckPermission("system:salary:list")
    @GetMapping("/list")
    public TableDataInfo<SysSalaryVo> list(SysSalaryBo bo, PageQuery pageQuery) {
        return sysSalaryService.queryPageList(bo, pageQuery);
    }

    /**
     * 获取工资信息详细信息
     *
     * @param salaryId 主键
     */
    @SaCheckPermission("system:salary:query")
    @GetMapping("/{salaryId}")
    public R<SysSalaryVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long salaryId) {
        return R.ok(sysSalaryService.queryById(salaryId));
    }

    /**
     * 新增工资信息
     */
    @SaCheckPermission("system:salary:add")
    @Log(title = "工资信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SysSalaryBo bo) {
        return toAjax(sysSalaryService.insertByBo(bo));
    }

    /**
     * 修改工资信息
     */
    @SaCheckPermission("system:salary:edit")
    @Log(title = "工资信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SysSalaryBo bo) {
        return toAjax(sysSalaryService.updateByBo(bo));
    }

    /**
     * 删除工资信息
     *
     * @param salaryIds 主键串
     */
    @SaCheckPermission("system:salary:remove")
    @Log(title = "工资信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{salaryIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] salaryIds) {
        return toAjax(sysSalaryService.deleteWithValidByIds(List.of(salaryIds), true));
    }
}
