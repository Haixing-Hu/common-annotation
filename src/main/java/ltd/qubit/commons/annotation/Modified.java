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

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此注解声明某个操作所修改的字段。
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface Modified {

  /**
   * 指明某个操作所修改的字段的名称列表。
   *
   * @return 该操作所修改的字段的名称列表。
   */
  String[] value() default {};
}