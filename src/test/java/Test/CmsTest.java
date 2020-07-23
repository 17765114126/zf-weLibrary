package Test;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @ClassName CmsTest
 * @Author zhaofu
 * @Date 2019/12/4
 * @Version V1.0
 **/
public class CmsTest {
    public static void main(String[] args) {

        BigDecimal c = BigDecimal.valueOf(3.55);
        Integer g = 2;
        BigDecimal bignum2 = new BigDecimal(g);
        BigDecimal multiply = c.multiply(bignum2);

        Float xx = 200001.11f;
        Float yy = 200000.08f;
        Float tt = xx - yy;


        BigDecimal b1 = new BigDecimal(Float.toString(xx));
        BigDecimal b2 = new BigDecimal(Float.toString(yy));
        float ss = b1.subtract(b2).floatValue();
        System.out.println("tttttt-----" + tt);
        System.out.println("ssss----" + ss);



        String str = "123456789,";
        if (StringUtils.isNotBlank(str)&& str.substring(str.length() - 1).equals(",")){
            String substring = str.substring(0, str.length() - 1);
            System.out.println(substring);
        }
        System.out.println(str);
    }
}
