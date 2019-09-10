import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName Time日期时间
 * @Author zhaofu
 * @Date 2019/8/1
 * @Version V1.0
 **/
public class Time日期时间 {

    /**
     *
     * E.Time日期时间
     *
     * 1.旧的日期时间缺点
     *
     * a.非线程安全
     *
     *  java.util.Date不是线程安全的
     *
     * 因此开发者必须在使用日期处理并发性问题
     *
     * 新的日期时间API是不可变的，并且没有setter方法
     *
     * b.设计不佳
     *
     * 默认的开始日期从1900年，开始每月从1天从0开始，所以没有统一
     *
     * 不直接使用方法操作日期。新的API提供了这样操作实用方法
     *
     * c. 困难的时区处理
     *
     * 开发人员必须编写大量的代码来处理时区的问题
     *
     * 新的API设计开发保持特定领域设计
     *
     * 2.Instat
     *
     * a.概述
     *
     * 时间戳，即时间轴上的一个点
     *
     * 从元年1970-1-1 00:00:00到现在的nanosecond数
     *
     * b. Instant.now();获取当前时间
     *
     * */

/*    public static void main(String[] args) {
        // 获取当前时间
        Instant now = Instant.now();

        // T代表东西经0°经线区时：伦敦时间
        System.out.println(now);// 2017-11-25T14:06:57.079Z

        // c.Instant.ofEpochMilli(new Date().getTime()); 旧日期转为新日期
        // 获取当前时间
        now = Instant.ofEpochMilli(new Date().getTime());
        System.out.println(now);

        //d. Instant.parse();日期文本格式转换为时间格式
        // 获取当前时间
        now = Instant.parse("1993-02-06T10:12:35Z");
        System.out.println(now);
    }
    */
/**
 *3.LocalDate
 *
 * 表示不带时区的日期，比如2014-01-14
 *
 * a.LocalDateTime.now();获取当前日期时间
 *
 * b.now.minusDays(2);将当前日期时间减去两天
 *
 * c.LocalDateTime.of(2016, 10, 23);构造一个指定日期时间的对象
 *
 * */
/*    public static void main(String[] args) {
        // 当前时间
        LocalDate now = LocalDate.now();
        System.out.println(now);

        // 往前推两天
        LocalDate date = now.minusDays(2);
        System.out.println(date);

        // 制定一个日期
        LocalDate localDate = LocalDate.of(1993, 2, 6);
        System.out.println(localDate);
    }*/
/**
 *
 * 4.LocalTime
 *
 * 表示不带时区的时间
 *
 * a. LocalTime.now();当前时间
 *
 * b. LocalTime.of(22, 33);确定的时间
 *
 * c.LocalTime.ofSecondOfDay(4503); 一天中的第4503秒
 *
 * */

/*    public static void main(String[] args) {
        // 当前时间
        LocalTime now = LocalTime.now();
        System.out.println(now);

        // 22:33
        LocalTime localTime = LocalTime.of(22, 33);
        System.out.println(localTime);

        // 一天中的4503秒
        LocalTime ofDay = LocalTime.ofSecondOfDay(4503);
        System.out.println(ofDay);
    }*/
/**
 * 5.LocalDateTim
 *
 *  是LocalDate和LocalTime的组合体，表示的是不带时区的日期及时间
 *
 * a.LocalDateTime.now();当前时间
 *
 * b.localDateTime.plusHours(25).plusMinutes(3); 当前时间加上25小时３分钟
 *
 * c.LocalDateTime.of(2014, 1, 20, 3, 30, 20)；转换
 *
 * */

/*    public static void main(String[] args) {
        // 当前时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // 当前时间加上25小时３分钟
        LocalDateTime plusMinutes = now.plusHours(24).plusMinutes(3);
        System.out.println(plusMinutes);

        // 转换
        LocalDateTime of = LocalDateTime.of(1993, 2, 6, 11, 23, 30);
        System.out.println(of);
    }*/
/**
 *
 * 6.ZoneDateTime
 *
 * 含有时区信息的时间
 *
 * a.ZonedDateTime.now();获取包含时区的当前日期时间
 *
 * b.ZonedDateTime.of(LocalDateTime.of(2014, 1, 20, 3, 30, 20), ZoneId.of("+08"));创建时区的日期时间对象
 *
 * */

 /*   public static void main(String[] args) {
        // 当前时间
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        // 创建时区的日期时间对象
        ZonedDateTime of = ZonedDateTime.of(LocalDateTime.of(1993, 2, 6, 11, 23, 30), ZoneId.of("+08"));
        System.out.println(of);
    }*/
/**
 * 7.DateTimeFormatter
 *
 * 格式化日期和解析日期格式字符串。DateTimeFormatter是不可变类
 *
 * a.格式化：日期对象转换为格式字符串
 * */
/*    public static void main(String[] args) {
        // 格式化
        String time = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss").format(LocalDateTime.now());
        System.out.println(time);
    }*/

/**
 * b.解析：格式字符串转换为日期对象
 * */
    /*public static void main(String[] args) {
        // 格式化
        LocalDateTime parse = LocalDateTime.parse("2017.01.01 08:08:08", DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        System.out.println(parse);
    }*/
/**
 * 8. 遗留代码操作
 *
 * a.Date --> Instant
 *
 * b.Calendar-->Instant
 * */

    /*public static void main(String[] args) {
        Instant timestamp = new Date().toInstant();

        Instant instant = Calendar.getInstance().toInstant();

        System.out.println(timestamp);
        System.out.println(instant);
    }*/

}
