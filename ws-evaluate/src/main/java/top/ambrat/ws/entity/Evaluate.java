package top.ambrat.ws.entity;

import java.util.Date;

public class Evaluate {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.id
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.use_id
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    private Integer useId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.context
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    private String context;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.publish_time
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    private Date publishTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.works_id
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    private Integer worksId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.like_count
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.status
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.id
     *
     * @return the value of evaluate.id
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.id
     *
     * @param id the value for evaluate.id
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.use_id
     *
     * @return the value of evaluate.use_id
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public Integer getUseId() {
        return useId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.use_id
     *
     * @param useId the value for evaluate.use_id
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.context
     *
     * @return the value of evaluate.context
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public String getContext() {
        return context;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.context
     *
     * @param context the value for evaluate.context
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.publish_time
     *
     * @return the value of evaluate.publish_time
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.publish_time
     *
     * @param publishTime the value for evaluate.publish_time
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.works_id
     *
     * @return the value of evaluate.works_id
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public Integer getWorksId() {
        return worksId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.works_id
     *
     * @param worksId the value for evaluate.works_id
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public void setWorksId(Integer worksId) {
        this.worksId = worksId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.like_count
     *
     * @return the value of evaluate.like_count
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.like_count
     *
     * @param likeCount the value for evaluate.like_count
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.status
     *
     * @return the value of evaluate.status
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.status
     *
     * @param status the value for evaluate.status
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}