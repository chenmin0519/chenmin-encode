package com.chenmin.encryption;

import java.util.ArrayList;
import java.util.List;

/**
 * creat time 2019-04-12
 * jdk version 1.8
 * chenmin的加密类
 */
public abstract class ChenminEncryption {

    protected Long simpleEncryption2Num = Long.parseLong("430181");

    private  Long parentSimpleEncrytion1Num = Long.parseLong("5972");
    /**
     * 父级加密算法
     * @param simpleEncrypt1BeforArr
     * @return
     */
    protected List<String> encryption(List<String> simpleEncrypt1BeforArr){
        List<String> simpleEncrypt1AfterArr = new ArrayList<String>();
        simpleEncrypt1BeforArr.forEach(simpleEncrypt1BeforNum -> {
            Long simpleEncrypt1AfterNum = Long.parseLong(simpleEncrypt1BeforNum) + parentSimpleEncrytion1Num;
            simpleEncrypt1AfterArr.add(simpleEncrypt1AfterNum.toString());
        });
        return simpleEncrypt1AfterArr;
    }
}
