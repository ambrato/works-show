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
import top.ambrat.ws.entity.Works;

public interface WorksMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Delete({
        "delete from works",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Insert({
        "insert into works (id, name, ",
        "intro, view_count, ",
        "image, publish_time, ",
        "user_id, type_id, ",
        "work_time, status)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{intro,jdbcType=VARCHAR}, #{viewCount,jdbcType=INTEGER}, ",
        "#{image,jdbcType=VARCHAR}, #{publishTime,jdbcType=TIMESTAMP}, ",
        "#{userId,jdbcType=INTEGER}, #{typeId,jdbcType=INTEGER}, ",
        "#{workTime,jdbcType=INTEGER}, #{status,jdbcType=INTEGER})"
    })
    int insert(Works record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @InsertProvider(type=WorksSqlProvider.class, method="insertSelective")
    int insertSelective(Works record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "id, name, intro, view_count, image, publish_time, user_id, type_id, work_time, ",
        "status",
        "from works",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="view_count", property="viewCount", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="work_time", property="workTime", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Works selectByPrimaryKey(Integer id);
    
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "id, name, intro, view_count, image, publish_time, user_id, type_id, work_time, ",
        "status",
        "from works",
        "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="view_count", property="viewCount", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="work_time", property="workTime", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<Works> selectByUserId(Integer user_id);
    
    
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "id, name, intro, view_count, image, publish_time, user_id, type_id, work_time, ",
        "status",
        "from works",
        "where type_id = #{type_id,jdbcType=INTEGER}",
        "order by ${orderWhat} ${orderType}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="view_count", property="viewCount", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="work_time", property="workTime", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<Works> selectByLimit(@Param("type_id")Integer type_id, @Param("orderWhat")String orderWhat, @Param("orderType")String orderType);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "id, name, intro, view_count, image, publish_time, user_id, type_id, work_time, ",
        "status",
        "from works",
        "order by ${orderWhat} ${orderType}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="view_count", property="viewCount", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="work_time", property="workTime", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<Works> selectByLimit2(@Param("orderWhat")String orderWhat, @Param("orderType")String orderType);
    
    
    
    /**
     * 按关键词查询作品
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Select({
        "select",
        "id, name, intro, view_count, image, publish_time, user_id, type_id, work_time, ",
        "status",
        "from works",
        "where name like #{keyword,jdbcType=VARCHAR}",
    	"or intro like #{keyword,jdbcType=VARCHAR}",
    	"order by view_count desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="view_count", property="viewCount", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="work_time", property="workTime", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<Works> selectByKeyword(@Param("keyword")String keyword);
    
    
    
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @UpdateProvider(type=WorksSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Works record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update works",
        "set name = #{name,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "view_count = #{viewCount,jdbcType=INTEGER},",
          "image = #{image,jdbcType=VARCHAR},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "type_id = #{typeId,jdbcType=INTEGER},",
          "work_time = #{workTime,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Works record);
    
    
    /**
     * 将制定id的作品的状态为改为0 表示这个作品不允许展示 即删除
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update works",
        "set status = 0",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateStatusTo0ByPrimaryKey(Integer id);
    
    /**
     * 将制定id的作品的状态为改为0 表示这个作品不允许展示 即删除
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    @Update({
        "update works",
        "set status = 1",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateStatusTo1ByPrimaryKey(Integer id);
}