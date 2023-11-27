package com.demo.utils;

import java.util.UUID;

/**
 * 生成ID工具
 * @author Hullson
 * @since 2023-06-17
 */
public class GenerateID {

    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
