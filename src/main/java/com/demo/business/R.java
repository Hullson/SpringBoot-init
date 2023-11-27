package com.demo.business;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回结果实体
 * @author Hullson
 * @since  2023-06-17
 */
@Data
@NoArgsConstructor
public class R<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    public R(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public R(int code) {
        this(code, "", null);
    }

    public R(int code, String message) {
        this(code, message, null);
    }

    public R(int code, T data) {
        this(code, "", data);
    }
}
