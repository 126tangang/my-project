package exercise.demo3.bean;

/**
 * Customer为实体对象,用来封装客户信息。
 */
public class Customer {
    private String name;/* 客户姓名 */
    private char gender;/* 性别 */
    private int age;/* 年龄 */
    private String phone;/* 电话号码 */
    private String email;/* 电子邮箱 */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer() {

    }

    /**
     * 通过构造器输入客户个人信息
     * @param name  姓名
     * @param gender 性别
     * @param age   年龄
     * @param phone 电话号码
     * @param email 电子邮件
     */
    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }
}
