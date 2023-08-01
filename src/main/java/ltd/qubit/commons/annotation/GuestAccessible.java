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
 * 此注解表示被标注的方法可以被访客用户所访问。
 *
 * <p>此注解通常被标注在 RESTful 的 Controller 方法上。</p>
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface GuestAccessible {
  // empty
}
