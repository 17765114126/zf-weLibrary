package study.java提高篇.封装;


/*封装从字面上来理解就是包装的意思，专业点就是信息隐藏，是指利用抽象数据类型将数据和基于数据的操作封装在一起，
使其构成一个不可分割的独立实体，数据被保护在抽象数据类型的内部，尽可能地隐藏内部的细节，只保留一些对外接口使之与外部发生联系。
系统的其他对象只能通过包裹在数据外面的已经授权的操作来与这个封装的对象进行交流和交互。也就是说用户是无需知道对象内部的细节（当然也无从知道），
但可以通过该对象对外的提供的接口来访问该对象。

对于封装而言，一个对象它所封装的是自己的属性和方法，所以它是不需要依赖其他对象就可以完成自己的操作。

使用封装有三大好处：

　1、良好的封装能够减少耦合。

　2、类内部的结构可以自由修改。

　3、可以对成员进行更精确的控制。

　4、隐藏信息，实现细节。*/


/**
 * @ClassName Husband
 * @Author zhaofu
 * @Date 2020/7/24
 * @Version V1.0
 **/
public class Husband {
    /*
     * 对属性的封装
     * 一个人的姓名、性别、年龄、妻子都是这个人的私有属性
     */
    private String name ;
    private String sex ;
    private int age ;
    private Wife wife;

    /*
     * setter()、getter()是该对象对外开发的接口
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
/*从上面两个实例我们可以看出 Husband 里面 wife 引用是没有 getter() 的，同时 wife 的 age 也是没有 getter() 方法的。


所以封装把一个对象的属性私有化，同时提供一些可以被外界访问的属性的方法，如果不想被外界方法，我们大可不必提供方法给外界访问。
但是如果一个类没有提供给外界访问的方法，那么这个类也没有什么意义了。
比如我们将一个房子看做是一个对象，里面的漂亮的装饰，如沙发、电视剧、空调、茶桌等等都是该房子的私有属性，
但是如果我们没有那些墙遮挡，是不是别人就会一览无余呢？没有一点儿隐私！
就是存在那个遮挡的墙，我们既能够有自己的隐私而且我们可以随意的更改里面的摆设而不会影响到其他的。
但是如果没有门窗，一个包裹的严严实实的黑盒子，又有什么存在的意义呢？
所以通过门窗别人也能够看到里面的风景。所以说门窗就是房子对象留给外界访问的接口。

通过这个我们还不能真正体会封装的好处。现在我们从程序的角度来分析封装带来的好处。
如果我们不使用封装，那么该对象就没有 setter() 和 getter()，那么 Husband 类应该这样写：

    public class Husband {
        public String name ;
        public String sex ;
        public int age ;
        public Wife wife;
    }
我们应该这样来使用它：


    Husband husband = new Husband();
            husband.age = 30;
            husband.name = "张三";
            husband.sex = "男";
但是那天如果我们需要修改 Husband，例如将 age 修改为 String 类型的呢？
你只有一处使用了这个类还好，如果你有几十个甚至上百个这样地方，你是不是要改到崩溃。
如果使用了封装，我们完全可以不需要做任何修改，只需要稍微改变下 Husband 类的 setAge() 方法即可。

    public class Husband {

        /*
         * 对属性的封装
         * 一个人的姓名、性别、年龄、妻子都是这个人的私有属性
         */
/*private String name ;
    private String sex ;
    private String age ;    /* 改成 String类型的*/
/*    private Wife wife;

    public String getAge() {
        return age;
    }

    public void setAge(int age) {
        //转换即可
        this.age = String.valueOf(age);
    }
}
    /** 省略其他属性的setter、getter **/


/*
* 其他的地方依然那样引用 (husband.setAge(22)) 保持不变。

到了这里我们确实可以看出，封装确实可以使我们容易地修改类的内部实现，而无需修改使用了该类的客户代码。

我们在看这个好处：可以对成员变量进行更精确的控制。

还是那个 Husband，一般来说我们在引用这个对象的时候是不容易出错的，但是有时你迷糊了，写成了这样：


    Husband husband = new Husband();
            husband.age = 300;
也许你是因为粗心写成了，你发现了还好，如果没有发现那就麻烦大了，逼近谁见过300岁的老妖怪啊！

但是使用封装我们就可以避免这个问题，我们对 age 的访问入口做一些控制 (setter) 如：


    public class Husband {

        /*
         * 对属性的封装
         * 一个人的姓名、性别、年龄、妻子都是这个人的私有属性
         */
/*private String name ;
    private String sex ;
    private int age ;    /* 改成 String类型的*/
/*    private Wife wife;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 120){
            System.out.println("ERROR：error age input....");    //提示錯誤信息
        }else{
            this.age = age;
        }

    }
}
    /** 省略其他属性的setter、getter **/


/**上面都是对 setter 方法的控制，其实通过使用封装我们也能够对对象的出口做出很好的控制。
 * 例如性别我们在数据库中一般都是已1、0方式来存储的，但是在前台我们又不能展示1、0，这里我们只需要在 getter() 方法里面做一些转换即可。


public String getSexName() {
        if("0".equals(sex)){
        sexName = "女";
        }else if("1".equals(sex)){
        sexName = "男";
        }else{
        sexName = "人妖???";
        }
        return sexName;
        }
        在使用的时候我们只需要使用 sexName 即可实现正确的性别显示。同理也可以用于针对不同的状态做出不同的操作。


public String getCzHTML(){
        if("1".equals(zt)){
        czHTML = "<a href='javascript:void(0)' onclick='qy("+id+")'>启用</a>";
        }
        else{
        czHTML = "<a href='javascript:void(0)' onclick='jy("+id+")'>禁用</a>";
        }
        return czHTML;
        }
 */





