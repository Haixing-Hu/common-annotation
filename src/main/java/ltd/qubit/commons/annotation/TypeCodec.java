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

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此标注声明某个类使用指定的编码器进行和字符串之间的转换。
 */
@Retention(RUNTIME)
@Target(TYPE)
@Documented
public @interface TypeCodec {

  /**
   * 被标注类使用的编码器的类。
   *
   * @return 被标注类使用的编码器的类。
   */
  Class<?> value();
}
