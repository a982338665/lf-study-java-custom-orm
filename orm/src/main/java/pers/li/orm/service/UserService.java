package pers.li.orm.service;

import pers.li.orm.exception.ORMException;
import pers.li.orm.pojo.UserInfo;

/**
 * create by lishengbo 2018/6/11
 */
public interface UserService {

    void save(UserInfo userInfo) throws ORMException;
}
