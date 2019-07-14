package top.ambrat.ws.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import top.ambrat.ws.entity.Evaluate;

public interface EvaluateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Delete({
        "delete from evaluate",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Insert({
        "insert into evaluate (id, use_id, ",
        "context, publish_time, ",
        "works_id, like_count, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{useId,jdbcType=INTEGER}, ",
        "#{context,jdbcType=VARCHAR}, #{publishTime,jdbcType=TIMESTAMP}, ",
        "#{worksId,jdbcType=INTEGER}, #{likeCount,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(Evaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @InsertProvider(type=EvaluateSqlProvider.class, method="insertSelective")
    int insertSelective(Evaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "id, use_id, context, publish_time, works_id, like_count, status",
        "from evaluate",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="use_id", property="useId", jdbcType=JdbcType.INTEGER),
        @Result(column="context", property="context", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="works_id", property="worksId", jdbcType=JdbcType.INTEGER),
        @Result(column="like_count", property="likeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Evaluate selectByPrimaryKey(Integer id);
    
    
    /**
     * 根据作品id查询查询评论
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "id, use_id, context, publish_time, works_id, like_count, status",
        "from evaluate",
        "where works_id = #{works_id,jdbcType=INTEGER}",
        "order by publish_time desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="use_id", property="useId", jdbcType=JdbcType.INTEGER),
        @Result(column="context", property="context", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="works_id", property="worksId", jdbcType=JdbcType.INTEGER),
        @Result(column="like_count", property="likeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<Evaluate> selectByWorksId(Integer works_id);
    
    
    /**
     * 根据作品id查询查询点赞高的评论
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "id, use_id, context, publish_time, works_id, like_count, status",
        "from evaluate",
        "works_id = #{works_id,jdbcType=INTEGER}",
        "order by like_count desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="use_id", property="useId", jdbcType=JdbcType.INTEGER),
        @Result(column="context", property="context", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="works_id", property="worksId", jdbcType=JdbcType.INTEGER),
        @Result(column="like_count", property="likeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<Evaluate> selectByWorksIdOrderByLikeCount(Integer works_id);
    
    
    /**
     * 根据作品id查询查询评论
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "id, use_id, context, publish_time, works_id, like_count, status",
        "from evaluate",
        "user_id = #{user_id,jdbcType=INTEGER}",
        "order by publish_time desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="use_id", property="useId", jdbcType=JdbcType.INTEGER),
        @Result(column="context", property="context", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="works_id", property="worksId", jdbcType=JdbcType.INTEGER),
        @Result(column="like_count", property="likeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<Evaluate> selectByUserId(Integer user_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @UpdateProvider(type=EvaluateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Evaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update evaluate",
        "set use_id = #{useId,jdbcType=INTEGER},",
          "context = #{context,jdbcType=VARCHAR},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "works_id = #{worksId,jdbcType=INTEGER},",
          "like_count = #{likeCount,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Evaluate record);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update evaluate",
        "set status = 0",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateStatusTo0ById(Integer id);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update evaluate",
        "set status = 1",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateStatusTo1ById(Integer id);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update evaluate",
        "set status = 0",
        "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    int updateStatusTo0ByUserId(Integer user_id);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update evaluate",
        "set status = 1",
        "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    int updateStatusTo1ByUserId(Integer user_id);
    
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update evaluate",
        "set status = 0",
        "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    int updateStatusTo0ByWorksId(Integer works_id);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update evaluate",
        "set status = 1",
        "where works_id = #{works_id,jdbcType=INTEGER}"
    })
    int updateStatusTo1ByWorksId(Integer works_id);
    
    
    
    
}