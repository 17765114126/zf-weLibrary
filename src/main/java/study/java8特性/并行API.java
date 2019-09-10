import java.util.ArrayList;
import java.util.List;
/**
 * @ClassName 并行API
 * @Author zhaofu
 * @Date 2019/8/1
 * @Version V1.0
 **/
public class 并行API {
    /**
     * D.并行API
     *
     * 1.概述
     *
     * 在Java7之前，并行处理数据基本是通过多线程来解决
     *
     * a.将数据分成部分
     *
     * b.给每个子部分分配一个子线程
     *
     * c.等待所有的子线程全部结束
     *
     * d.合并子线程
     *
     * 这样的并行数据处理不稳定、易出错，在Java8中Stream接口应用分支/合并框架
     *
     * 将一个数据内容分成多个数据块，并用不同的线程分别处理每个数据块流
     *
     * Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成
     *
     * 而并行Stream则是在多个线程上同时执行
     *
     * 图
     *
     * 并行是每个cpu运行一个程序
     *
     * 图
     *
     * */

    /**
     * 2.使用方法
     *
     * 通常编写并行代码很难而且容易出错,
     *
     * 但使用 Stream API 无需编写一行多线程的代码
     *
     * 就可以很方便地写出高性能的并发程序 
     *
     * a.调用Stream的parallel()方法
     *
     * b.调用Collection的parallelStream()方法
     *
     * c.parallel() 与 sequential() 可在并行流与顺序流之间切换
     *
     * */

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();

        // 封装到集合
        for (long i = 1; i <= 100; i++) {
            list.add(i);
        }
        // 计算
        // reduce：参1，和的初始值
        Long sum = list.stream().parallel().reduce(0L, (r, l) -> r + l);
        System.out.println(sum);
    }
/**
 *
 * 3.使用并行的建议
 *
 * a.尽量使用基本类型的流  IntStream, LongStream, and DoubleStream
 *
 * b.有些操作使用并发流的性能会比顺序流的性能更差，比如limit，findFirst，依赖元素顺序的操作在并发流中是极其消耗性能的.findAny的性能就会好很多，因为不依赖顺序
 *
 * c.考虑流中计算的性能(Q)和操性作的能(N)的对比， Q表示单个处理所需的时间， N表示需要处理的数量，如果Q的值越大, 使用并发流的性能就会越高
 *
 * d.数据量不大时使用并发流，性能得不到提升
 *
 * e.考虑数据结构：并发流需要对数据进行分解，不同的数据结构被分解的性能时不一样的
 *
 * f.传递给并行流的函数都是线程安全的，无副作用
 *
 * 图
 *
 *  */
/**
 *4.何时需要并行编程
 *
 * a.是否需要并行
 *
 * 弄清楚你要解决的问题是什么，数据量有多大，计算的特点是什么
 *
 * 并不是所有的问题都适合使用并发，比如当数据量不大时
 *
 * 顺序执行往往比并行执行更快。
 *
 * 准备线程池和其它相关资源也是需要时间的
 *
 * 但当任务涉及到I/O操作并且任务之间不互相依赖时，那么适合并行化
 *
 * b.任务之间是否是独立的？是否会引起任何竞态条件
 *
 * 如果任务之间是独立的
 *
 * 并且代码中不涉及到对同一个对象的某个状态或者某个变量的更新操作
 *
 * 那么就表明代码是可以被并行化的
 *
 * c.结果是否取决于任务的调用顺序
 *
 * 由于在并行环境中任务的执行顺序是不确定的
 *
 * 因此对于依赖于顺序的任务而言，并行化也许不能给出正确的结果
 *
 * */

}
