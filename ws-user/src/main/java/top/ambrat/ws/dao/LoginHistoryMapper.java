package top.ambrat.ws.dao;

import top.ambrat.ws.entity.LoginHistory;

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

public interface LoginHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    @Delete({
        "delete from login_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    @Insert({
        "insert into login_history (id, user_id, ",
        "login_time, city, ",
        "ip)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{loginTime,jdbcType=TIMESTAMP}, #{city,jdbcType=VARCHAR}, ",
        "#{ip,jdbcType=VARCHAR})"
    })
    int insert(LoginHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    @InsertProvider(type=LoginHistorySqlProvider.class, method="insertSelective")
    int insertSelective(LoginHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    @Select({
        "select",
        "id, user_id, login_time, city, ip",
        "from login_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="login_time", property="loginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR)
    })
    LoginHistory selectByPrimaryKey(Integer id);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    @Select({
    	"select",
    	"id, user_id, login_time, city, ip",
    	"from login_history",
    	"where user_id = #{user_id,jdbcType=INTEGER}",
    	"order by login_time desc"
    })
    @Results({
    	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
    	@Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
    	@Result(column="login_time", property="loginTime", jdbcType=JdbcType.TIMESTAMP),
    	@Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
    	@Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR)
    })
    List<LoginHistory> selectByUserId(Integer user_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    @UpdateProvider(type=LoginHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoginHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Dec 10 14:39:59 CST 2018
     */
    @Update({
        "update login_history",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "login_time = #{loginTime,jdbcType=TIMESTAMP},",
          "city = #{city,jdbcType=VARCHAR},",
          "ip = #{ip,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(LoginHistory record);
}