package top.ambrat.ws.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import top.ambrat.ws.entity.Video;

public interface VideoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    @Delete({
        "delete from video",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    @Insert({
        "insert into video (id, name, ",
        "url, upload_time, ",
        "works_id, status)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{uploadTime,jdbcType=TIMESTAMP}, ",
        "#{worksId,jdbcType=INTEGER}, #{status,jdbcType=INTEGER})"
    })
    int insert(Video record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    @InsertProvider(type=VideoSqlProvider.class, method="insertSelective")
    int insertSelective(Video record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    @Select({
        "select",
        "id, name, url, upload_time, works_id, status",
        "from video",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="upload_time", property="uploadTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="works_id", property="worksId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Video selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    @UpdateProvider(type=VideoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Video record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    @Update({
        "update video",
        "set name = #{name,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "upload_time = #{uploadTime,jdbcType=TIMESTAMP},",
          "works_id = #{worksId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Video record);
}