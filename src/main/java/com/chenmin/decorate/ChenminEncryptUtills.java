package com.chenmin.decorate;

import com.chenmin.util.BinaryUtils;
import com.chenmin.util.ChenminsUtils;

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
     * 简单的加密
     * @param plaintext
     * @return
     */
    public static String simpleEncode(String plaintext){
        String result = "";
        List<String> encodeFinishArr = new ArrayList<>();
        List<String> encodeArr =simpleEncodeByList(plaintext);
        encodeArr.forEach(encodeNum -> {
            encodeFinishArr.add(BinaryUtils.encode64(Double.parseDouble(encodeNum)));
        });
        return ChenminsUtils.encodeArrToString(encodeFinishArr);
    }

    /**
     * 简单的解密
     * @param plaintext
     * @return
     */
    public static String simpleDecode(String plaintext){
        String result = "";
        List<String> encodeFinishArr = ChenminsUtils.decodeStringToArr(plaintext);
        List<String> encodeArr = new ArrayList<>();
        encodeFinishArr.forEach(encodeFinishNum -> {
            Long encodeNum = BinaryUtils.decode64(encodeFinishNum).longValue();
            encodeArr.add(encodeNum.toString());
        });
        List<String> decodeArr = simpleDecodeByList(encodeArr);
        for(int i = 0 ; i < decodeArr.size() ; i ++){
            result += decodeArr.get(i);
            if(i != (decodeArr.size() - 1)){
                result += ",";
            }
        }
        result = AsciiUtills.asciiToString(result);
        return result;
    }
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

    /**
     * chenmin式编码对2进制解密
     * @param plaintext
     * @return
     */
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

    protected static List<String> simpleEncodeByList(String plaintext){
        String asciiStr = AsciiUtills.stringToAscii(plaintext);
        String[] asciiArr = asciiStr.split(",");
        CutbackEncryption cutbackEncryption = new CutbackEncryption(
                new SimpleCutEncryption(
                        DefaultEncryption.getInstence()));
        return cutbackEncryption.encrypt(Arrays.asList(asciiArr));
    }

    protected static List<String> simpleDecodeByList(List<String> plainArr){
        SimpleCutEncryption cutbackDecryption = new SimpleCutEncryption(
                new CutbackEncryption(
                        DefaultEncryption.getInstence()));
        return cutbackDecryption.decrypt(plainArr);
    }

}
