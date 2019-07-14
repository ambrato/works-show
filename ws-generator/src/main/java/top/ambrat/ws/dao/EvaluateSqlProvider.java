package top.ambrat.ws.dao;

import org.apache.ibatis.jdbc.SQL;
import top.ambrat.ws.entity.Evaluate;

public class EvaluateSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public String insertSelective(Evaluate record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("evaluate");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUseId() != null) {
            sql.VALUES("use_id", "#{useId,jdbcType=INTEGER}");
        }
        
        if (record.getContext() != null) {
            sql.VALUES("context", "#{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            sql.VALUES("publish_time", "#{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getWorksId() != null) {
            sql.VALUES("works_id", "#{worksId,jdbcType=INTEGER}");
        }
        
        if (record.getLikeCount() != null) {
            sql.VALUES("like_count", "#{likeCount,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Sun May 05 10:54:15 CST 2019
     */
    public String updateByPrimaryKeySelective(Evaluate record) {
        SQL sql = new SQL();
        sql.UPDATE("evaluate");
        
        if (record.getUseId() != null) {
            sql.SET("use_id = #{useId,jdbcType=INTEGER}");
        }
        
        if (record.getContext() != null) {
            sql.SET("context = #{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            sql.SET("publish_time = #{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getWorksId() != null) {
            sql.SET("works_id = #{worksId,jdbcType=INTEGER}");
        }
        
        if (record.getLikeCount() != null) {
            sql.SET("like_count = #{likeCount,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}