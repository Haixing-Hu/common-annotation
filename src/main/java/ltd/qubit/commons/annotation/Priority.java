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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此注解声明某个字段或类在特定的操作中的优先级。
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target({FIELD, TYPE})
@Documented
public @interface Priority {

  /**
   * 指定字段的优先级。
   *
   * @return 指定对象的优先级。
   */
  int value();
}
