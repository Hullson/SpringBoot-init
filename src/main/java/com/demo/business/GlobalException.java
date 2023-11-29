package com.demo.business;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.AccessDeniedException;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-11-29
 * @Description : 全局异常处理
 */

@ControllerAdvice
public class GlobalException {

    private static Logger logger = LoggerFactory.getLogger(GlobalException.class);

    /**
     * 处理 Exceptin 不可知异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R exceptionHandler(HttpServletResponse response, Exception ex) {
        logger.error(" -- Exception -- \t\t" + ex);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        String msg = ex.getMessage();
        if (StringUtils.isEmpty(msg)) {
            msg = ex.getClass().getSimpleName();
        }
        return ResultUtils.error(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, msg);
    }

    /**
     * 处理 AccessDeniedException 用户未授权异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public R exceptionHandler(HttpServletResponse response, AccessDeniedException ex) {
        logger.error(" -- AccessDeniedException -- \t\t" + ex);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        String msg = ex.getMessage();
        if (StringUtils.isEmpty(msg)) {
            msg = "Forbidden";
        }
        return ResultUtils.error(HttpServletResponse.SC_FORBIDDEN, msg);
    }

    /**
     * 处理 AuthenticationException 用户验证失败异常
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public R exceptionHandler(HttpServletResponse response, AuthenticationException ex) {
        logger.error(" -- AuthenticationException -- \t\t" + ex);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        String msg = ex.getMessage();
        if (StringUtils.isEmpty(msg)) {
            msg = "Unauthorized";
        }
        return ResultUtils.error(HttpServletResponse.SC_UNAUTHORIZED, msg);
    }

    /**
     * 处理自定义业务异常
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public R businessExceptionHandler(BusinessException ex) {
        logger.error(" -- BusinessException -- \t\t" + ex);
        return ResultUtils.error(ex.getCode(), ex.getMessage());
    }

}
