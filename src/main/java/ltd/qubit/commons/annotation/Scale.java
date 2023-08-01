////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2023.
//    Haixing Hu, Qubit Ltd.
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
 * 此标注指定高精度数值计算和输出时的scale，即小数点后的数字位数。
 *
 * @author 胡海星
 * @see java.math.BigDecimal
 */
@Retention(RUNTIME)
@Target({FIELD})
@Documented
public @interface Scale {

  /**
   * 高精度数值计算和输出时默认的scale，即小数点后的数字位数；其默认值为{@value}.
   */
  int DEFAULT_SCALE = 6;

  /**
   * 高精度数值计算和输出时的scale，即小数点后的数字位数。
   *
   * @return 高精度数值计算和输出时的scale。
   */
  int value() default DEFAULT_SCALE;
}
