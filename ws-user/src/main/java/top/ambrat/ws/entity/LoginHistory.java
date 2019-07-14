package top.ambrat.ws.entity;

import java.util.Date;

public class LoginHistory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login_history.id
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login_history.user_id
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login_history.login_time
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    private Date loginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login_history.city
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    private String city;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login_history.ip
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    private String ip;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login_history.id
     *
     * @return the value of login_history.id
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login_history.id
     *
     * @param id the value for login_history.id
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login_history.user_id
     *
     * @return the value of login_history.user_id
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login_history.user_id
     *
     * @param userId the value for login_history.user_id
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login_history.login_time
     *
     * @return the value of login_history.login_time
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login_history.login_time
     *
     * @param loginTime the value for login_history.login_time
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login_history.city
     *
     * @return the value of login_history.city
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login_history.city
     *
     * @param city the value for login_history.city
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login_history.ip
     *
     * @return the value of login_history.ip
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login_history.ip
     *
     * @param ip the value for login_history.ip
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}