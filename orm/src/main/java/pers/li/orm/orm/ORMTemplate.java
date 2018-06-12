package pers.li.orm.orm;

import pers.li.orm.exception.ORMException;

/**
 * create by lishengbo 2018/6/11
 * 抽象模板定义:要区分mysql，oracle等
 * 利用模板模式進行事物控制-回滾-事物傳播性
 */
public abstract class ORMTemplate {

    /**
     * 开启事物--
     */
    private void start(){
        System.out.println("开启事物---->");
    }

    /**
     * 提交事物--
     */
    private void commit(){
        System.out.println("提交事物---->");
    }


    protected abstract <T> void save(T entity) throws ORMException;

    /**
     * 定义模板方法
     * @param entity
     * @param <T>
     * @throws ORMException
     */
    public  <T> void saveReal(T entity) throws ORMException{
        start();
        save(entity);
        commit();
    };


}
