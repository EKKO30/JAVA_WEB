package com.it.web.Request;

import com.it.web.MyHttpServlet;
import sun.nio.cs.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

@WebServlet("/req1")
public class Requestdemo1 extends MyHttpServlet {
    //get:getParameter是根据直接读取字符串来获取字符
    @Override
    protected void doGet(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        //GET逻辑
        //System.out.println("get======");

        //1. 获取所有参数的Map集合
        Map<String,String[]> map= req.getParameterMap();
        for (String key:map.keySet()
             ) {
            System.out.print(key+":");

            String[] values=map.get(key);
            for (String value:values
                 ) {
                if(key.equals("username")){
                    value=toChinese(value);
                }
                System.out.print(value+" ");
            }

            System.out.println();
        }
        System.out.println("----------------");

        //获得单个key的多个参数值
        String[] hobbies=req.getParameterValues("hobby");
        for (String hobb:hobbies
             ) {
            System.out.println(hobb);
        }
        System.out.println("---------------");

        //获得单个key的单个参数值
        String username=req.getParameter("username");
        username=toChinese(username);
        String password=req.getParameter("password");

        System.out.println(username);
        System.out.println(password);
    }

    //post:getReader()是根据流来获取字符
    @Override
    protected void doPost(ServletRequest req, ServletResponse resp) throws ServletException, IOException{
        //POST逻辑
        System.out.println("post=====");

        this.doGet(req, resp);
    }

    //解决中文乱码问题，其问题在于Tomcat在7之前用的是ISO-8859-1的编码解码方式
    public String toChinese(String s) throws UnsupportedEncodingException {
        //方式一
        s=new String(s.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(s);

        //方式二
        //将s用utf-8编码
        //String encode= URLEncoder.encode(s,"utf-8");
        //将encode用utf-8解码
        //s= URLDecoder.decode(encode,"utf-8");
        return s;
    }
}
