package com.chenmin.encryption;

import java.util.ArrayList;
import java.util.List;

/**
 * creat time 2019-04-12
 * jdk version 1.8
 * chenmin的简单加密算法类
 */
public class ChenminSimpleEncryption extends ChenminEncryption{

   private ChenminSimpleEncryption(){}
   protected static ChenminSimpleEncryption getInstance(){
       return new ChenminSimpleEncryption();
   }
    /**
     * 第一次加密
     * @param simpleEncryptBeforArr
     * @return
     */
    @Override
    public List<String> encryption(List<String> simpleEncryptBeforArr) {
        return super.encryption(this.cutbackEncryption(simpleEncryptBeforArr));
    }

    /**
     * 简单的加密算法
     * @param asciiArr ascii数组
     * @return
     */
    public List<String> cutbackEncryption(List<String> asciiArr){
        List<String> asciiEncryptNums = new ArrayList<String>();
        for(int i = 0 ; i < asciiArr.size(); i ++){
            Long asciiNum = Long.parseLong(asciiArr.get(i));
            Long nextAsciiNum;
            if(i != asciiArr.size()-1){
                nextAsciiNum = Long.parseLong(asciiArr.get(i+1));
            }else{
                nextAsciiNum = simpleEncryption2Num;
            }
            Long encryptNum = asciiNum + nextAsciiNum;
            asciiEncryptNums.add(encryptNum.toString());
        }
        return asciiEncryptNums;
    }

}
