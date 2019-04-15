package com.chenmin;

import com.chenmin.encryption.EncodeObjectFactory;

import java.util.Arrays;
import java.util.List;

/**
 * creat time 2019-04-12
 * jdk version 1.8
 * 对字符编码操作（chenmin自定义算法）
 */
public class ChenminEncode {

    /**
     * chenmin式编码返回2进制
     * @param plaintext
     * @return
     */
//    public static String chenminEncodeBy2BinarySystem(String plaintext){
//        String result = "";
//        List<String> encodeArr =chenminEncodeByList(plaintext);
//        for(int i = 0 ; i < encodeArr.size() ; i ++){
//            Long codeNum = Long.parseLong(encodeArr.get(i));
//            result += Long.toBinaryString(codeNum);
//            if(i != (encodeArr.size() - 1)){
//                result += " ";
//            }
//        }
//        return result;
//    }
    public static List<String> chenminEncodeByList(String plaintext){
        String asciiStr = stringToAscii(plaintext);
        String[] asciiArr = asciiStr.split(",");
        return EncodeObjectFactory.getChenminSimpleEncryptionInstance()
                .encryption(Arrays.asList(asciiArr));
    }
    /**
     * 字符转ascii
     * @param value
     * @return
     */
    public static String stringToAscii(String value)
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
    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }



}
