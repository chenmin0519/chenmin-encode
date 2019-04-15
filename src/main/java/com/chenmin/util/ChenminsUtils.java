package com.chenmin.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * creat time 2019-04-15
 * jdk version 1.8
 * chnemin的工具
 */
public class ChenminsUtils {

    private static final String[] array = { "^", "~", "?", "@"};

    /**
     * 将list编码成字符串
     * @param list
     * @return
     */
    public static String encodeArrToString(List<String> list){
        String resut = "";
        for(int i = 0 ; i < list.size() ; i ++){
            resut += list.get(i);
            switch ((i+1)%4){
                case 1 : resut += array[0];
                    break;
                case 2 : resut += array[1];
                    break;
                case 3 : resut += array[2];
                    break;
                case 0 : resut += array[3];
                    break;
            }
        }
        return resut;
    }

    /**
     * 将字符串解码成arr
     * @param arg
     * @return
     */
    public static List<String> decodeStringToArr(String arg){
        arg = arg.replace(array[0]," ")
                .replace(array[1]," ")
                .replace(array[2]," ")
                .replace(array[3]," ");
        return Arrays.asList(arg.split(" "));
    }
}
