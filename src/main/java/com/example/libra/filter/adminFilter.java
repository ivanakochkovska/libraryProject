package com.example.libra.filter;



import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component

public class adminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig){

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;

        String name=(String) httpServletRequest.getSession().getAttribute("admin");
        String path=httpServletRequest.getServletPath();
        if("/update".equals(path) &&(name==null||name.isEmpty())){
            httpServletResponse.sendRedirect("/admin");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy(){

    }
}