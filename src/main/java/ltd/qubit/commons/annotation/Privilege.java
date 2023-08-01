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

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此标注指定接口所需的操作权限。
 *
 * @author 胡海星
 */
@Target({METHOD})
@Retention(RUNTIME)
@Documented
public @interface Privilege {

  /**
   * 指定接口所需的权限的编码。
   *
   * @return
   *     指定接口所需的权限的编码。
   */
  String value();
}
