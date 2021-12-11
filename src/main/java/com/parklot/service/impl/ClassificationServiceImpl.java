package com.parklot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.parklot.entity.Classification;
import com.parklot.mapper.ClassificationMapper;
import com.parklot.service.ClassificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ale
 * @since 2021-11-24
 */
@Service
public class ClassificationServiceImpl extends ServiceImpl<ClassificationMapper, Classification> implements ClassificationService {
    @Autowired
    private ClassificationMapper classificationMapper;
    /**
     * 创建垃圾分类词条 啊乐 2021年11月28日 13点34分
     * 手敲的！！
     * 这是水印啊啊啊啊
     * 实训报告
     * @param classification
     * @return
     */
    @Override
    public int createReuseItem(Classification classification) {
        int insertOfRow = classificationMapper.insert(classification);
        return insertOfRow;
    }

    /**
     * 查询所有垃圾分类词条
     * @return
     */
    @Override
    public List<Classification> queryAllClassification() {
        QueryWrapper<Classification> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","content","bywho","status","create_time","belongto")
                    .last("limit 15")
                    .orderByDesc("id");

        List<Classification> classifications = classificationMapper.selectList(queryWrapper);
        return classifications;
    }

    /**
     * 查询垃圾分类总共的词条数
     * @return
     */
    @Override
    public int queryClassificationNum() {
        return classificationMapper.queryClassificationNum();
    }


    /**
     * 根据内容查询垃圾所属分类
     */
    @Override
    public String queryClassificationByName(String content) {
        String result = null;
        QueryWrapper<Classification> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("belongto")
                    .eq("content", content);
        Classification classificationDB = classificationMapper.selectOne(queryWrapper);
        if (!(classificationDB == null)){
            result =  classificationDB.getBelongto();
        }
        return result;
    }

    /**
     * 添加垃圾分类的词条
     */
    @Override
    public int addClassification(Classification classification) {
        int insertOfRow = classificationMapper.insert(classification);
        return insertOfRow;
    }


}
