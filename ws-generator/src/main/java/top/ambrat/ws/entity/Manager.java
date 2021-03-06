package top.ambrat.ws.entity;

import java.util.Date;

public class Manager {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.Id
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.username
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.password
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.email
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.phone
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.realname
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    private String realname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.last_login_time
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    private Date lastLoginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.regist_time
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    private Date registTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.salt
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    private String salt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.sex
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.status
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.Id
     *
     * @return the value of manager.Id
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.Id
     *
     * @param id the value for manager.Id
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.username
     *
     * @return the value of manager.username
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.username
     *
     * @param username the value for manager.username
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.password
     *
     * @return the value of manager.password
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.password
     *
     * @param password the value for manager.password
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.email
     *
     * @return the value of manager.email
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.email
     *
     * @param email the value for manager.email
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.phone
     *
     * @return the value of manager.phone
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.phone
     *
     * @param phone the value for manager.phone
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.realname
     *
     * @return the value of manager.realname
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.realname
     *
     * @param realname the value for manager.realname
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.last_login_time
     *
     * @return the value of manager.last_login_time
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.last_login_time
     *
     * @param lastLoginTime the value for manager.last_login_time
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.regist_time
     *
     * @return the value of manager.regist_time
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public Date getRegistTime() {
        return registTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.regist_time
     *
     * @param registTime the value for manager.regist_time
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.salt
     *
     * @return the value of manager.salt
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.salt
     *
     * @param salt the value for manager.salt
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.sex
     *
     * @return the value of manager.sex
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.sex
     *
     * @param sex the value for manager.sex
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.status
     *
     * @return the value of manager.status
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.status
     *
     * @param status the value for manager.status
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}