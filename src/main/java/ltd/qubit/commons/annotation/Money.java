////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2025.
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
 * 此注解声明某个属性的值将被作为货币金额处理。
 *
 * <p>该属性类型建议为{@link java.math.BigDecimal}.</p>
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target({FIELD})
@Documented
public @interface Money {

  /**
   * 高精度数值计算和输出时默认的scale，即小数点后的数字位数；其默认值为{@value}.
   */
  int DEFAULT_SCALE = 4;

  /**
   * 高精度数值计算和输出时默认的舍入方式，其默认值为{@link RoundingMode#HALF_UP}.
   */
  RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

  /**
   * 小数点后保留的数字位数，默认值为{@code 4}。
   *
   * @return
   *     小数点后保留的数字位数。
   */
  int scale() default DEFAULT_SCALE;

  /**
   * 货币金额计算时默认的舍入方式，其默认值为{@link RoundingMode#HALF_UP}.
   *
   * @return
   *     货币金额计算时默认的舍入方式。
   */
  RoundingMode roundingModel() default RoundingMode.HALF_UP;

  /**
   * 货币金额输出时是否显示分组，默认值为{@code false}.
   *
   * @return
   *     货币金额输出时是否显示分组。
   */
  boolean useGroup() default false;
}