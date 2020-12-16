package com.example.springboot.config.Shiro.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Slf4j
@Component
@Order(0)
public class MyWebFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig){
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        //if(StringUtils.isNotBlank(req.getHeader("Referer")) && req.getHeader("Referer").contains(".dorago.cn")) {
            res.setHeader("Access-Control-Allow-Origin", "*");
            res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            res.setHeader("Access-Control-Max-Age", "-1");
            res.setHeader("Access-Control-Allow-Headers", "x-requested-with,"/*+ MySessionManager.AUTHORIZATION*/);
        //}
        if("OPTIONS".equalsIgnoreCase(req.getMethod())){
            res.setStatus(204);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
