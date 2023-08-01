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
 * 此标注指定某个属性是对另一个对象的特定属性值的引用。
 *
 * @author 胡海星
 */
@Retention(RUNTIME)
@Target({FIELD})
@Documented
public @interface Reference {

  /**
   * 指定被标注的属性所引用的对象实体的类型。
   *
   * <p>如果此属性值取了其默认值{@code Object.class}，表示被标注的属性本身并非引用过了、
   * 另一个实体对象的属性值，但其内部子属性可能引用了另一个对象实体的属性值。这样的引用方式 称为"间接引用"。</p>
   *
   * <p>例如，{@code Organization.contact}属性标注了{@code entity}为默认的
   * {@code Object.class}的{@code @Reference}注解，这表明{@code Organization.contact}
   * 内部某个属性引用了其他实体对象的属性值；而{@code Contact.address}也被标注了
   * {@code entity}为默认的{@code Object.class}的{@code @Reference}注解，这进一步
   * 表明{@code Organization.contact.address}内部某个属性引用了其他实体的属性值；
   * 最后{@code Address.street}被标注了{@code entity}为{@code Street.class}的
   * {@code @Reference}注解，这表明{@code Organization.contact.address.street}
   * 最终引用了实体类{@code Street}的{@code info}属性值。</p>
   *
   * <p>上述例子的代码大致如下所示：</p>
   *
   * <pre><code>
   * class Organization {
   *   ...
   *
   *   &#64;Reference   // 间接引用
   *   private Contact contact;
   *   ...
   * }
   *
   * class Contact {
   *   ...
   *   &#64;Reference   // 间接引用
   *   private Address address;
   * }
   *
   * class Address {
   *   ...
   *   &#64;Reference(entity = Country.class, property = "info", path = "province/country")
   *   private Info country;
   *
   *   &#64;Reference(entity = Province.class, property = "info", path = "city/province")
   *   private Info province;
   *
   *   &#64;Reference(entity = City.class, property = "info", path = "district/city")
   *   private Info city;
   *
   *   &#64;Reference(entity = District.class, property = "info", path = "street/district")
   *   private Info district;
   *
   *   &#64;Reference(entity = Street.class, property = "info")
   *   private Info street;
   *   ...
   * }
   * </code></pre>
   *
   * @return 被标注字段所引用的对象实体的类对象。
   */
  Class<?> entity() default Object.class;

  /**
   * 指定被标注的属性所引用的对象实体的属性值的属性名称。
   *
   * @return 被标注的属性所引用的对象实体的属性值的属性名称。
   */
  String property() default "";

  /**
   * 表示被标注的属性所引用的对象是否必须已存在于数据库中。
   *
   * <p>此属性默认值为{@code true}，表示所引用的对象应该是已经存在于数据库中的对象，
   * 因此构造该对象时需要将其预先添加到数据库中。如果此属性值为{@code false}，则表示
   * 所引用的对象不需要预先加入数据库中，但该对象的内容子属性可能也是引用其他需加入数 据库的对象。</p>
   *
   * <p>例如：{@code Credential.attachments}属性就引用了{@code existing}为
   * {@code false}的{@code Attachment}对象，即在构建一个合法的{@code Credential}
   * 时，其{@code attachments}属性(是一个列表)中的{@code Attachment}对象无需预先
   * 加入数据库；但{@code Attachment.upload}属性引用了{@code existing}为{@code true}
   * 的{@code Upload}对象，因此每个{@code Attachment}对象的{@code upload}属性必须引
   * 用一个已经加入数据库的{@code Upload}对象。</p>
   *
   * <p>上述例子的详情可参见{@code Credential}类的属性注解。</p>
   *
   * @return 被标注的属性所引用的对象是否必须已存在于数据库中。
   */
  boolean existing() default true;

  /**
   * 表示被标注的属性所引用的对象在该属性所属对象的属性树中的路径。
   *
   * <p>某些情况下被标注的属性所引用的对象，与该属性所属对象的属性树中的某个属性所引用
   * 的对象是同一个对象。例如：{@code Address.district}所引用的{@code District}对象，
   * 与{@code Address.street}所引用的{@code Street}对象的{@code district}属性所引
   * 用的{@code District}对象是同一个对象。因此我们需要对{@code Address.district}标
   * 注一个{@code path = "street/district"}的{@code @Reference}注解。 具体注解代码大致如下：</p>
   *
   * <pre><code>
   * &#64;XmlElement(name = "country")
   * &#64;JsonProperty(value = "country")
   * &#64;Reference(entity = Country.class, property = "info", path = "province/country")
   * &#64;Nullable
   * private Info country;
   *
   * &#64;XmlElement(name = "province")
   * &#64;JsonProperty(value = "province")
   * &#64;Reference(entity = Province.class, property = "info", path = "city/province")
   * &#64;Nullable
   * private Info province;
   *
   * &#64;XmlElement(name = "city")
   * &#64;JsonProperty(value = "city")
   * &#64;Reference(entity = City.class, property = "info", path = "district/city")
   * &#64;Nullable
   * private Info city;
   *
   * &#64;XmlElement(name = "district")
   * &#64;JsonProperty(value = "district")
   * &#64;Reference(entity = District.class, property = "info", path = "street/district")
   * &#64;Nullable
   * private Info district;
   *
   * &#64;XmlElement(name = "street")
   * &#64;JsonProperty(value = "street")
   * &#64;Reference(entity = Street.class, property = "info")
   * &#64;Nullable
   * private Info street;
   * </code></pre>
   *
   * <p>{@code path}属性还支持对对象树中父对象属性的引用。例如，假设我们用类
   * {@code Order}表示订单，类{@code OrderItem}表示订单项，其结构大致如下：</p>
   *
   * <pre><code>
   * class Order {
   *   ...
   *   &#64;XmlElementWrapper(name = "items")
   *   &#64;XmlElement(name = "item")
   *   &#64;JsonProperty(value = "items")
   *   &#64;Reference(entity = OrderItem.class, existing = false)
   *   private List&lt;OrderItem&gt; items;
   *   ...
   * }
   *
   * class OrderItem {
   *   ...
   *   &#64;XmlElement(name = "order-id")
   *   &#64;JsonProperty(value = "order_id")
   *   &#64;Reference(entity = Order.class, property = "id", path = "..")
   *   private Long orderId;
   *   ...
   * }
   * </code></pre>
   * <p>
   * 注意其中{@code order.items}是该订单的所有订单项列表，在生成订单对象时，不要求其
   * 订单项是已存在的，因此其{@code Reference}注解的{@code existing}属性值为{@code false}。
   * {@code orderItem.orderId}是该订单项所属的订单的ID，因此其{@code Reference}注解
   * 的{@code path}属性值为{@code ..}，其中".."表示上一层的对象。
   *
   * @return 被标注的属性所引用的对象在其所属对象属性树中的路径。
   */
  String path() default "";
}
