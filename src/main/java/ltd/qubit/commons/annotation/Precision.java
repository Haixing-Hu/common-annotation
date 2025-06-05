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
import java.util.concurrent.TimeUnit;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此注解指定{@link java.time.Instant}字段值的精度。
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target({FIELD})
@Documented
public @interface Precision {

  /**
   * 默认时间精度。
   */
  TimeUnit DEFAULT_VALUE = TimeUnit.MILLISECONDS;

  /**
   * 表示 {@link java.time.Instant} 字段值的时间精度。
   *
   * @return {@link java.time.Instant} 字段值的时间精度，默认为毫秒。
   */
  TimeUnit value() default TimeUnit.MILLISECONDS;
}