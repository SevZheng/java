package org.dromara.system.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dromara.system.domain.bo.SysSalaryBo;
import org.dromara.system.domain.vo.SysSalaryVo;
import org.dromara.system.domain.SysSalary;
import org.dromara.system.mapper.SysSalaryMapper;
import org.dromara.system.service.ISysSalaryService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 工资信息Service业务层处理
 *
 * @author pbb
 * @date 2024-08-12
 */
@RequiredArgsConstructor
@Service
public class SysSalaryServiceImpl implements ISysSalaryService {

    private final SysSalaryMapper baseMapper;

    /**
     * 查询工资信息
     *
     * @param salaryId 主键
     * @return 工资信息
     */
    @Override
    public SysSalaryVo queryById(Long salaryId){
        return baseMapper.selectVoById(salaryId);
    }

    /**
     * 分页查询工资信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 工资信息分页列表
     */
    @Override
    public TableDataInfo<SysSalaryVo> queryPageList(SysSalaryBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SysSalary> lqw = buildQueryWrapper(bo);
        Page<SysSalaryVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的工资信息列表
     *
     * @param bo 查询条件
     * @return 工资信息列表
     */
    @Override
    public List<SysSalaryVo> queryList(SysSalaryBo bo) {
        LambdaQueryWrapper<SysSalary> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SysSalary> buildQueryWrapper(SysSalaryBo bo) {
        LambdaQueryWrapper<SysSalary> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getPostId() != null, SysSalary::getPostId, bo.getPostId());
        lqw.eq(StringUtils.isNotBlank(bo.getIdNumber()), SysSalary::getIdNumber, bo.getIdNumber());
        lqw.eq(StringUtils.isNotBlank(bo.getEmpNumber()), SysSalary::getEmpNumber, bo.getEmpNumber());
        lqw.like(StringUtils.isNotBlank(bo.getName()), SysSalary::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getPhone()), SysSalary::getPhone, bo.getPhone());
        lqw.eq(StringUtils.isNotBlank(bo.getEmail()), SysSalary::getEmail, bo.getEmail());
        lqw.like(StringUtils.isNotBlank(bo.getSalaryName()), SysSalary::getSalaryName, bo.getSalaryName());
        lqw.eq(bo.getSalaryMon() != null, SysSalary::getSalaryMon, bo.getSalaryMon());
        lqw.eq(bo.getSalary() != null, SysSalary::getSalary, bo.getSalary());
        return lqw;
    }

    /**
     * 新增工资信息
     *
     * @param bo 工资信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SysSalaryBo bo) {
        SysSalary add = MapstructUtils.convert(bo, SysSalary.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setSalaryId(add.getSalaryId());
        }
        return flag;
    }

    /**
     * 修改工资信息
     *
     * @param bo 工资信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SysSalaryBo bo) {
        SysSalary update = MapstructUtils.convert(bo, SysSalary.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SysSalary entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除工资信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
