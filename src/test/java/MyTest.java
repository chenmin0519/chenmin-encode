import com.chenmin.decorate.ChenminEncryptUtills;

import java.util.Arrays;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
//        String s = ChenminEncryptUtills.simpleEncodeBy2BinarySystem("陈敏");
//        System.out.println(s);
//        List<String> o = ChenminEncryptUtills.simpleDecodeByList(Arrays.asList(s.split(" ")));
//        System.out.println(o);

        String encryptStr = ChenminEncryptUtills.simpleEncode("不知道的事");
        System.out.println(encryptStr);
        String decryptStr = ChenminEncryptUtills.simpleDecode(encryptStr);
        System.out.println(decryptStr);
    }
}
