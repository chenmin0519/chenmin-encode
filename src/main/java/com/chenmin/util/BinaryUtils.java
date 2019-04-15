package com.chenmin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * creat time 2019-04-15
 * jdk version 1.8
 * 进制转化加密工具
 */
public class BinaryUtils {

    private static Logger logger = LoggerFactory.getLogger(BinaryUtils.class);

    private static final char[] array = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g','h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '8', '5', '2', '7', '3', '6', '4', '0', '9', '1', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', '+', '-','%','!','#','=','$'};

    /**
     * 自定义对10进制数转换编码
     * @param number
     * @return
     */
    public static String encode64(double number) {
        logger.info("进入自定义对10进制数加密-encode64()");
        double rest = number;
        // 创建栈
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder(0);
        while (rest >= 1) {
            // 进栈,
            // 也可以使用(rest - (rest / 64) * 64)作为求余算法
            stack.add(array[new Double(rest % 69).intValue()]);
            rest = rest / 69;
        }
        for (; !stack.isEmpty();) {
            // 出栈
            result.append(stack.pop());
        }
        logger.info("对10进制数加密完成-encode64()");
        return result.toString();
    }


    /**
     * 自定义编码解密
     * @param str
     * @return
     */
    public static Double decode64(String str) {
        logger.info("进入自定义解密10进制数-decode64()");
        // 倍数
        int multiple = 1;
        double result = 0;
        Character c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(str.length() - i - 1);
            result += decodeChar(c) * multiple;
            multiple = multiple * 69;
        }
        logger.info("自定义解密10进制数完成-decode64()");
        return result;
    }

    private static int decodeChar(Character c) {
        for (int i = 0; i < array.length; i++) {
            if (c == array[i]) {
                return i;
            }
        }
        return -1;
    }
}
