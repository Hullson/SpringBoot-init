package com.demo.business;

/**
 * 返回结果封装
 * @author Hullson
 * @since 2023-06-17
 */
public class ResultUtils {
    private final static String SUCCESS = "操作成功";
    private final static String FAIL = "操作失败";

    public static <T> R<T> success() {
        return new R<T>(200);
    }
    public static <T> R<T>success(T data) {
        return new R<T>(200, SUCCESS, data);
    }
    public static <T> R<T>success(String message,T data) {
        return new R<T>(200, message, data);
    }

    public static <T> R<T> error(int code, String message) {
        return new R<T>(code, message);
    }
    public static <T> R<T> error(int code, T data) {
        return new R<T>(code, data);
    }
    public static <T> R<T> error(int code,String message, T data) {
        return new R<T>(code, message, data);
    }

}
