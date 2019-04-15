package com.chenmin.decorate;

import java.util.List;

/**
 * creat time 2019-04-13
 * jdk version 1.8
 * 抽象的加密算法
 */
public abstract class Encryption{
    /**
     * 加密
     * @param encryptBeforArr
     * @return
     */
    protected abstract List<String> encrypt(List<String> encryptBeforArr);

    /**
     * 解密
     * @param decryptBeforArr
     * @return
     */
    protected abstract List<String> decrypt(List<String> decryptBeforArr);
}
