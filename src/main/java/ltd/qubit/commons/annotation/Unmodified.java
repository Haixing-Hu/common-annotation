////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此标注声明某个操作不做修改的字段。
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface Unmodified {

  /**
   * 指明某个操作不做修改的字段的名称列表。
   *
   * @return 该操作不做修改的字段的名称列表。
   */
  String[] value() default {};
}
