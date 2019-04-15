package com.chenmin.decorate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * creat time 2019-04-13
 * jdk version 1.8
 * 后加加密
 */
public class CutbackEncryption extends EncryptionEquipment{

    Logger logger = LoggerFactory.getLogger(CutbackEncryption.class);

    protected CutbackEncryption(Encryption encryption){
        super(encryption);
    }

    @Override
    protected List<String> encrypt(List<String> encryptBeforArr) {
        List<String> superResult = super.encrypt(encryptBeforArr);
        return cutbackEncryption(superResult);
    }

    @Override
    protected List<String> decrypt(List<String> decryptBeforArr) {
//        List<String> cutBackResult =  cutbackDecryption(decryptBeforArr);
//        return super.decrypt(cutBackResult);
        List<String> superResult = super.decrypt(decryptBeforArr);
        return cutbackDecryption(superResult);
    }

    /**
     * 后加加密
     * @param encryptArr
     * @return
     */
    private List<String> cutbackEncryption(List<String> encryptArr){
        logger.info("执行cutbackEncryption()加密");
        List<String> encryptNums = new ArrayList<String>();
        for(int i = 0 ; i < encryptArr.size(); i ++){
            Long asciiNum = Long.parseLong(encryptArr.get(i));
            Long nextAsciiNum;
            if(i == encryptArr.size()-1){
                Random random = new Random();
                Integer randomNum = random.nextInt(99999);
                nextAsciiNum = Long.parseLong(randomNum.toString());
            }else{
                nextAsciiNum = Long.parseLong(encryptArr.get(i+1));
            }
            Long encryptNum = asciiNum + nextAsciiNum;
            encryptNums.add(encryptNum.toString());
            if(i == encryptArr.size()-1){
                encryptNums.add(nextAsciiNum.toString());
            }
        }
        return encryptNums;
    }

    /**
     * 到加解密
     * @param encryptArr
     * @return
     */
    private List<String> cutbackDecryption(List<String> encryptArr){
        logger.info("执行cutbackDecryption()=解密");
        List<String> decryptNums = new ArrayList<>();
        List<Long> decrypts = new ArrayList<>();
        for(int i = encryptArr.size() - 1 ; i >= 0 ; i --){
            if(i != 0){
                Long encryptNum = Long.parseLong(encryptArr.get(i));
                Long nextEncryptNum = Long.parseLong(encryptArr.get(i-1));
                Long decryptNum = nextEncryptNum - encryptNum;
                encryptArr.set(i - 1,decryptNum.toString());
                decrypts.add(decryptNum);
            }
        }
        for(int i = decrypts.size() - 1 ; i >= 0 ; i --){
            decryptNums.add(decrypts.get(i).toString());
        }
        return decryptNums;
    }

}
