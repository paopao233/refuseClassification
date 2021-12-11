package com.parklot.common.compoent;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * ClassName timeFill
 * Description TODO
 * Author lezi
 * Date 2021/5/6 15:51
 * Version 1.0
 **/
@Component
public class EntityObjectAutoFillStrategy implements MetaObjectHandler {
    /**
     * 插入数据自动填充时间
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 第一个参数fieldName对应实体类属性值

        //填充uuid
        String uuid = IdUtil.simpleUUID();
        this.setFieldValByName("uuid", uuid, metaObject);

        //自动填充时间
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);


    }

    /**
     * 更新数据自动更新时间
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }


}
