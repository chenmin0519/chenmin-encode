import com.chenmin.decorate.ChenminEncryptUtills;


public class MyTest {
    public static void main(String[] args) {
//        String s = ChenminEncryptUtills.simpleEncodeBy2BinarySystem("陈敏");
//        System.out.println(s);
//        List<String> o = ChenminEncryptUtills.simpleDecodeByList(Arrays.asList(s.split(" ")));
//        System.out.println(o);

        String encryptStr = ChenminEncryptUtills.simpleEncode("chenmin");
        System.out.println("---------------加密后："+encryptStr);
        String decryptStr = ChenminEncryptUtills.simpleDecode(encryptStr);
        System.out.println(decryptStr);
    }
}
