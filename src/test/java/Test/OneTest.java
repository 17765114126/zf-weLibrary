package Test;

import com.example.springboot.Controller.Activemq.Consumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName OneTest
 * @Author zhaofu
 * @Date 2019/12/10
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
public class OneTest {
    public static void main(String[] args) {
        String str = "1234567.txt";
        if (str.indexOf(".tx") != -1) {
            System.out.println("包含该字符串");
        }else {
            System.out.println("不包含该字符串");
        }
    }
}
