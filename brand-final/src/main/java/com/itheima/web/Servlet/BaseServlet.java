package com.itheima.web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {

    // 获得请求最后一个路径来分发任务
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取路径
        String uri=req.getRequestURI();//brand-final/SelectAllServlet
 //       System.out.println(uri);
        //获取最后一段方法名
        int index=uri.lastIndexOf("/");//获得最后一个斜杠的位置
        String methodname=uri.substring(index+1);//获得SelectAllServlet
 //       System.out.println(methodname);

        //System.out.println(this);
        //通过反射来获得this的类
        Class<?> cls=this.getClass();
        //此处this指的时BrandServlet，因为此处是BrandServlet子类来调用的父类的这个方法

        //这里用反射，通过子类来获得子类的方法
        try {
            //类.class是获得这个类的字节码文件,这里会得到interface HttpServletRequest
            Method method = cls.getMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            //2.3 执行方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

//        Class<? extends BaseServlet> cls = this.getClass();
//        //2.2 获取方法 Method对象
//        try {
//            Method method = cls.getMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);
//            //2.3 执行方法
//            method.invoke(this,req,resp);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

    }
}
