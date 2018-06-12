package pers.li.orm.dao.impl;

import pers.li.orm.dao.UserDao;
import pers.li.orm.exception.ORMException;
import pers.li.orm.orm.ORMTemplate;
import pers.li.orm.pojo.UserInfo;

/**
 * create by lishengbo 2018/6/11
 */
public class UserDaoImpl implements UserDao {

    //自定义模板信息注入
    private ORMTemplate ormTemplate;

    public void setOrmTemplate(ORMTemplate ormTemplate) {
        this.ormTemplate = ormTemplate;
    }

    @Override
    public void addUser(UserInfo userInfo) throws ORMException {
        ormTemplate.saveReal(userInfo);
    }
}
