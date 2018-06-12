package pers.li.orm.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解Table--用作表字段和类属性映射关系
 */
//只能标注在类上面
@Target(ElementType.FIELD)
//运行期间
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String value();//映射属性名
}
