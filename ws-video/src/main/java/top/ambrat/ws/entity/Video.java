package top.ambrat.ws.entity;

import java.util.Date;

public class Video {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column video.id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column video.name
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column video.url
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column video.upload_time
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private Date uploadTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column video.works_id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private Integer worksId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column video.status
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column video.id
     *
     * @return the value of video.id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column video.id
     *
     * @param id the value for video.id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column video.name
     *
     * @return the value of video.name
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column video.name
     *
     * @param name the value for video.name
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column video.url
     *
     * @return the value of video.url
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column video.url
     *
     * @param url the value for video.url
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column video.upload_time
     *
     * @return the value of video.upload_time
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column video.upload_time
     *
     * @param uploadTime the value for video.upload_time
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column video.works_id
     *
     * @return the value of video.works_id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public Integer getWorksId() {
        return worksId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column video.works_id
     *
     * @param worksId the value for video.works_id
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setWorksId(Integer worksId) {
        this.worksId = worksId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column video.status
     *
     * @return the value of video.status
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column video.status
     *
     * @param status the value for video.status
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}