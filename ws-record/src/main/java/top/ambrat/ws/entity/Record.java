package top.ambrat.ws.entity;

import java.util.Date;

public class Record {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column record.id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column record.name
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column record.context
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private String context;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column record.publish_time
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private Date publishTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column record.works_id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private Integer worksId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column record.status
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column record.id
     *
     * @return the value of record.id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column record.id
     *
     * @param id the value for record.id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column record.name
     *
     * @return the value of record.name
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column record.name
     *
     * @param name the value for record.name
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column record.context
     *
     * @return the value of record.context
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public String getContext() {
        return context;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column record.context
     *
     * @param context the value for record.context
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column record.publish_time
     *
     * @return the value of record.publish_time
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column record.publish_time
     *
     * @param publishTime the value for record.publish_time
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column record.works_id
     *
     * @return the value of record.works_id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public Integer getWorksId() {
        return worksId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column record.works_id
     *
     * @param worksId the value for record.works_id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setWorksId(Integer worksId) {
        this.worksId = worksId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column record.status
     *
     * @return the value of record.status
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column record.status
     *
     * @param status the value for record.status
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}