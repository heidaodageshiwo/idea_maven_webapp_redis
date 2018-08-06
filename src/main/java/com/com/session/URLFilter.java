package com.com.session;


import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class URLFilter
        implements Filter
{
    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        int port = request.getLocalPort();
        String url = request.getRequestURL().toString();

        System.out.format("此时访问的是端口号是%d的tomcat的资源:%s%n", new Object[] { Integer.valueOf(port), url });

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();

        //将数据存储到session中
        session.setAttribute("data", "阿强");
        //获取session的Id
        String sessionId = session.getId();
        //判断session是不是新创建的
        if (session.isNew()) {
            response.getWriter().print("session创建成功，session的id是："+sessionId);
        }else {
            response.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
        }

        System.out.println("java中获取存放在session中的数据:"+request.getSession().getAttribute("data"));

        //Jedis jedis = new Jedis("localhost");

        //System.out.println("redis中获取存放在session中的数据:"+jedis.get(session.getId().toString()));
        chain.doFilter(request, response);
    }

    public void init(FilterConfig arg0)
            throws ServletException
    {}
}
