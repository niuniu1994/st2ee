package com.efrei.st2ee.Inteceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-29 17:33
 **/

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("tutor");
        if (obj == null) {
            request.setAttribute("msg", "Authority needed, please login");
            request.getRequestDispatcher("/login").forward(request, response);
        } else {
            return true;
        }
        return false;
    }
}
