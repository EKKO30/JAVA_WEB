package com.itlogin.web;

import com.itlogin.mapper.UserMapper;
import com.itlogin.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

//注册
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取输入数据
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        //封装注册对象
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(username);
        System.out.println(password);

        //2.使用mybatis调用sql
        //2.1获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.2创建SqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //2.3获取Mapper对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        //2.4使用sql语句
        //查询用户名
        User user1= mapper.sbyusername(username);

        //3.查看有无相同用户名
        if(user1==null){//没有相同用户名
            mapper.add(user);
            //除了查，增删改都要提交事务
            sqlSession.commit();
            sqlSession.close();
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter printWriter= resp.getWriter();
            printWriter.write("注册成功");

        }else {//有相同用户名
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter printWriter= resp.getWriter();
            printWriter.write("用户名已存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
