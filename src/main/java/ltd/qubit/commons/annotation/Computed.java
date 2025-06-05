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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此注解声明某个属性或getter方法是计算出的bean属性而非只读属性。
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target({FIELD, METHOD})
@Documented
public @interface Computed {

  /**
   * 指明该计算出的属性所依赖的字段的名称列表。
   *
   * @return 该计算出的属性所依赖的字段的名称列表。
   */
  String[] value() default {};
}