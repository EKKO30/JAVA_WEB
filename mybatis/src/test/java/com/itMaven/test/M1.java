package com.itMaven.test;

import com.itmyb.mapper.BrandMapper;
import com.itmyb.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M1 {

    @Test
    public void testselectALl() throws IOException {

        int status=0;
        String companyName="%华为%";
        String brandName="%华%";

        Map map=new HashMap();
       // map.put("status",status);
        map.put("companyName",companyName);
      //  map.put("brandName",brandName);
        //1.获取SqlSessionFactor
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取Mapper代理
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> list=brandMapper.selectlike(map);

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testselectConditionSingle() throws IOException {

        int status=1;
        String companyName="%华为%";
        String brandName="%华%";

        Brand brand=new Brand();
     //   brand.setBrandName(brandName);
      //  brand.setCompanyName(companyName);
     //   brand.setStatus(status);
        //1.获取SqlSessionFactor
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取Mapper代理
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> list=brandMapper.selectConditionSingle(brand);

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testadd() throws IOException {

        int status=2;
        String companyName="美团技术有限公司";
        String brandName="美团";
        int ordered=100;
        String description="美团.description";

        Brand brand=new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        //1.获取SqlSessionFactor
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取Mapper代理
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand);

        Integer x=brand.getId();
        System.out.println(x);

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testupdate() throws IOException {

        int status=1;
        String companyName="美团技术有限公司";
        String brandName="美团";
        int ordered=20;
        String description="美团.descriptiones";
        int id=5;

        Brand brand=new Brand();
        brand.setBrandName(brandName);
      //  brand.setCompanyName(companyName);
    //    brand.setStatus(status);
      //  brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        //1.获取SqlSessionFactor
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取Mapper代理
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.updateALl(brand);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testdeletemore() throws IOException {

        int[] ids={5,7};

        //1.获取SqlSessionFactor
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取Mapper代理
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deletemore(ids);

        sqlSession.commit();

        sqlSession.close();
    }


    @Test
    public void testdeleteone() throws IOException {

        int id=6;

        //1.获取SqlSessionFactor
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取Mapper代理
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteone(id);

        sqlSession.commit();

        sqlSession.close();
    }
}
