////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2023.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.math.RoundingMode;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此标注指定高精度数值计算和输出时的舍入方式。
 *
 * @author 胡海星
 * @see java.math.BigDecimal
 */
@Retention(RUNTIME)
@Target({FIELD})
@Documented
public @interface Round {

  /**
   * 高精度数值计算和输出时默认的舍入方式，其默认值为{@link RoundingMode#HALF_UP}.
   */
  RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

  /**
   * 高精度数值计算和输出时的舍入方式，其默认值为{@link RoundingMode#HALF_UP}.
   *
   * @return 数值计算和输出时的舍入方式。
   */
  RoundingMode value() default RoundingMode.HALF_UP;
}
