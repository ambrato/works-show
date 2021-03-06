package top.ambrat.ws.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import top.ambrat.ws.entity.CollectWorks;

public interface CollectWorksMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Delete({
        "delete from collect_works",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Insert({
        "insert into collect_works (Id, user_id, ",
        "works_id, collect_time, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{worksId,jdbcType=INTEGER}, #{collectTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(CollectWorks record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @InsertProvider(type=CollectWorksSqlProvider.class, method="insertSelective")
    int insertSelective(CollectWorks record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "Id, user_id, works_id, collect_time, status",
        "from collect_works",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="works_id", property="worksId", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collectTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    CollectWorks selectByPrimaryKey(Integer id);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "Id, user_id, works_id, collect_time, status",
        "from collect_works",
        "where works_id = #{works_id,jdbcType=INTEGER}",
        "and user_id = #{user_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="works_id", property="worksId", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collectTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    CollectWorks selectByWU(@Param("works_id")Integer works_id,@Param("user_id")Integer user_id);
    
    
    /**
     * 按用户id查询收藏记录
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "Id, user_id, works_id, collect_time, status",
        "from collect_works",
        "where user_id = #{user_id,jdbcType=INTEGER}",
        "order by collect_time desc"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="works_id", property="worksId", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collectTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<CollectWorks> selectByUserId(Integer user_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @UpdateProvider(type=CollectWorksSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CollectWorks record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update collect_works",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "works_id = #{worksId,jdbcType=INTEGER},",
          "collect_time = #{collectTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CollectWorks record);
    
    /**
     * 删除收藏记录
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update collect_works",
        "set status = 0}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateStatusTo0ByPrimaryKey(Integer id);
}