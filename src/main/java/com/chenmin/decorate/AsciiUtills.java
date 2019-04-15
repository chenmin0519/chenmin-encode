package com.chenmin.decorate;

/**
 * creat time 2019-04-13
 * jdk version 1.8
 * ascii转换工具
 */
public class AsciiUtills {
    /**
     * 字符转ascii
     * @param value
     * @return
     */
    protected static String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();
    }

    /**
     * ascii转字符
     * @param value
     * @return
     */
    protected static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
}
