package Test;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @ClassName 并发编程
 * @Author zhaofu
 * @Date 2020/9/26
 * @Version V1.0
 * @url http://www.tianshouzhi.com/api/tutorials/mutithread/238
 *
 **/
public class 并发编程 {
    @Test
    public void test1() {
        //用于打印主线程的名称
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void test2() {
        //创建一个线程对象，覆盖其run方法，传入参数为线程的名字
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("自定义线程循环：" + i + "次");
                }
            }
        };

        //调用start方法启动线程
        t1.start();
        for (int i = 1; i <= 100; i++) {
            System.out.println("主线程循环：" + i + "次");
        }
    }
    @Test
    public void test3() {
        // java程序启动至少会启动几个线程

        //这段代码的作用是打印出当前JVM中运行的所有线程信息，这使用到了JMX的API
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId()+"-"+threadInfo.getThreadName());
        }
        //5-Attach Listener
        //4-Signal Dispatcher //分发处理发送给JVM信号的线程
        //3-Finalizer //调用对象的finalize方法的线程，就是垃圾回收的线程
        //2-Reference Handler //清除reference的线程
        //1-main //主线程
    }
    @Test
    public void test4() {
        new Thread("custom thread"){
            @Override
            public void run() {
                System.out.println("当前线程:"+Thread.currentThread().getName());
            }
        }.start();

        System.out.println("当前线程:"+Thread.currentThread().getName());
    }
    @Test
    public void test5() throws InterruptedException {

        //段代码我们使用了一个方法Thread.currentThread().sleep(miliseconds)来模拟文件的模拟和处理操作。
        // 其作用是让当前线程休眠，休眠的含义是在指定的时间范围内，线程不会再向CPU发送执行的请求。
        // 等到休眠时间已过，才会重新请求CPU执行。
        // 因为我们的代码都是在main方法即主线程中运行，因此当主线程休眠的时候，就相当于程序停止了运行，等到休眠时间已过，程序才会继续运行，然后又休眠,运行...。
        final long start=System.currentTimeMillis();
        System.out.println("----------程序开始运行---------");
        System.out.println("读取A文件开始...");
        Thread.currentThread().sleep(5000);
        System.out.println("读取A文件结束，耗时："+(System.currentTimeMillis()-start)/1000+"秒...开始处理A文件");
        Thread.currentThread().sleep(2000);
        System.out.println("A文件处理完成...，耗时："+(System.currentTimeMillis()-start)/1000+"秒");
        System.out.println("读取B文件开始...");
        Thread.currentThread().sleep(5000);
        System.out.println("读取B文件结束，耗时："+(System.currentTimeMillis()-start)/1000+"秒...开始处理B文件");
        Thread.currentThread().sleep(2000);
        System.out.println("B文件处理完成...，耗时："+(System.currentTimeMillis()-start)/1000+"秒");
        //需要注意的是，上面的代码，资源利用率是很低的。
        //原因在于从磁盘中读取文件的时候，大部分的CPU时间用于等待磁盘去读取数据。
        // 在这段时间里，CPU非常的空闲。其深层次的原因是对于IO操作，往往是通过硬件直接存取器(DMA)来执行的，
        // 也就是说，CPU只需要将发送一个指令给DMA去执行对应的IO操作即可，指令发送是一瞬间的事，发送完成CPU就可以干其他的事了,
        // 我们说的IO操作需要执行5秒事实上是DMA执行这个操作需要5秒的时间，而不是CPU。
    }

    @Test
    public void test6() throws InterruptedException {
        //因此CPU现在很空闲，它可以做一些别的事情。通过改变操作的顺序，就能够更好的使用CPU资源。
        //CPU等待第一个文件被读取完。然后开始读取第二个文件。当第二文件在被读取的时候，CPU会去处理第一个文件。
        final long start=System.currentTimeMillis();
        System.out.println("----------程序开始运行---------");
        System.out.println("读取A文件开始...");
        Thread.currentThread().sleep(5000);
        System.out.println("读取A文件结束，耗时："+(System.currentTimeMillis()-start)/1000+"秒...开始处理A文件，同时开始读取B文件..");
        Thread t1=new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("读取B文件开始...");
                    Thread.currentThread().sleep(5000);
                    System.out.println("读取B文件结束，耗时："+(System.currentTimeMillis()-start)/1000+"秒...开始处理B文件");
                    Thread.currentThread().sleep(2000);
                    System.out.println("B文件处理完成...");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        Thread.currentThread().sleep(2000);
        System.out.println("A文件处理完成...");
        t1.join();
        System.out.println("总耗时:"+(System.currentTimeMillis()-start)/1000+"秒");
        //在改进后的代码中，我们将B文件的操作放在了另外一个线程中执行,所以效率可以得到提升。
        // 这是因为我们在A文件读取完成之后，同时开始了A文件的处理和B文件的处理工作。
    }

}
