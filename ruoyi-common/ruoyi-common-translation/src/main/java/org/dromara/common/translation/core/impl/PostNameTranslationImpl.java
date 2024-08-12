package org.dromara.common.translation.core.impl;

import lombok.AllArgsConstructor;
import org.dromara.common.core.service.DeptService;
import org.dromara.common.core.service.PostService;
import org.dromara.common.translation.annotation.TranslationType;
import org.dromara.common.translation.constant.TransConstant;
import org.dromara.common.translation.core.TranslationInterface;

/**
 * 部门翻译实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@TranslationType(type = TransConstant.POST_ID_TO_NAME)
public class PostNameTranslationImpl implements TranslationInterface<String> {

    private final PostService postService;

    @Override
    public String translation(Object key, String other) {
        if (key instanceof String ids) {
            return postService.selectPostNameByIds(ids);
        } else if (key instanceof Long id) {
            return postService.selectPostNameByIds(id.toString());
        }
        return null;
    }
}
