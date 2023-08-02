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
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此标注声明某个方法不应被自动化测试。
 *
 * <p>此注解是为了方便进行自动化DAO集成测试时，程序可以区分需要自动化测试的DAO操作和不能自动化
 * 测试的DAO操作。</p>
 *
 * <p>此注解可继承，即如果在父类方法上标注了此注解，此注解对此类重载父类的同名方法也有效。</p>
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
@Inherited
public @interface NoAutoTest {
  //  empty
}
