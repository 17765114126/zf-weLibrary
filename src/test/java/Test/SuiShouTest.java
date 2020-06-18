package Test;

import com.alibaba.fastjson.JSON;
import com.example.springboot.model.Person;
import com.example.springboot.util.MathUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @ClassName SuiShouTest
 * @Author zhaofu
 * @Date 2020/3/3
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
public class SuiShouTest {
    @Test
    public void test1() {
        String x = "1";
        String y = null;
        Optional<String> x1 = Optional.ofNullable(x);
        System.out.println(x1);
        Optional<String> y1 = Optional.ofNullable(y);
        System.out.println(y1.toString());
    }

    @Test
    public void test2() {
        Person person = new Person();
        System.out.println(person.getName());


        //将返回对象数据转换
        String s = person.toString();
        String s1 = JSON.toJSONString(s);

    }
    @Test
    public void tese3() {

        float payMoney = 100;
        Integer num = 2;

        double sum = 0;
        for (int i = 0; i < 2; i++) {
            double mul = MathUtil.mul(payMoney, num);
            sum = MathUtil.add(sum, mul);
        }
        System.out.println("------------------------------------");
        System.out.println(sum);



    }

}
