package pers.li.orm.jdbc.mysql;

import pers.li.orm.exception.ORMException;
import pers.li.orm.jdbc.utils.JDBCUtils;
import pers.li.orm.orm.ORMTemplate;

import java.lang.reflect.Field;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create by lishengbo 2018/6/11
 * <p>
 * mysql-持久化模板
 */
public class MysqlTemplate extends ORMTemplate {
    /**
     * 新增------
     * insert into 表名(字段...) values (?,?...)
     * 指定表---类映射关系：
     * 1.表名=类名
     * 2.字段=属性名
     * -----
     * 如果拿到的属性值为空(故属性值应尽量设置为包装类型)则不作为新增一部分
     *
     * @param entity
     * @param <T>
     * @throws ORMException
     */
    @Override
    public <T> void save(T entity) throws ORMException {
        //参数列表集合--即表字段/类属性
        List<Object> params = new ArrayList<>();
        //拼接sql语句
        StringBuffer sql = new StringBuffer();
        //利用反射获取类信息++++++++++++++++++++++++++
        Class<?> aClass = entity.getClass();
        //获取类名--对应为表名
        String table = aClass.getSimpleName();
        //拼接sql
        sql.append("INSERT INTO ").append(table).append("(");
        //获取类中属性名称
        Field[] declaredFields = aClass.getDeclaredFields();
        if (null != declaredFields && declaredFields.length > 0) {
            for (int i = 0; i < declaredFields.length; i++) {
                Field declaredField = declaredFields[i];
                String columnName = declaredField.getName();
                //通过反射获取当前字段对应的值
                //设置访问权限
                declaredField.setAccessible(true);
                //反射获取当前字段的值
                try {
                    Object fieldValue = declaredField.get(entity);
                    //判断该字段是否有值
                    if (null != fieldValue) {
                        //拼接字段部分
                        sql.append(columnName).append(",");
                        //保存参数列表信息
                        params.add(fieldValue);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //处理最后一个逗号--,并加上反括号
            sql.deleteCharAt(sql.length() - 1).append(")").
                    append(" VALUES (");
            //拼接占位符
            for (int j = 0; j < params.size(); j++) {
                sql.append("?").append(",");
            }
            //处理最后一个逗号
            sql.deleteCharAt(sql.length() - 1).append(")");
            System.out.println("SQL：" + sql);
//                System.out.println("value："+ Arrays.toString(params.toArray()));
            System.out.println("value：" + params);
        }
        try {
            JDBCUtils.executeUpdate(sql.toString(), params.toArray());
        } catch (Exception e) {
            throw new ORMException("数据库底层操作出现异常:" + e.getMessage());
        }

    }
}
