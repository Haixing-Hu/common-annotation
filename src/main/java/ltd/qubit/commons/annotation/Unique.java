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
import jakarta.validation.constraints.NotNull;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此标注表示属性取值是全局或局部唯一的。
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target({FIELD})
@Documented
public @interface Unique {

  /**
   * 表示该属性取值相对于另一个或多个属性是局部唯一的。
   *
   * @return 所相对的属性的名称列表，按照相对顺序排列。
   */
  String[] respectTo() default {};

  /**
   * 表示在比较该属性取值时是否忽略大小写。
   *
   * <p>此选项仅对字符串属性有效。默认值为{@code true}。
   *
   * @return 在比较该属性取值时是否忽略大小写。
   */
  boolean ignoreCase() default true;

  @Target({FIELD})
  @Retention(RUNTIME)
  @Documented
  @interface List {
    NotNull[] value();
  }

}
