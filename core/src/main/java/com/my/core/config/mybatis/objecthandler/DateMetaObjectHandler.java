package com.my.core.config.mybatis.objecthandler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * 创建日期、修改日期，等公共字段自动填充
 * @author wenlf
 * @since 2018/4/24
 */
public class DateMetaObjectHandler extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.autoFill(metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.autoFill(metaObject);
    }

    private void autoFill(MetaObject metaObject){
        // createDate,updateDate创建日期、修改日期;创建人，修改人
        Object createDate = getFieldValByName("createDate", metaObject);
        if (createDate == null) {
            setFieldValByName("createDate", new Date(), metaObject);
        }
        setFieldValByName("updateDate", new Date(), metaObject);
    }
}
