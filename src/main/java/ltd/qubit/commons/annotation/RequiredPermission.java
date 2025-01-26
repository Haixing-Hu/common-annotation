/// /////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2024 - 2025.
//    Nanjing Xinglin Digital Technology Co., Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 此注解表示某个接口方法需要指定的权限才能被访问。
 * <p>
 * 此注解仅用于标注功能权限，数据权限不使用此注解标注。
 *
 * @author 胡海星
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RequiredPermission {
  /**
   * 指定访问该接口方法需要的权限。
   * <p>
   * 如果接口是对某个资源的访问，则权限的命名方式必须是
   * <pre>{@code
   *  <资源类型>_<操作>
   * }</pre>
   * 比如：{@code USER_ADD}、{@code USER_GET}、{@code USER_UPDATE}、{@code USER_DELETE}。
   *
   * @return
   *     访问该接口方法需要的权限列表。
   */
  String[] value();

  /**
   * 多个权限之间的逻辑关系：AND / OR
   *
   * @return
   *    多个权限之间的逻辑关系。
   */
  Logical logical() default Logical.AND;
}
