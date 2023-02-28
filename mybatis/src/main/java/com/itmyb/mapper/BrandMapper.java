package com.itmyb.mapper;

import com.itmyb.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface BrandMapper {

    //查询所有
    List<Brand> selectAll();

    //查看详情
    Brand selectbyid(int id);

    //多条件查询
    //@Param()是识别""字符串，并传入该参数
//    List<Brand> selectlike(
//            @Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);

    //多条件查询
    List<Brand>  selectlike(Map map);

    //单条件动态查询
    List<Brand> selectConditionSingle(Brand brand);

    //添加
    void add(Brand brand);

    //修改
    void updateALl(Brand brand);

    //删除单个
    void deleteone(int id);

    //删除多个
    void deletemore(@Param("ids") int[] ids);
}
