package test;

import org.junit.Test;
import pers.li.orm.dao.UserDao;
import pers.li.orm.dao.impl.UserDaoImpl;
import pers.li.orm.jdbc.mysql.MysqlTemplate;
import pers.li.orm.jdbc.utils.JDBCUtils;
import pers.li.orm.pojo.UserInfo;
import pers.li.orm.service.impl.UserServiceImpl;

/**
 * create by lishengbo 2018/6/11
 */
public class test {

    @Test
    public void sdssf(){
        String sql="INSERT INTO `book`(name,price) VALUES ( ?, ?);";
        int i = JDBCUtils.executeUpdate(sql,"華爾德世界",88);
        System.out.println(i);
    }
    @Test
    public void sdssf2(){
        UserInfo userInfo=new UserInfo();
        userInfo.setName("lisehngbo");
        userInfo.setPassWord("12345t6");
        userInfo.setUserName("luofeng");
        UserDao userDao = new UserDaoImpl();
        ((UserDaoImpl)userDao).setOrmTemplate(new MysqlTemplate());
        userDao.addUser(userInfo);
    }
}
