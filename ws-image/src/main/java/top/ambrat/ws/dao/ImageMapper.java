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


import top.ambrat.ws.entity.Image;

public interface ImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    @Delete({
        "delete from image",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    @Insert({
        "insert into image (id, name, ",
        "url, upload_time, ",
        "works_id, status)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{uploadTime,jdbcType=TIMESTAMP}, ",
        "#{worksId,jdbcType=INTEGER}, #{status,jdbcType=INTEGER})"
    })
    int insert(Image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    @InsertProvider(type=ImageSqlProvider.class, method="insertSelective")
    int insertSelective(Image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    @Select({
        "select",
        "id, name, url, upload_time, works_id, status",
        "from image",
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
    Image selectByPrimaryKey(Integer id);
    
    
    /**
     * ����Ʒid��ѯ��Ƶ
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    @Select({
        "select",
        "id, name, url, upload_time, works_id, status",
        "from image",
        "where works_id = #{works_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="upload_time", property="uploadTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="works_id", property="worksId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<Image> selectByWorksId(Integer works_id);
    
    
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    @UpdateProvider(type=ImageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    @Update({
        "update image",
        "set name = #{name,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "upload_time = #{uploadTime,jdbcType=TIMESTAMP},",
          "works_id = #{worksId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Image record);
    
    /**
     * ��ͼƬ��״̬��Ϊ0 ��ʾ����Ƭ�����ü�ɾ��
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    @Update({
        "update image",
        "set status = 0",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateStatusTo0ByPrimaryKey(Integer id);
    
    
    
    /**
     * ��ͼƬ��״̬��Ϊ1 ���ָ���ͼƬ��ʹ��
     *
     * @mbg.generated Sat May 04 11:47:40 CST 2019
     */
    @Update({
        "update image",
        "set status = 1",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateStatusTo1ByPrimaryKey(Integer id);
}