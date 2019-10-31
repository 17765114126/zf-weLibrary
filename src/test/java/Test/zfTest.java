package Test;

import com.example.springboot.util.AESEncryptUtil;
import com.example.springboot.util.Md5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
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
    @Test
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
        String AESToken = AESEncryptUtil.aesDecrypt(token, aesEncrypt());

        return AESToken;
    }



    @Test
    public static void main(String[] args) {
        /**
         * LocalDate
         * */
        LocalDate today = LocalDate.now(); //当前日期 yyyy-dd-mm
        System.out.println(today.getMonth()+"---//APRIL 当前日期-月 getvalue 可以获得数字");
        System.out.println(today.getMonthValue()+"---//当前日期-月");
        System.out.println(today.getYear()+"---//当前日期-年");
        System.out.println(today.getDayOfMonth()+"---//当前日期-日");
        System.out.println(today.getDayOfWeek()+"---//返回当前日期是星期几");
        System.out.println(today.getDayOfWeek().getValue()+"---//getValue 可以获取1-7数字星期");
        System.out.println(today.getDayOfYear()+"//获取 当前 年到 今天的天数,包含今天");
        System.out.println(today.plusDays(1)+"//获得当前日期之后的日期");
        System.out.println(today.minusDays(1)+"//获得当前日期之前的日期");
        System.out.println(today.atTime(LocalTime.now())+"//2019-10-31T16:04:44.557");

        LocalDate DayofYear = LocalDate.ofYearDay(2019, 304);//返回哪一年，多少天后的日期
        System.out.println(DayofYear+"//返回哪一年，多少天后的日期 ==> 2019-10-31");
        LocalDate EpochDay = LocalDate.ofEpochDay(0);//获得1970-01-01后的日期，1970-01-01后的0天还是1970-01-01，如果是ofEpochDay(1) 则返回 1970-01-02
        System.out.println(EpochDay+"//获得1970-01-01后的日期，1970-01-01后的0天还是1970-01-01，如果是ofEpochDay(1) 则返回 1970-01-02");
        LocalDate Dateoftaking = LocalDate.of(2019,10,31);//根据年月日返回日期 yyyy-dd-mm
        System.out.println(Dateoftaking+"//根据年月日返回日期 yyyy-dd-mm");
        LocalDate endOfFeb = LocalDate.parse("2019-10-31"); // 严格按照ISO yyyy-MM-dd验证，02写成2都不行
        System.out.println(endOfFeb+"// 严格按照ISO yyyy-MM-dd验证，02写成2都不行");
        LocalDate.parse("2018-02-28"); // 无效日期无法通过：java.time.DateTimeException: Invalid date 'February 29' as '2018' is not a leap year

        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth()); // 2019-10-01
        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); // 2019-10-02
        // 取本月最后一天，不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2019-10-31
        // 取下一天：
        LocalDate firstDayOf = lastDayOfThisMonth.plusDays(1); // 变成了2019-11-01
        // 取2019年2月第一个周一
        LocalDate firstMondayOf = LocalDate.parse("2019-02-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); //2019-02-04

        /**
         * LocalTime
         * */
        LocalTime now = LocalTime.now(); //16:21:08.430  获得当前时间
        System.out.println(now.getHour()+"//时");
        System.out.println(now.getMinute()+"//分");
        System.out.println(now.getNano()+"//纳秒");
        System.out.println(now.getSecond()+"//秒");
        System.out.println(now.of(21, 30, 59, 11011)+"//或的21:30:59:11011");
        System.out.println(now.plusHours(3)+"//当前时间3小时后");
        System.out.println(now.plusMinutes(3)+"//当前时间3分钟后");
        System.out.println(now.plusSeconds(3)+"//当前时间3秒后");
        System.out.println(now.plusNanos(3)+"//当前时间3纳秒后");
        System.out.println(now.minusHours(3)+"//当前时间3小时前");
        System.out.println(now.minusMinutes(3)+"//当前时间3分钟前");
        System.out.println(now.minusSeconds(3)+"//当前时间3秒前");
        System.out.println(now.minusNanos(3)+"//当前时间3纳秒前");

        //构造时间
        LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
        LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00

        LocalDateTime localDateTime = now.atDate(LocalDate.now()); //获得当前日期时间  2018-04-22T16:23:07.232
        System.out.println(localDateTime);
    }

    /**
     * 判断文件大小
     *
     * @param :multipartFile:上传的文件
     * @param size: 限制大小
     * @param unit:限制单位（B,K,M,G)
     * @return boolean:是否大于
     */
    @Test
    public static boolean checkFileSize(MultipartFile multipartFile, int size, String unit) {
        long len = multipartFile.getSize();//上传文件的大小, 单位为字节.
        //准备接收换算后文件大小的容器
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        //如果上传文件大于限定的容量
        if (fileSize > size) {
            return true;
        }
        return false;
    }


}
