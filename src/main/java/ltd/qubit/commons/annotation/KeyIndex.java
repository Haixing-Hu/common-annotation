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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 此标注声明某个字段在被作为复合索引时，在复合索引中的出现的位置顺序。
 * <p>
 * 例如，{@code Payload}类有个{@code owner}属性，表示该{@code Payload}的所有者。
 * {@code owner}属性是另一个类，有{@code type}和{@code id}字段。在数据库建索引时，
 * 会为{@code Payload}类对应的表{@code payload}建立一个名为{@code owner}的复合索引，
 * 用到的列分别为{@code owner_type}, {@code owner_id}。具体SQL语句大致如下：
 * <p>
 * <pre><code>
 *   INDEX `owner` (`owner_type`, `owner_id`)
 * </code></pre>
 * <p>
 * 为了能正确对该索引的值表示为字符串，我们需要在{@code owner.type}和{@code owner.id}
 * 字段定义上分别标注{@code @KeyIndex(0)}和{@code @KeyIndex(1)}。Java代码大致如下：
 * <p>
 * <pre><code>
 * class Owner {
 *    &#064;KeyIndex(0)
 *    private String type;
 *    &#064;KeyIndex(1)
 *    private Long id;
 * }
 * </code></pre>
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target({FIELD})
@Documented
public @interface KeyIndex {

  /**
   * 声明某个字段在被作为复合索引时，在复合索引中出现的位置顺序。
   *
   * @return
   *     该字段在被作为复合索引时，在复合索引中的出现的位置顺序，从0开始编号。
   */
  int value() default 0;
}
