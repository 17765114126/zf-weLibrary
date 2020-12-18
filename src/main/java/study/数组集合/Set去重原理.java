package study.数组集合;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Set去重原理
 * @Author zhaofu
 * @Date 2019/12/12
 * @Version V1.0
 **/
public class Set去重原理 {

//     Java Set对象去重
//
//     展开
//     我们可以知道Set集合是没有重复数据的特性，那么对于元素为对象 的情况是否也同样奏效？可以看一下。举一个例子：
//
//     SetTest.java：

    class VO {
        private String name;
        private String addr;

        public VO(String name, String addr) {
            this.name = name;
            this.addr = addr;
        }

        @Override
        public String toString() {
            return "name: " + name + " addr:" + addr;
        }
    }

    public static void main(String[] args) {

    }

    public void testSet() {

        Set<VO> vos = new HashSet<>();

        VO vo = new VO("wahaha", "sh");

        VO vo1 = new VO("wahaha", "bj");

        VO vo2 = new VO("wahaha", "sh");

        vos.add(vo);
        vos.add(vo1);
        vos.add(vo2);

        for (VO item : vos) {
            System.out.println(item.toString());
        }
    }
//     结果为：
//
//     name: wahaha addr:sh
//     name: wahaha addr:bj
//     name: wahaha addr:sh
//     可见，对于各个字段值都相同的对象，并没有做去重操作。为什么呢，看一下JDK1.8中HashSet的数据结构：

//     HashSet.java:

//     实例化对象：

    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
     * default initial capacity (16) and load factor (0.75).
     */
    /**
     * public HashSet() {
     * map = new HashMap<>();
     * }
     * 可见new HashSet()操作实际上是new HashMap<>()，可见底层是以HashMap来实现的。
     * <p>
     * HashSet.add方法：
     */
//    public boolean add(E e) {
//        return map.put(e, PRESENT)==null;
//    }
//    HashMap.add方法：

//    public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//    }

//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                   boolean evict) {
//        Node<K,V>[] tab; Node<K,V> p; int n, i;
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;
//        if ((p = tab[i = (n - 1) & hash]) == null)
//            tab[i] = newNode(hash, key, value, null);
//        else {
//            Node<K,V> e; K k;
//            if (p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k))))
//                e = p;
//            else if (p instanceof TreeNode)
//                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//            else {
//                for (int binCount = 0; ; ++binCount) {
//                    if ((e = p.next) == null) {
//                        p.next = newNode(hash, key, value, null);
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
//    可以从上面的加粗字段看出，判断插入的key是否存在，要判断两点
//    ①hash值是否相同；
//    ②对应的值是否相同，前者要看hashCode()方法，后者要看equal()方法。
//    下面我们来探索一下基本的数据类型和自定义类类型在计算hashCode和equal的区别，
//    看一下如下代码

    class VO1 {
        private String name;
        private String addr;

        public VO1(String name, String addr) {
            this.name = name;
            this.addr = addr;
        }

        @Override
        public String toString() {
            return "name: " + name + " addr:" + addr;
        }
    }

    public void testSet1() {

        Set<VO1> vos = new HashSet<>();

        VO1 vo = new VO1("wahaha", "sh");
        VO1 vo1 = new VO1("wahaha", "bj");
        VO1 vo2 = new VO1("wahaha", "sh");

        Integer a = 2;
        Integer b = 2;

        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println(a.equals(b));
        System.out.println(str1.equals(str2));
        System.out.println(vo.equals(vo2));

        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(str1.hashCode() == str2.hashCode());
        System.out.println(vo.hashCode() == vo2.hashCode());

        vos.add(vo);
        vos.add(vo1);
        vos.add(vo2);

        for (VO1 item : vos) {
            System.out.println(item.toString());
        }
    }
//    结果为：
//
//            true
//            true
//            false
//            true
//            true
//            false
//    name: wahaha addr:sh
//    name: wahaha addr:sh
//    name: wahaha addr:bj
//java.lang.Integer.equals()：两个对象对应的值一致则返回true。

//    public boolean equals(Object obj) {
//        if (obj instanceof Integer) {
//            return value == ((Integer)obj).intValue();
//        }
//        return false;
//    }
//java.lang.String.equals()：两个字符串对应的值一致则返回true：

//    public boolean equals(Object anObject) {
//        if (this == anObject) {//同一个对象，必定是一致的
//            return true;
//        }
//        if (anObject instanceof String) {
//            String anotherString = (String)anObject;
//            int n = value.length;
//            if (n == anotherString.value.length) {//对比每一个字符
//                char v1[] = value;
//                char v2[] = anotherString.value;
//                int i = 0;
//                while (n-- != 0) {
//                    if (v1[i] != v2[i])
//                        return false;
//                    i++;
//                }
//                return true;
//            }
//        }
//        return false;//anObject不是String实例，那么返回false
//    }
//java.lang.Object.equals()：两个对象的引用是否一致，即两个的对象是否是同一个。
//    public boolean equals(Object obj) {
//        return (this == obj);
//    }
//可见对于java.lang.Object.equals()来讲，两个new出来的对象肯定是不一致的，那么在HashMap数据结构中不会被判定成相同的对象（尽管值相同）。
// 下面再看看hashCode的源码：

//            java.lang.Integer.hashCode():

//    @Override
//    public int hashCode() {
//        return Integer.hashCode(value);
//    }

    public static int hashCode(int value) {
        return value;
    }
//java.lang.String.hashCode():
//    public int hashCode() {
//        int h = hash;
//        if (h == 0 && value.length > 0) {
//            char val[] = value;
//
//            for (int i = 0; i < value.length; i++) {
//                h = 31 * h + val[i];
//            }
//            hash = h;
//        }
//        return h;
//    }
//java.lang.Object.hashCode():

//    public native int hashCode();
//    JDK8的默认hashCode的计算方法是通过和当前线程有关的一个随机数+三个确定值，运用Marsaglia's xorshift schema随机数算法得到的一个随机数。
//
//    因此，以上可以看到Integer和String也都是根据具体的value值来计算hashCode，
// 那么尽管两个引用不同但是值相同的对象，依然是想等的，但是Object则不同了。
//
//    知道了原因，解决方法就简单了，那就是重载VO类的equals和hashCode方法，代码如下：
//
//    SetTest.java：

    class VO2 {
        private String name;
        private String addr;

//        public  vo(String name, String addr) {
//            this.name = name;
//            this.addr = addr;
//        }

        @Override
        public String toString() {
            return "name: " + name + " addr:" + addr;
        }

        /**
         * 如果对象类型是User,先比较hashcode，一致的场合再比较每个属性的值
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (this == obj)
                return true;
            if (obj instanceof VO) {
                VO vo = (VO) obj;

                // 比较每个属性的值 一致时才返回true
                if (vo.name.equals(this.name) && vo.addr.equals(this.addr))
                    return true;
            }
            return false;
        }

        /**
         * 重写hashcode 方法，返回的hashCode不一样才再去比较每个属性的值
         */
        @Override
        public int hashCode() {
            return name.hashCode() * addr.hashCode();
        }
    } // class


    public void testSet2() {

        Set<VO> vos = new HashSet<>();

        VO vo = new VO("wahaha", "sh");
        VO vo1 = new VO("wahaha", "bj");
        VO vo2 = new VO("wahaha", "sh");

        vos.add(vo);
        vos.add(vo1);
        vos.add(vo2);

        for (VO item : vos) {
            System.out.println(item.toString());
        }

    }
//    结果：
//    name: wahaha addr:sh
//    name: wahaha addr:bj
//    在阿里巴巴Java开发是手册的集合处理中需要强制遵循如下规则：
//
//            1)只要重写equals，就必须重写hashCode；
//
//            2)因为Set存储的是不重复的对象，依据hashCode和equals进行判断，所以Set存储的对象必须重写这两个方法。
//
//            3)如果自定义对象做为Map的键，那么必须重写hashCode和equals。
//
//    正例：String重写了hashCode和equals方法，所以我们可以非常愉快的使用String对象作为key来使用。

}
