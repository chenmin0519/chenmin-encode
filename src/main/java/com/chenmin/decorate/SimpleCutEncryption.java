package com.chenmin.decorate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * creat time 2019-04-13
 * jdk version 1.8
 * 简单的加数
 */
public class SimpleCutEncryption extends EncryptionEquipment{

    Logger logger = LoggerFactory.getLogger(SimpleCutEncryption.class);

    protected SimpleCutEncryption(Encryption encryption){
        super(encryption);
    }

    @Override
    protected List<String> encrypt(List<String> encryptBeforArr) {
        List<String> superResult = super.encrypt(encryptBeforArr);
        return simpleCutEncryption(superResult);
    }

    @Override
    protected List<String> decrypt(List<String> decryptBeforArr) {
//        List<String> cutBackResult =  simpleCutDecryption(decryptBeforArr);
//        return super.decrypt(cutBackResult);
        List<String> superResult = super.decrypt(decryptBeforArr);
        return simpleCutDecryption(superResult);
    }

    private List<String> simpleCutEncryption(List<String> encryptBeforArr){
        logger.info("执行simpleCutEncryption()加密");
        List<String> encryptAfterArr = new ArrayList<>();
        Random random = new Random();
        Integer randomNum = random.nextInt(999);
        Integer randomEncryptNum = randomNum*6-519;
        encryptAfterArr.add(randomEncryptNum.toString());
        int index = 1;
        for(int i = 0 ; i < encryptBeforArr.size() ; i ++){
            Long encryptNum = Long.parseLong(encryptBeforArr.get(i));
            Long temp;
            if(index%2 > 0){
                temp = encryptNum - (randomNum*2);
            }else{
                temp = encryptNum - randomNum;
            }
            encryptAfterArr.add(temp.toString());
            index ++;
        }
        return encryptAfterArr;
    }

    private List<String> simpleCutDecryption(List<String> decryptBeforArr){
        logger.info("执行simpleCutDecryption()解密");
        List<String> decryptAfterArr = new ArrayList<>();
        Long randomNum = Long
                .parseLong(decryptBeforArr
                        .get(0));
        randomNum = (randomNum + 519)/6;
        for(int index = 1 ; index < decryptBeforArr.size() ; index ++){
            Long decryptNum = Long.parseLong(decryptBeforArr.get(index));
            Long temp;
            if(index%2 > 0){
                temp = decryptNum + (randomNum*2);
            }else{
                temp = decryptNum + randomNum;
            }
            decryptAfterArr.add(temp.toString());
        }
        return decryptAfterArr;
    }

}
