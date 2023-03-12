package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    //查询所有
    @Select("select * from tb_brand ")
    @ResultMap("brandResultMap")
    List<Brand> selectALL();

    //添加数据
    @ResultMap("brandResultMap")
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    //批量删除数据
    void deleteByIds1(@Param("ids")int[] ids);

    //分页查询
    @ResultMap("brandResultMap")
    @Select("select * from tb_brand limit #{begin},#{size}")
    List<Brand> selectByPage(@Param("begin")int begin,@Param("size")int size);

    //总数据
    @Select("select count(*) from tb_brand")
    int selecttotal();

    //删除数据
    @Delete("delete from tb_brand where id=#{id}")
    void deleteone(@Param("id") int id);

    //分页动态查询
    List<Brand> selectByPageAndCondition1(@Param("begin")int begin,@Param("size")int size,@Param("brand")Brand brand);

    //分页动态查询总数
    int selecttotalAndCondition(Brand brand);

}
