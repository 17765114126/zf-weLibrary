package study.java8特性;

import com.example.springboot.model.Student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName Test2
 * @Author zhaofu
 * @Date 2019/8/7
 * @Version V1.0
 **/
//Java8新了stream API，需要注意的是Stream和I/O中的流是没有关系的，这个stream主要是要来处理集合数据的，可以将其看作一个高级迭代器。
// 在Collection接口中新增了非抽象的stream方法来获取集合的流。

//另外，Java8中新增了一个Optional类用于处理空指针异常，该类位于java.util包下，使用这个类可以更好的支持函数式编程，并且可以简化以前对null的判断。

public class Test2 {
    public static void main(String[] args) {
        List<Student> stuList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setName("张仪"+i);
            student.setAge(85+i+i);
            stuList.add(student);
        }
        //需求：列出90分以上的学生姓名，并按照分数降序排序

        //以前的写法，代码较多，每个操作都需要遍历集合
        List<Student> result1 = new ArrayList<>(10);
        //遍历集合获取分数大于90以上的学生并存放到新的List中
        for(Student s : stuList){
            if(s.getAge() >= 90){
                result1.add(s);
            }
        }
        //对List进行降序排序
        result1.sort(new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2) {
                //降序排序
                return Integer.compare(s2.getAge(), s1.getAge());
            }
        });
        System.out.println(result1);

        //使用stream的写法
        /*
         * 1.获取集合的stream对象
         * 2.使用filter方法完成过滤
         * 3.使用sort方法完成排序
         * 4.使用collect方法将处理好的stream对象转换为集合对象
         */
        result1 = stuList.stream()
                .filter(s -> s.getAge()>=90)
                //.sorted((s1,s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                //使用Comparator中的comparing方法
                .sorted(Comparator.comparing(Student :: getAge).reversed())
                .collect(Collectors.toList());
        System.out.println(result1);
        System.out.println("------------------------");
        testTow();
        System.out.println("---------------------------");
        TestThree();
    }
    public static void testTow(){
        ArrayList<Student> students = new ArrayList<>();
        //初始化List数据同上
        List<Student> list = new ArrayList<>();
        //使用map方法获取list数据中的name
        List<String> names = list.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(names);

        //使用map方法获取list数据中的name的长度
        List<Integer> length = list.stream().map(Student::getName).map(String::length).collect(Collectors.toList());
        System.out.println(length);

        //将每人的分数-10
        List<Integer> score = list.stream().map(Student::getAge).map(i -> i - 10).collect(Collectors.toList());
        System.out.println(score);

        //计算学生总分
        Integer totalScore1 = list.stream().map(Student::getAge).reduce(0,(a,b) -> a + b);
        System.out.println(totalScore1);

        //计算学生总分，返回Optional类型的数据，改类型是java8中新增的，主要用来避免空指针异常
        Optional<Integer> totalScore2 = list.stream().map(Student::getAge).reduce((a, b) -> a + b);
        //System.out.println(totalScore2.get());

        //计算最高分和最低分
        Optional<Integer> max = list.stream().map(Student::getAge).reduce(Integer::max);
        Optional<Integer> min = list.stream().map(Student::getAge).reduce(Integer::min);

//        System.out.println(max.get());
//        System.out.println(min.get());
    }
    //map和reduce
    //map用来归类，结果一般是一组数据，比如可以将list中的学生分数映射到一个新的stream中。
    //reduce用来计算值，结果是一个值，比如计算最高分。
    public static void TestThree(){
        //初始化List数据同上
        List<Student> list = new ArrayList<>();
        //使用map方法获取list数据中的name
        List<String> names = list.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(names);

        //使用map方法获取list数据中的name的长度
        List<Integer> length = list.stream().map(Student::getName).map(String::length).collect(Collectors.toList());
        System.out.println(length);

        //将每人的分数-10
        List<Integer> score = list.stream().map(Student::getAge).map(i -> i - 10).collect(Collectors.toList());
        System.out.println(score);

        //计算学生总分
        Integer totalScore1 = list.stream().map(Student::getAge).reduce(0,(a,b) -> a + b);
        System.out.println(totalScore1);

        //计算学生总分，返回Optional类型的数据，改类型是java8中新增的，主要用来避免空指针异常
        Optional<Integer> totalScore2 = list.stream().map(Student::getAge).reduce((a,b) -> a + b);
//        System.out.println(totalScore2.get());

        //计算最高分和最低分
        Optional<Integer> max = list.stream().map(Student::getAge).reduce(Integer::max);
        Optional<Integer> min = list.stream().map(Student::getAge).reduce(Integer::min);

//        System.out.println(max.get());
//        System.out.println(min.get());
    }
}
/*数值流

上面代码中

Optional<Integer> totalScore2 = list.stream()
                .map(Student::getScore)
                .reduce((a,b) -> a + b);
如果要是在Stream中有一个sum方法的话，可以修改为

Optional<Integer> totalScore2 = list.stream()
                .map(Student::getScore)
                .sum();
不过没有，但是在java8中新增了三个原始类型流（IntStream、DoubleStream、LongStream）来解决这个问题，

//数值流
public class StreamTest03 {
    public static void main(String[] args) {
        List<Student> list = InitData.getStudent();

        //将stream转换为IntStream
        int totalScore = list.stream().mapToInt(Student::getScore).sum();
        System.out.println(totalScore);

        //计算平均分
        OptionalDouble avgScore = list.stream().mapToInt(Student::getScore).average();
        System.out.println(avgScore.getAsDouble());

        //生成1~100之间的数字
        IntStream num = IntStream.rangeClosed(1, 100);

        //计算1~100之间的数字中偶数的个数
        long count = IntStream.rangeClosed(1, 100).filter(n -> n%2 == 0).count();
        System.out.println(count);
    }
}
 

创建流

除了上面的流之外，我们还可以自己创建流。下面代码中展示了三种创建流的方式：

//使用Stream.of创建流
    Stream<String> str =  Stream.of("i","love","this","game");
    str.map(String::toUpperCase).forEach(System.out::println);

    //使用数组创建流
    int[] num = {2,5,9,8,6};
    IntStream intStream = Arrays.stream(num);
    int sum = intStream.sum();//求和
    System.out.println(sum);

    //由函数生成流，创建无限流
    Stream.iterate(0, n -> n+2).limit(10).forEach(System.out::println);
*/