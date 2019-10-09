package com.example.springboot.Controller.activemq;

/**
 * @ClassName 介绍
 * @Author zhaofu
 * @Date 2019/10/9
 * @Version V1.0
 **/
public class 介绍 {
    /**
     * 参考地址： https://www.cnblogs.com/lzylcf/p/9381446.html
     *
     * 更详细的一篇文章：https://blog.csdn.net/cs_hnu_scw/article/details/81040834
     * */

    /**
     * 运行前准备
     *
     *
     * 从官网中下载activeMQ，下载地址：http://activemq.apache.org/download.html
     *
     * 解压后，打开目录下的bin，根据自己的系统选择win32或win64安装Active服务，并开启activeMQ
     *
     * 开启后浏览器访问该地址：http://127.0.0.1:8161/，选择 Manage ActiveMQ broker，输入账号密码，默认都是admin
     *
     *
     *创建一个maven项目，在pom.xml文件中引入jar包
     *
     * <dependency>
     *     <groupId>org.apache.activemq</groupId>
     *     <artifactId>activemq-all</artifactId>
     *     <version>5.9.0</version>
     * </dependency>
     * */


    /**ActiveMQ介绍
     *
     * ActiveMQ是一种消息中间件，有两种模式，
     * 一种点对点模式 发布者将发布的消息发送给服务器，等待用户监听并接受数据；
     * 第二种订阅模式 发布者将消息发布给消息服务器，让服务器将所有的数据直接转发给再监听的用户，进行一对多通信（类似微信公众号）。
     * ActiveMQ主要是为了降低程序间的耦合，以及异步执行处理时间较长的代码（如网络通信）。

     * 点对点模式：

     * 发布者发布8条信息，这时有3个用户在监听服务器消息，则3个用户共同消费这8条消息。服务器中的每条消息只能被一个用户消费，
     * 这种模式服务器会存储发布者发布的数据，当未被用户接收的数据则会留在服务器中，等待下个监听服务器的用户接收数据。

     * 订阅模式（持久订阅模式/非持久订阅模式）：
     *
     * 发布者发布消息给消息服务器，消息服务器则将消息直接转发给监听的用户，
     * 这要求发布者发布消息的同时用户也在监听消息，若没有用户监听， 则不保留数据，认为数据已发送完成。
     * 也就是发布者发布时，用户没在监听消息，则不会在收到该数据。即使用户以后再监听也接收不到
     * */
}
