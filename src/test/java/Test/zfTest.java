package Test;

import com.example.springboot.util.AESEncryptUtil;
import com.example.springboot.util.Md5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName zfTest
 * @Author zhaofu
 * @Date 2019/9/9
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
public class zfTest {
    @Test
    public void test() {
        int ceil = (int) Math.ceil(26 / 20) + 1;
        List<Object> objects = new ArrayList<>();

        System.out.println(ceil);
        for (int i = 0; i < ceil; i++) {
            for (int j = 0; j <= 20; j++) {
                if (i == ceil - 1 && j == 26 - (i * 20)) break;
                if (i == 1) {
                    System.out.println(i + "---" + j);
                } else {
                    System.out.println(i + "---" + j);
                }
            }
            int x = 3;
            System.out.println("====================");
        }

    }

    public static String aesEncrypt(){
        String key = "zhaofu";
        String md5key= Md5Util.encode(key).toUpperCase();
        return md5key;
    }
    public static String getEncrypt(String token){
        String aesToken = AESEncryptUtil.aesEncrypt(token,aesEncrypt());
        return aesToken;
    }
    public static String aesDecrypt(String token){
        String key = "dorago";
        String AESToken = AESEncryptUtil.aesDecrypt(token, key);

        return AESToken;
    }
}
