package com.itlogin.Service;

import com.itlogin.mapper.UserMapper;
import com.itlogin.pojo.User;
import com.itlogin.util.SqlSessionFactroyUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.PrintWriter;

public class Service123 {

    private SqlSessionFactory sqlSessionFactory= SqlSessionFactroyUtil.getSqlSessionFactory();

    public User select(String username,String password){
        SqlSessionFactory sqlSessionFactory= SqlSessionFactroyUtil.getSqlSessionFactory();
        //2.2创建SqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //2.3获取Mapper对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        //2.4使用sql语句
        User user1= mapper.select(username,password);
        //2.5释放资源
        sqlSession.close();

        return user1;
    }

    public User sbyusername(String username){
        SqlSessionFactory sqlSessionFactory= SqlSessionFactroyUtil.getSqlSessionFactory();
        //2.2创建SqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //2.3获取Mapper对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        //2.4使用sql语句
        //查询用户名
        User user1= mapper.sbyusername(username);

        sqlSession.close();
        return user1;
    }

    public void add(User user){
        SqlSessionFactory sqlSessionFactory= SqlSessionFactroyUtil.getSqlSessionFactory();
        //2.2创建SqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //2.3获取Mapper对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        //2.4使用sql语句
        mapper.add(user);
        //除了查，增删改都要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

}
