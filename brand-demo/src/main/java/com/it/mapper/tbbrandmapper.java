package com.it.mapper;

import com.it.pojo.Brand;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface tb_brandmapper {

    @Select("select * from tb_brand")
    @ResultMap("tb_brandResultMap")
     List<Brand> selectAll();
}
