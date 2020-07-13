package com.codermy.myspringsecurity.security.auth;

import com.alibaba.fastjson.JSONObject;
import com.codermy.myspringsecurity.enums.ResponseCode;
import com.codermy.myspringsecurity.utils.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RestAuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
//        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("utf-8");
//        response.sendRedirect("/403.html");
//        response.getWriter().println("您无权限");


        //输出对象
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResponseCode.FORBIDDEN);
        r.setMsg("您无操作权限!!!");
        String responseJson = JSONObject.toJSONString(r);
        //输出error消息
        writer.write(responseJson);
        writer.close();
    }

}
