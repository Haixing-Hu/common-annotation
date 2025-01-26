/// /////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2024 - 2025.
//    Nanjing Xinglin Digital Technology Co., Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此注解指定一个字段的值必须是ASCII字符。
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target({FIELD})
@Documented
public @interface AsciiText {
  //  empty
}
