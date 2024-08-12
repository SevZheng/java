package org.dromara.system.service;

import org.dromara.system.domain.vo.SysSalaryVo;
import org.dromara.system.domain.bo.SysSalaryBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 工资信息Service接口
 *
 * @author pbb
 * @date 2024-08-12
 */
public interface ISysSalaryService {

    /**
     * 查询工资信息
     *
     * @param salaryId 主键
     * @return 工资信息
     */
    SysSalaryVo queryById(Long salaryId);

    /**
     * 分页查询工资信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 工资信息分页列表
     */
    TableDataInfo<SysSalaryVo> queryPageList(SysSalaryBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的工资信息列表
     *
     * @param bo 查询条件
     * @return 工资信息列表
     */
    List<SysSalaryVo> queryList(SysSalaryBo bo);

    /**
     * 新增工资信息
     *
     * @param bo 工资信息
     * @return 是否新增成功
     */
    Boolean insertByBo(SysSalaryBo bo);

    /**
     * 修改工资信息
     *
     * @param bo 工资信息
     * @return 是否修改成功
     */
    Boolean updateByBo(SysSalaryBo bo);

    /**
     * 校验并批量删除工资信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
