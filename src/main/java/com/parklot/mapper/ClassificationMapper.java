package com.parklot.mapper;

import com.parklot.entity.Classification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ale
 * @since 2021-11-24
 */
public interface ClassificationMapper extends BaseMapper<Classification> {
    /**
     * 查询垃圾分类总共的词条数
     * @return
     */
    int queryClassificationNum();
}
