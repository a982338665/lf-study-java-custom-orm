package pers.li.orm.dao;

import pers.li.orm.exception.ORMException;
import pers.li.orm.pojo.UserInfo;

public interface UserDao {

    void addUser(UserInfo userInfo) throws ORMException;
}
