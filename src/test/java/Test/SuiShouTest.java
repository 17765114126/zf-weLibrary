package Test;

import com.alibaba.fastjson.JSON;
import com.example.springboot.model.Person;
import com.example.springboot.util.MathUtil;
import com.example.springboot.util.StringUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ClassName SuiShouTest
 * @Author zhaofu
 * @Date 2020/3/3
 * @Version V1.0
 **/
//@RunWith(SpringRunner.class)
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
        person.setSex(null);

        System.out.println(person.getSex());
        if (person.getSex() == null) {
            System.out.println("1");
        }

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

    @Test
    public void test4() {
        String string = "广东省汕头市澄海区盐鸿镇国道324线春天湖工业区鸿一路段树业毛织";
        int length = string.length();
        if (length > 40) {
            System.out.println("大于四十");
        } else {
            System.out.println("小于40");
        }

        String str = "1234567.txt";
        if (str.indexOf(".tx") != -1) {
            System.out.println("包含该字符串");
        } else {
            System.out.println("不包含该字符串");
        }
    }

    @Test
    public void test5() {
//        List objects = new ArrayList(10);
//        List list = Collections.synchronizedList(new ArrayList(10));
//
//        Map map = new HashMap(16);
//        map.put("1",1);

        System.out.println(Math.ceil(9.1));
        yqhGetPrice(100.6);
    }

    @Test
    public void test7() {
        System.out.println("qaazsdd");
    }

    /**
     * 一起火计算价格
     *
     * @param xyPrice
     * @return
     */
    public Map<String, Object> yqhGetPrice(Double xyPrice) {//进货价
        xyPrice = MathUtil.toInteger(xyPrice * 0.95);//打九五折并取整数
        if (xyPrice <= 100) {
            xyPrice = xyPrice * 3;
        } else if (xyPrice > 100) {
            xyPrice = xyPrice * 2.7;
        }
        String tempPrice = String.valueOf((int) Math.ceil(xyPrice));
        int i = Integer.parseInt(tempPrice.substring(tempPrice.length() - 1));
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
            i = 6;
        } else if (i == 7 || i == 8) {
            i = 8;
        } else if (i == 9) {
            i = 9;
        }
        String xsPrice = tempPrice.substring(0, tempPrice.length() - 1) + String.valueOf(i);
        String hxPrice = String.valueOf(Math.round(Float.parseFloat(xsPrice) * 2.1));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("clos4", hxPrice);
        map.put("clos5", xsPrice);
        System.out.println(hxPrice);
        System.out.println(xsPrice);
        return map;
    }

    @Test
    public void Test8() {
        String expressNumber = "  1213    3134  12  ";
        String s = expressNumber.replaceAll(" ", "");
        System.out.println(expressNumber);
        System.out.println(s);
    }

    @Test
    public void Test9() {
        int a = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;//产生1000-9999的随机数
        System.out.println(a);

        int c = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;
        System.out.println(c);
    }

    @Test
    public void Test10() {
        boolean matches = "19165114126".matches("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");
        System.out.println(matches);
    }

    @Test
    public void Test11(){
        String mobile = null;
        if (StringUtil.isBlank(mobile)){
            mobile = "2314";
        }
        System.out.println(mobile);
    }

    @Test
    public void Test12(){
        BigDecimal q = new BigDecimal(1.55);
        BigDecimal a = new BigDecimal(1.45);
        BigDecimal z = new BigDecimal(0.61);
        BigDecimal bigDecimal = q.add(a).add(z);
        float v = bigDecimal.floatValue();
        System.out.println(v);

        /**
         * 小可以转大，大不可以转小
         * */
        Byte w = 2;
        Double s = Double.valueOf(w);
        System.out.println(s);
        Integer integer = Integer.valueOf(w);

    }
}
