package Test;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName CmsTest
 * @Author zhaofu
 * @Date 2019/12/4
 * @Version V1.0
 **/
public class CmsTest {
    public static void main(String[] args) {
        String str = "123456789,";
        if (StringUtils.isNotBlank(str)&& str.substring(str.length() - 1).equals(",")){
            String substring = str.substring(0, str.length() - 1);
            System.out.println(substring);
        }
        System.out.println(str);
    }
}
