package pers.li.orm.pojo;

/**
 * create by lishengbo 2018/6/11
 * 用户信息实体类:
 * 使用自定義orm時候，請勿使用基本数据类型
 */
public class UserInfo {

    private Integer id;
    private String name;
    private String userName;
    private String passWord;
    private Integer sex;
    private Integer age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
