package com.my.common.validate;

import com.my.common.exception.BizException;
import org.apache.commons.lang.StringUtils;

/**
 * @author wenlf
 * @since 2018/5/2
 */
public class Assert {
    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new BizException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new BizException(message);
        }
    }
}
