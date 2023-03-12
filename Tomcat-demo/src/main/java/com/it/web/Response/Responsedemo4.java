package com.it.web.Response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/resp4")
public class Responsedemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取文件
        FileInputStream fileInputStream=new FileInputStream("F://a.jpg");
        //获取字节输入流
        ServletOutputStream Sl= resp.getOutputStream();
        //copy方式一
//        byte[] bt=new byte[1024];
//        int len=0;
//        while ((len=fileInputStream.read(bt))!=-1){
//            Sl.write(bt,0,len);
//        }
        //copy方式二
        IOUtils.copy(fileInputStream,Sl);

        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
