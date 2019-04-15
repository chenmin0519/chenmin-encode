package com.chenmin.encryption;

/**
 * creat time 2019-04-13
 * jdk version 1.8
 * 获取编码实例工具
 */
public class EncodeObjectFactory {

    /**
     * 获取陈敏简单加密类实例
     * @return
     */
    public static ChenminSimpleEncryption getChenminSimpleEncryptionInstance(){
        return ChenminSimpleEncryption.getInstance();
    }

}
