package top.ambrat.ws.dao;

import org.apache.ibatis.jdbc.SQL;
import top.ambrat.ws.entity.Type;

public class TypeSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public String insertSelective(Type record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("type");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbg.generated Thu May 02 12:52:45 CST 2019
     */
    public String updateByPrimaryKeySelective(Type record) {
        SQL sql = new SQL();
        sql.UPDATE("type");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}