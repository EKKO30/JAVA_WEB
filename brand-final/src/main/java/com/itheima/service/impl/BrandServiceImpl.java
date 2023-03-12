package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    //查询所有
    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession= factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        List<Brand> l1=mapper.selectALL();
        sqlSession.close();
        return l1;
    }

    //添加
    @Override
    public void add(Brand brand) {
        SqlSession sqlSession= factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    //批量删除
    @Override
    public void deleteByIds1(int[] ids) {
        SqlSession sqlSession= factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds1(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    //分页查询
    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession= factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //计算当前页
        int begin=(currentPage-1)*pageSize;
        int size=pageSize;

        //获取当前页数据
        List<Brand> rows= mapper.selectByPage(begin,size);
        //总数据数量
        int totalcount= mapper.selecttotal();

        PageBean<Brand> brandPageBean=new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalcount);

        sqlSession.close();

        return brandPageBean;
    }

    //分页动态查询
    @Override
    public PageBean<Brand> selectByPageAndCondition1(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession= factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //计算当前页
        int begin=(currentPage-1)*pageSize;
        int size=pageSize;

        //因为模糊查询所以要拼%%
        String a=brand.getBrandName();
        if(a!=null && a.length()>0){
            a="%"+a+"%";
            brand.setBrandName(a);
        }

        String b=brand.getCompanyName();
        if(b!=null && b.length()>0){
            b="%"+b+"%";
            brand.setCompanyName(b);
        }


        //获取当前页数据
        List<Brand> rows= mapper.selectByPageAndCondition1(currentPage, pageSize, brand);
        //总数据数量
        int totalcount= mapper.selecttotalAndCondition(brand);

        PageBean<Brand> brandPageBean=new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalcount);

        sqlSession.close();

        return brandPageBean;
    }

    @Override
    public void deleteone(int id) {
        SqlSession sqlSession= factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        mapper.deleteone(id);
        sqlSession.commit();
        sqlSession.close();
    }


}
