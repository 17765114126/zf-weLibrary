# springboot-dubbo-demo
Springboot整合dubbo实例


### SpringBoot整合dubbo系列(一) -- Docker安装ZooKeeper
https://blog.csdn.net/weixin_43841693/article/details/103036716

### SpringBoot整合dubbo系列(二) -- Docker安装dubbo管理控制台 dubbo admin
https://blog.csdn.net/weixin_43841693/article/details/103170207

### SpringBoot整合dubbo系列(三) -- Springboot + Dubbo实例 附GitHub Demo地址
https://blog.csdn.net/weixin_43841693/article/details/103282241

---

#dubbo管理控制台
## ***\**\*\*\*\*\*\*\*window下安装dubbo-admin\*\*\*\*\*\*\*\*\****

dubbo本身并不是一个服务软件。它其实就是一个jar包，能够帮你的java程序连接到zookeeper，并利用zookeeper消费、提供服务。

但是为了让用户更好的管理监控众多的dubbo服务，官方提供了一个可视化的监控程序dubbo-admin，不过这个监控即使不装也不影响使用。

我们这里来安装一下：

**1、下载dubbo-admin**

地址 ：https://github.com/apache/dubbo-admin/tree/master

**2、解压进入目录**

修改 dubbo-admin\src\main\resources \application.properties 指定zookeeper地址

```
server.port=7001
spring.velocity.cache=false
spring.velocity.charset=UTF-8
spring.velocity.layout-url=/templates/default.vm
spring.messages.fallback-to-system-locale=false
spring.messages.basename=i18n/message
spring.root.password=root
spring.guest.password=guest

dubbo.registry.address=zookeeper://127.0.0.1:2181
```

**3、在项目目录下**打包dubbo-admin

```
mvn clean package -Dmaven.test.skip=true
PowerShell窗口中上面语句报错，用下面语句可以
mvn clean package install '-Dmaven.test.skip=true'
```

**第一次打包的过程有点慢，需要耐心等待！直到成功！**


4、执行 dubbo-admin\target 下的dubbo-admin-0.0.1-SNAPSHOT.jar

```
java -jar dubbo-admin-0.0.1-SNAPSHOT.jar
```

【注意：zookeeper的服务一定要打开！】

执行完毕，我们去访问一下 http://localhost:7001/ ， 这时候我们需要输入登录账户和密码，我们都是默认的root-root；

登录成功后，查看界面

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7JJjARRqcZibY4ZPv60renshjHbZUAW6UOLfJhknMjgemFYgr2hz27iaBE4tiaKA86ZqIhOjd3vttV5w/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

安装完成！