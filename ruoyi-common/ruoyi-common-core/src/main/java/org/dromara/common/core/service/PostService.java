package org.dromara.common.core.service;

/**
 * 通用 岗位服务
 *
 * @author Lion Li
 */
public interface PostService {

    /**
     * 通过岗位ID查询岗位名称
     *
     * @param postIds 岗位ID串逗号分隔
     * @return 岗位名称串逗号分隔
     */
    String selectPostNameByIds(String postIds);

}
