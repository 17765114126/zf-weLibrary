package Test;

import com.example.springboot.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateTest
 * @Author zhaofu
 * @Date 2020/8/3
 * @Version V1.0
 **/
public class DateTest {
    public static void main(String[] args) {

        //判断当前时间，是否在起始时间和结束时间之间，可以精确到秒
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        Date now = null;
        Date beginTime = null;
        Date endTime = null;
        try {
            now = df.parse(df.format(new Date()));
            beginTime = df.parse("2020-07-30 00:00:00");
            endTime = df.parse("2020-08-09 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Boolean flag = DateUtil.belongCalendar(now, beginTime, endTime);
//        System.out.println(flag);

        Boolean flag1 = DateUtil.betweenStartAndEndDate(now, beginTime, endTime);

        if (!flag1){
            System.out.println(flag1);
        }

    }



}
