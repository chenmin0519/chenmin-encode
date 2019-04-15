package com.chenmin.decorate;

import java.util.List;

/**
 * creat time 2019-04-13
 * jdk version 1.8
 * 默认加密
 */
public class DefaultEncryption extends Encryption{

    private DefaultEncryption(){}

    protected static DefaultEncryption getInstence(){
        return new DefaultEncryption();
    }

    @Override
    protected List<String> encrypt(List<String> encryptBeforArr) {
        return encryptBeforArr;
    }

    @Override
    protected List<String> decrypt(List<String> decryptBeforArr) {
        return decryptBeforArr;
    }
}
