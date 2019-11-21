package pers.li.orm.jdbc.utils;

import pers.li.orm.utils.PropertiesUtils;

import java.sql.*;

/**
 * create by lishengbo 2018/6/11
 *
 * mysql数据库操作工具类
 */
public final class JDBCUtils {

        static {
            initPool();
        }

        //连接池连接信息
        private static String driverClassName;
        private static String url;
        private static String userName;
        private static String passWord;

        //初始化连接--
        public static void initPool() {
            driverClassName = PropertiesUtils.getStaticProperty("jdbc.driver.class");
            url = PropertiesUtils.getStaticProperty("jdbc.url");
            userName = PropertiesUtils.getStaticProperty("jdbc.userName");
            passWord = PropertiesUtils.getStaticProperty("jdbc.passWord");
            //将驱动注册到对应的DriverManager中
            try {
                //使用以下驱动也可以注册
//            new com.mysql.jdbc.Driver();
                Driver driver=(Driver) Class.forName(driverClassName).newInstance();
                DriverManager.registerDriver(driver);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    /**
     * 通用的（DML:insert,update,delete）方法
     * @param sql
     * @param param
     * @return
     */
    public final static int executeUpdate(String sql,Object... param){
        int row=0;
        try (
                Connection connection=DriverManager.getConnection(url,userName,passWord);
                PreparedStatement ps=connection.prepareStatement(sql);
                ){
            System.out.println("参数个数:"+param.length);
            for (int i = 0; i <param.length ; i++) {
                ps.setObject(i+1,param[i]);
            }
            row= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return row;

    };
}
