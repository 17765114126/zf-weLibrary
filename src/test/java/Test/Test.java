package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Author zhaofu
 * @Date 2019/9/9
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        int ceil = (int) Math.ceil(26 / 20)+1;
        List<Object> objects = new ArrayList<>();

        System.out.println(ceil);
        for (int i = 0; i < ceil; i++) {
            for (int j = 0; j <=20; j++) {
                if (i== ceil-1 && j==26-(i*20))break;
                if (i == 1) {
                    System.out.println(i+"---"+j);
                } else {
                    System.out.println(i+"---"+j);
                }
            }
            int x = 3;
            System.out.println("====================");
        }

    }

}
