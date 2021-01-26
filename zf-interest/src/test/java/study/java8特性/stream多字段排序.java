package study.java8特性;

/**
 * @ClassName stream多字段排序
 * @Author zhaofu
 * @Date 2020/8/14
 * @Version V1.0
 **/
public class stream多字段排序 {
//转载：https://www.cnblogs.com/kuanglongblogs/p/11230250.html
//
//很多情况下sql不好解决的多表查询,临时表分组,算法排序,尽量用java8新特性stream进行处理
//
//使用java8新特性,下面先来点基础的

//List<类> list; 代表某集合
//
////返回 对象集合以类属性一升序排序
//
//list.stream().sorted(Comparator.comparing(类::属性一));
//
////返回 对象集合以类属性一降序排序 注意两种写法
//
//list.stream().sorted(Comparator.comparing(类::属性一).reversed());//先以属性一升序,结果进行属性一降序
//
//list.stream().sorted(Comparator.comparing(类::属性一,Comparator.reverseOrder()));//以属性一降序
//
////返回 对象集合以类属性一升序 属性二升序
//
//list.stream().sorted(Comparator.comparing(类::属性一).thenComparing(类::属性二));
//
////返回 对象集合以类属性一降序 属性二升序 注意两种写法
//
//list.stream().sorted(Comparator.comparing(类::属性一).reversed().thenComparing(类::属性二));//先以属性一升序,升序结果进行属性一降序,再进行属性二升序
//
//list.stream().sorted(Comparator.comparing(类::属性一,Comparator.reverseOrder()).thenComparing(类::属性二));//先以属性一降序,再进行属性二升序
//
////返回 对象集合以类属性一降序 属性二降序 注意两种写法
//
//list.stream().sorted(Comparator.comparing(类::属性一).reversed().thenComparing(类::属性二,Comparator.reverseOrder()));//先以属性一升序,升序结果进行属性一降序,再进行属性二降序
//
//list.stream().sorted(Comparator.comparing(类::属性一,Comparator.reverseOrder()).thenComparing(类::属性二,Comparator.reverseOrder()));//先以属性一降序,再进行属性二降序
//
////返回 对象集合以类属性一升序 属性二降序 注意两种写法
//
//list.stream().sorted(Comparator.comparing(类::属性一).reversed().thenComparing(类::属性二).reversed());//先以属性一升序,升序结果进行属性一降序,再进行属性二升序,结果进行属性一降序属性二降序
//
//list.stream().sorted(Comparator.comparing(类::属性一).thenComparing(类::属性二,Comparator.reverseOrder()));//先以属性一升序,再进行属性二降序<br><br><br>
//通过以上例子我们可以发现
//
//1. Comparator.comparing(类::属性一).reversed();
//
//2. Comparator.comparing(类::属性一,Comparator.reverseOrder());
//
//两种排序是完全不一样的,一定要区分开来 1 是得到排序结果后再排序,2是直接进行排序,很多人会混淆导致理解出错,2更好理解,建议使用2
//
//实际例子:
//
//现有一个类test 有两个属性:state 状态 time 时间,需要状态顺序且时间倒序

//class test {
//    //状态
//    private int state;
//    //时间
//    private Date time;
//
//    public test(int state, Date time) {
//        this.state = state;
//        this.time = time;
//    }
//
//    public int getState() {
//        return state;
//    }
//
//    public void setState(int state) {
//        this.state = state;
//    }
//
//    public Date getTime() {
//        return time;
//    }
//
//    public void setTime(Date time) {
//        this.time = time;
//    }
//
//    @Override
//    public String toString() {
//        return "test{" +
//                "state=" + state +
//                ", time=" + DateUtils.formatDateYMD(time) +
//                '}';
//    }
//}

//class testRun {
//    public static void main(String[] args) {
//        List<test> testList = new ArrayList<>();
//        Date d = DateUtils.now();
//        for (int i = 1; i <= 3; i++) {
//            test t = new test(i, DateUtils.addDays(d, i));
//            testList.add(t);
//        }
//        for (int i = 1; i <= 3; i++) {
//            test t = new test(i, DateUtils.addMonths(d, i));
//            testList.add(t);
//        }
//
//        testList.forEach(o -> {
//            System.out.println(o.toString());
//        });
//        List<test> sort = testList.stream().sorted(Comparator.comparing(test::getState).thenComparing(test::getTime,Comparator.reverseOrder())).collect(toList());
//        System.out.println("------------------------------------");
//        sort.forEach(o -> {
//            System.out.println(o.toString());
//        });
//
//
//    }
//}
//　　运行结果:
//排序前:
//test{state=1, time=2019-07-24}
//test{state=2, time=2019-07-25}
//test{state=3, time=2019-07-26}
//test{state=1, time=2019-08-23}
//test{state=2, time=2019-09-23}
//test{state=3, time=2019-10-23}
//------------------------------------
//排序后:
//test{state=1, time=2019-08-23}
//test{state=1, time=2019-07-24}
//test{state=2, time=2019-09-23}
//test{state=2, time=2019-07-25}
//test{state=3, time=2019-10-23}
//test{state=3, time=2019-07-26}
//
//Process finished with exit code 0
}
