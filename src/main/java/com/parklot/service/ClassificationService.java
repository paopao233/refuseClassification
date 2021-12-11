package com.parklot.service;

import com.parklot.entity.Classification;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ale
 * @since 2021-11-24
 */
public interface ClassificationService extends IService<Classification> {
    /**
     * 创建垃圾分类词条
     * @param classification
     * @return
     */
    int createReuseItem(Classification classification);

    /**
     * 查询所有词条
     * @return
     */
    List<Classification> queryAllClassification();

    /**
     * 查询垃圾分类总共的词条数
     * @return
     */
    int queryClassificationNum();

    /**
     * 根据内容查询垃圾所属分类
     */
    String queryClassificationByName(String content);

    /**
     * 添加垃圾分类的词条
     */
    int addClassification(Classification classification);
}
