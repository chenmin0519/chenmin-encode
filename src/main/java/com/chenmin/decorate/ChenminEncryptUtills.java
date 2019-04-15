package com.chenmin.decorate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * creat time 2019-04-13
 * jdk version 1.8
 * 加密模式入口
 */
public class ChenminEncryptUtills {
    /**
     * chenmin式编码返回2进制
     * @param plaintext
     * @return
     */
    public static String simpleEncodeBy2BinarySystem(String plaintext){
        String result = "";
        List<String> encodeArr =simpleEncodeByList(plaintext);
        for(int i = 0 ; i < encodeArr.size() ; i ++){
            Long codeNum = Long.parseLong(encodeArr.get(i));
            result += Long.toBinaryString(codeNum);
            if(i != (encodeArr.size() - 1)){
                result += " ";
            }
        }
        return result;
    }

    public static String simpleDecodeBy2BinarySystem(String plaintext){
        String result = "";
        String[] binarySystemNums = plaintext.split(" ");
        List<String> binarySystem = new ArrayList<>();
        for(int i = 0 ; i < binarySystemNums.length ; i ++){
            Long codeNum = Long.valueOf(binarySystemNums[i],2);
            binarySystem.add(codeNum.toString());
        }
        List<String> decodeArr =simpleDecodeByList(binarySystem);
        for(int i = 0 ; i < decodeArr.size() ; i ++){
            result += decodeArr.get(i);
            if(i != (decodeArr.size() - 1)){
                result += ",";
            }
        }
        result = AsciiUtills.asciiToString(result);
        return result;
    }

    public static List<String> simpleEncodeByList(String plaintext){
        String asciiStr = AsciiUtills.stringToAscii(plaintext);
        String[] asciiArr = asciiStr.split(",");
        CutbackEncryption cutbackEncryption = new CutbackEncryption(
                new SimpleCutEncryption(
                        DefaultEncryption.getInstence()));
        return cutbackEncryption.encrypt(Arrays.asList(asciiArr));
    }

    public static List<String> simpleDecodeByList(List<String> plainArr){
        SimpleCutEncryption cutbackDecryption = new SimpleCutEncryption(
                new CutbackEncryption(
                        DefaultEncryption.getInstence()));
        return cutbackDecryption.decrypt(plainArr);
    }

}
