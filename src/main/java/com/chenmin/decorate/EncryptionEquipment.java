package com.chenmin.decorate;


import java.util.List;

/**
 * creat time 2019-04-13
 * jdk version 1.8
 * 抽象的加密算法工艺
 */
public abstract class EncryptionEquipment extends Encryption{
    private Encryption encryption; // 组合，也是类的复用机制

    protected EncryptionEquipment(Encryption encryption) {
        this.encryption = encryption;
    }

    @Override
    protected List<String> encrypt(List<String> encryptBeforArr) {
        //不关心具体如何处理。都会动态绑定到子类。将具体的的实现延迟到子类完成。
        return encryption.encrypt(encryptBeforArr);
    }

    @Override
    protected List<String> decrypt(List<String> decryptBeforArr) {
        //不关心具体如何处理。都会动态绑定到子类。将具体的的实现延迟到子类完成。
        return encryption.decrypt(decryptBeforArr);
    }
}
