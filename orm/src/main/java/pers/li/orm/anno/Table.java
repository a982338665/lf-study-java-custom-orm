package pers.li.orm.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解Table--用作表和类映射关系
 */
//只能标注在类上面
@Target(ElementType.TYPE)
//运行期间
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();//映射表名
}
