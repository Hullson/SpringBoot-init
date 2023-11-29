package com.demo.business;

import lombok.Data;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-11-29
 * @Description : 自定义业务异常类
 */

@Data
public class BusinessException extends RuntimeException {

    private Integer code = 0;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
