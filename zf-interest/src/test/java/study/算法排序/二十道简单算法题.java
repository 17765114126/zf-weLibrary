package study.算法排序;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName 二十道简单算法题
 * @Author zhaofu
 * @Date 2021/1/20
 * @Version V1.0
 * @Url:https://mp.weixin.qq.com/s?__biz=MzI4Njg5MDA5NA==&mid=2247484095&idx=1&sn=cf19213517599f45e57dbe783b4d3249&chksm=ebd743bedca0caa85df3d29896fbcc1bfbf8191ad671cceab319180dbf56a0df4d1cfe1eefea&scene=21#wechat_redirect
 * @Url:https://mp.weixin.qq.com/s?__biz=MzI4Njg5MDA5NA==&mid=2247484126&idx=1&sn=109d868fa7bd108af97e8e77dbab3b34&chksm=ebd743dfdca0cac9245a41194ca2b0c8a35f41825a15cb185f883b7b4fdd38b61d74a99ed897&scene=21#wechat_redirect
 *
 **/
public class 二十道简单算法题 {
    /**
     *
     * 总览
     *
     * 1. `1-n`阶乘之和
     * 2. 获取二维数组每列最小的值
     * 3. 求"1！+4！(2的平方)+9！(3的平方)+…+n的值
     * 4. 数组对角线元素之和
     * 5. 打印杨辉三角形
     * 6. 猴子吃桃子问题
     * 7. 计算单词的个数
     * 8. 判断字母是否完全一样
     * 9. 判断一个数是不是2的某次方
     * 10. 判断一个数字是不是ugly number
     * */

    /**
     * 一、1-n阶乘之和
     * 1-n阶乘之和怎么算？
     *
     * 1的阶乘是1
     *
     * 2的阶乘是1*2
     *
     * 3的阶乘是1*2*3
     *
     * 4的阶乘是1*2*3*4
     *
     * ………
     *
     * 现在我们要求这些阶乘的和。
     * 思路：
     *
     * 3阶乘的和其实上就是2阶乘的和+3的阶乘
     *
     * 4阶乘的和其实上就是3阶乘的和+4的阶乘
     * */
    @Test
    public void test1(){
        Factorial(3);
    }
    public static void Factorial(int n) {
        //总和
        double sum = 0;

        //阶乘值，初始化为1
        double factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
            sum = (int) (sum + factorial);
        }
        System.out.println("阶乘的和--------" + "     " + sum);
    }

    /**
     * 二、获取二维数组每列最小的值
     * 获取二维数组每列最小的值
     *
     * 思路：遍历列，再遍历列中行
     *
     * 我们一般操作数组都是从行开始，再到列的。这次要求的是每列的最小值，因此需要在内部for循环遍历的是行
     * */
    @Test
    public void minArray() {
        //二维数组
        int[][] arrays = {
                {23, 106, 8, 234},
                {25, 9, 73, 19},
                {56, 25, 67, 137}
        };
        //获取列数
        int maxColLength = arrays[0].length;
        //使用一个数组来装载每列最小的值
        int[] minArray = new int[maxColLength];
        //控制列数
        for (int i = 0; i < maxColLength; i++) {
            //假设每列的第一个元素是最小的
            int min = arrays[0][i];
            //控制行数
            for (int j = 1; j < arrays.length; j++) {
                //找到最小值
                if (arrays[j][i] < min) {
                    min = arrays[j][i];
                }
            }
            //赋值给装载每列最小的值的数组
            minArray[i] = min;
        }
        System.out.println("二维数组每列最小的值-------------" + "     " + Arrays.toString(minArray));
    }

    /**
     * 三、求"1！+4！(2的平方)+9！(3的平方)+…+n的值
     *
     *  求"1！+4！(2的平方)+9！(3的平方)的值
     *
     * 思路：先求平方，后求阶乘，最后相加即可～
     *
     * */
    @Test
    public void calculate() {
        double sum = 0;
        for (int i = 1; i <= 3; i++) {
            //得到平方数
            int square = i * i;
            //阶乘值，从1开始
            double factorial = 1;
            //求阶乘
            for (int j = 1; j <= square; j++) {
                factorial = factorial * j;
            }
            sum = sum + factorial;
        }
        System.out.println("求1！+4！(2的平方)+9！(3的平方)+…+n的值 ------------" + "     " + sum);
    }

    /**
     *  四、数组对角线元素之和
     *        数组对角线元素之和
     *     思路：
     *
     *     只要行和列相等，即是对角线的元素
     * 数组对角线之和
     */
    @Test
    public void arraySum() {

        int[][] arrays = {
                {23, 106, 8, 234},
                {25, 9, 73, 19},
                {56, 25, 67, 137},
                {33, 22, 11, 44}};
        //和
        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (i == j) {
                    sum = sum + arrays[i][j];
                }
            }
        }
        System.out.println("数组对角线元素之和--------" + sum);
    }


    /**
     * 五、打印杨辉三角形
     * 杨辉三角形
     * 规律：
     *
     * 每行的第一个和最后一个都是1
     * 进一步推算：第1列全部为1，第一行全都是1，当列数等于行数为1
     * 当前值等于头上的值加头上的左边的值
     * 第一行一列，第二行两列，第三行三列…….
     * */
    @Test
    public void PascalTriangle() {
        //打印十行的杨辉三角形
        int[][] arrays = new int[10][];
        //行数
        for (int i = 0; i < arrays.length; i++) {
            //初始化第二层的大小
            arrays[i] = new int[i + 1];
            //列数
            for (int j = 0; j <= i; j++) {

                //是第一列，第一行，行数等于列数，那么通通为1
                if (i == 0 || j == 0 || j == i) {
                    arrays[i][j] = 1;
                } else {
                    //当前值等于头上的值+头上左边的值
                    arrays[i][j] = arrays[i - 1][j] + arrays[i - 1][j - 1];
                }
            }
        }
        System.out.println("---" + "-------------------------------");
        for (int[] array : arrays) {
            for (int value : array) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println("---" + "-------------------------------");
    }

    /**
     * 六、猴子吃桃子问题
     * 猴子摘下了n个桃子，当天吃掉一半多一个，第二天也是吃掉剩下桃子的一半多一个，到了第十天，桃子只剩下了1个。问：猴子第一天摘了多少个桃子
     *
     * 思路：
     *
     * 假设当天有n个桃子，它是前一天桃子的一半少1个，f(n - 1) = f(n)/2 - 1,
     * 我们就可以推出当天桃子的个数：根据递推公式：f(n) = 2 * f(n - 1) + 2
     * 用递归和循环都可解决：
     * */
    @Test
    public void Test2(){
        System.out.println(monkeyQue(10));
        System.out.println(monkeyFor(10));
    }
    /**
     * 猴子吃桃问题(递归方式)
     * @param x 天数
     */
    public static int monkeyQue(int x) {
        if (x <= 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            return 2 * monkeyQue(x - 1) + 2;
        }
    }
    /**
     * 猴子吃桃问题(循环方式)
     */
    public static int monkeyFor(int y) {
        int x = 1;
        for (int i = 1; i <= y; i++) {
            x = (x + 1) * 2;
        }
        return x;
    }

    /**
     *
     * 七、计算单词的个数
     * 输入一段字符，计算出里面单词的个数，单词之间用空格隔开 ,一个空格隔开，就代表着一个单词了
     *
     * 思路：
     *
     * 把字符遍历一遍，累计由空格串转换为非空格串的次数，次数就是单词的个数
     *
     * 定义一个标志性变量flag，0表示的是空格状态，1表示的是非空格状态
     *
     * @param str 一段文字
     */
    public static int countWord(String str) {
        // 0 表示空格状态，1 表示非空格状态
        int flag = 0;
        // 单词次数
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ") ) {
                flag = 0;
            } else if (flag == 0) {
                num++;
                flag = 1;
            }
        }
        return num ;
    }
    @Test
    public void Test3(){
        System.out.println(countWord("n u m b e r"));
    }

    /**
     *
     * 八、判断字母是否完全一样
     * 给定两个字符串s和t，判断这两个字符串中的字母是不是完全一样（顺序可以不一样）
     *
     * 思路：
     *
     * 遍历这两个字符串，用每个字符减去'a'，将其分别存入到数组中去，随后看这两个数组是否相等即可
     *
     * 要点：
     *
     * 'c'-'a'=2即可计算出存储的位置，如果有多个，则+1即可，后面我们来比较数组大小
     *
     *
     * 给定两个字符串s和t，判断这两个字符串中的字母是不是完全一样（顺序可以不一样）
     */
    @Test
    public void isAnagram() {
        //分别存储字符串的字符
        char[] array1 = new char[26];
        char[] array2 = new char[26];

        String s1 = "pleasefollowthewechatpublicnumber";
        String s2 = "pleowcnumberthewechatpubliasefoll";

        for (int i = 0; i < s1.length(); i++) {
            char value = s1.charAt(i);
            // 算出要存储的位置
            int index = value - 'a';
            array1[index]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char value = s2.charAt(i);
            // 算出要存储的位置
            int index = value - 'a';
            array2[index]++;
        }
        for (int i = 0; i < 26; i++) {
            if (array1[i] != array2[i]) {
                System.out.println("不相同");
                return;
            }
        }
        System.out.println("相同");
    }

    /**
     * 九、判断一个数是不是2的某次方
     * 判断一个数是不是2的某次方
     *
     * 思路：
     *
     * 除2取余数，直至余数不为0【针对2的倍数这种情况】，看是不是等于1就可以判断是不是2的某次方了
     */
    @Test
    public void isPowerOfone() {
        int num = 4;
        if (num == 0) {
            System.out.println("不是");
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        if (num == 1) {
            System.out.println("是");
        } else {
            System.out.println("不是");
        }
    }
    /**
     * 这题还有另一种解决方式，就是位运算：
     *
     * 2的n次方都有一个特点，二进制都是1000000
     *
     * 如果 **2的n次方的二进制-1和2的n次方二进制做按位与运算，那么得出的结果肯定是0 **
     * */
    @Test
    public void isPowerOfTwo() {
        int num = 3;
        if(num <= 0){
            System.out.println("不是");
        }
        else if(num == 1){
            System.out.println("是");
        }
        else{
            if( (num & (num-1) ) == 0){
                System.out.println("是");
            }
            else{
                System.out.println("不是");
            }
        }
    }

    /**
     * 十、判断一个数字是不是ugly number
     * 判断一个数字是不是ugly number（分解出来的质因数只有2、3、5这3个数字）
     *
     * 思路：
     *
     * 如果是由2,3,5组成的，那么这个数不断除以2,3,5，最后得出的是1，这个数就是纯粹用2,3,5组成的
     *
     * 跟之前判断该数是否2的某次方是一样的思路～
     * */
    public static void isUgly(int num) {
        if (num <= 0) {
            System.out.println("不是");
        } else {
            while (num % 2 == 0) {
                num = num / 2;
            }
            while (num % 3 == 0) {
                num = num / 3;
            }
            while (num % 5 == 0) {
                num = num / 5;
            }
            if (num == 1) {
                System.out.println("是");
            } else {
                System.out.println("是");
            }
        }
    }

    /**
     * 小总结
     *
     * 1. 其实我觉得这些比较简单的算法是有"套路"可言的，你如果知道它的套路，你就很容易想得出来，如果你不知道它的套路，那么很可能就不会做了(没思路)。
     *
     *    积累了一定的"套路"以后，我们就可以根据**经验**来推断，揣摩算法题怎么做了。
     *
     *    举个很简单的例子：
     *
     *    - 乘法是在加法的基础之上的，那乘法我们是怎么学的？**背(积累)**出来的，`9*9`乘法表谁没背过？
     *    比如看到`2+2+2+2+2`，会了乘法(套路)以后，谁还会慢慢加上去。
     *    看见了5个2，就直接得出`2*5`了
     *
     *    ------
     *
     *    1. `1-n`阶乘之和
     *
     *    - 求n的阶乘就用`1*2*3*4*...n`，实际上就是一个循环的过程，求和就套个sum变量即可！
     *
     *    2. 获取二维数组**每列**最小的值
     *
     *    - **外层循环控制列数，内层循环控制行数**，这就是遍历每列的方法～
     *
     *    3. 求"1！+4！(2的平方)+9！(3的平方)+…+n的值
     *
     *    - **先求平方，再求阶乘，最后套个sum变量**
     *
     *    4. 数组对角线元素之和
     *
     *    - **行和列的位置相等，即是对角线上的元素**
     *
     *    5. 打印杨辉三角形
     *
     *    - **找出杨辉三角形的规律**：第一行、第一列和列值等于行值时上的元素都是1，其余的都是头上的值加头上的左边的值
     *
     *    6. 猴子吃桃子问题
     *
     *    - 根据条件，我们可以推算出前一天桃子，进而推出当天桃子(规律)。
     *          猴子都是在**相等的条件**(剩下桃子的一半多一个)，因此就应该想到**循环或者递归**
     *
     *    7. 计算单词的个数
     *
     *    - 利用每个单词间会有个空格的规律，用变量来记住这个**状态(字母与空格)的转换**，即可计算出单词的个数！
     *
     *    8. 判断字母是否完全一样
     *
     *    - 将每个字母都分别装载到数组里面去，`'c-a'`就是**字母**`c`在**数组的位置**了(也就是2)。由于字母出现的次数不唯一，因此我们**比较的是数组的值**(如果出现了两次，那么值为2，如果出现了3次，那么值为3)。只要用于装载两个数组的值都吻合，那么字母就是一样！
     *
     *    9. 判断一个数是不是2的某次方
     *
     *    - 最佳方案：2的某次方在二进制都有个特点：10000(n个0)--->ps:程序员的整数～……….那么比这个数少一位的二进制肯定是01111，它俩做`&`运算，那么肯定为0。用这个特性就非常好判断该数是否是2的某次方了
     *    - 次方案：2的某次方的数不断缩小(只要`number % 2 == 0`就可以缩小，每次`number / 2`)，最后的**商必然是1。**
     *
     *    10. 判断一个数字是不是ugly number
     *
     *    - 分解出来的质因数只有2、3、5这3个数字，这题其实就是判断该数是否为2的某次方的升级版。将这个数不断缩小(只要`number%2||%3||%5==0`,每次`number / 2 | / 3 /5`)，最后的**商必然是1**
     *
     * */











    /**
     *
     * 题目的总览
     *
     * 删除下标为k的元素
     *
     * 找出常用的数字
     *
     * 丢失的数字
     *
     * 将0放在数组最后
     *
     * 找出数组的单个数字
     *
     * 画三角形星星
     *
     * 罗马数字倒转成阿拉伯数字
     *
     * 啤酒与饮料
     *
     * 简单凯撒密码
     *
     * 求最大公约数
     *
     * */

    /**
     *  一、删除下标为k的元素
     *         删除下标为k的元素
     *
     *   思路：数组后一位往前覆盖即可～
     */
    @Test
    public void deleteK() {

        //固定的常量(比数组元素的个数要大)
        int N = 10;
        int[] arrays = new int[N];
        //对数组进行初始化
        for (int i = 0; i < 8; i++) {
            arrays[i] = i;
        }
        System.out.println("--------" + Arrays.toString(arrays));
        //要删除下标
        int k = 3;
        for (int i = k; i < N - 1; i++) {
            arrays[i] = arrays[i + 1];
        }
        System.out.println("--------" + Arrays.toString(arrays));
    }

    /**
     *
     * 二、找出常用的数字
     * 给你一个长度为n的数组，其中有一个数字出现的次数至少为n/2，找出这个数字
     *
     * 这道题可以用栈的思想来做：
     *
     * 如果栈是空的，那么先把数据存进去
     *
     * 然后继续遍历其他的数据，只要发现栈中的数据和遍历中的数据不一样，那么就出栈
     *
     * 如果是相同的，那么就入栈
     *
     * 其实就是捉住数字出现的次数多于数组一半的长度这里入手。如果这个数出现的次数是大于这个数组长度的2/1，那么最后留下的肯定是这个数
     *
     * */
    public static void findMajorityElement(int[] arrays) {
        //构建一个静态栈
        int[] stack = new int[arrays.length];
        // 栈的front指针
        int front = -1;
        // 遍历给出的数组
        for (int i = 0; i < arrays.length; i++) {
            // 判断该栈为空，那么直接将元素入栈
            if (front == -1) {
                stack[++front] = arrays[i];
            } else if (stack[front] == arrays[i]) { // 该元素是否与栈的元素一致-->继续入栈

                stack[++front] = arrays[i];
            } else {
                // 只要不一致，就出栈
                front--;
            }
        }
        // 只要该数字出现次数大于数组长度的2/1，那么留下来的数字肯定在栈顶中
        System.out.println("--->" + stack[0]);
    }
    @Test
    public void Test5(){
        int[] arrays = new int[10];
        //对数组进行初始化
        for (int i = 0; i < 8; i++) {
            arrays[i] = i;
        }
        findMajorityElement(arrays);
        findMajorityElement2(arrays);
    }
    /**
     *
     * 优化：
     *
     * 其实没必要用整个栈来装载数组，因为我们就使用栈顶元素(出现次数最多的那个),而栈的大小也可以通过一个变量就可以来确定了
     *
     * 只要元素相同->入栈(长度+1)。元素不相同-->出栈(长度-1)
     *
     * 最终留下来的肯定是出现最频繁的那个数字!
     * */
    public static void findMajorityElement2(int[] arrays) {
        // 装载栈的元素
        int candidate = -1;
        // 栈的大小(长度)
        int count = 0;
        // 遍历给出的数组
        for (int i = 0; i < arrays.length; i++) {
            // 判断该栈为空，那么直接将元素入栈
            if (count == 0) {
                candidate = arrays[i];
                count++;
            } else if (candidate == arrays[i]) { // 该元素是否与栈的元素一致-->入栈(栈多一个元素)
                count++;
            } else {
                // 只要不一致-->出栈(栈少一个元素)
                count--;
            }
        }
        // 只要该数字出现次数大于数组长度的2/1，那么留下来的数字肯定在栈顶中
        System.out.println("--->" + candidate);
    }

    /**
     * 三、丢失的数字
     * 给你一个数组{0,1,2,3,….n}，其中有一个数字缺失，请把缺失的数字找出来
     *
     * 思路：
     *
     * 创建一个数组(题目数组的长度+1，因为题目的数组缺失了一个)
     *
     * 创建的数组元素用特殊的符号(数字)来进行填满
     *
     * 将题目给出的数组遍历并填充到创建的数组上，用index(0,1,2,3..)替代
     *
     * 最后遍历创建的数组，哪个还是特殊的符号就是缺失的数字，返回index(缺失的数字)即可
     *
     * @param arrays
     */
    public static void missingNumber(int[] arrays) {
        // 定义要填充到新数组的数字(随意)
        int randomNumber = 89898980;
        // 创建一个新的数组(比已缺失的数组多一个长度)
        int[] newArrays = new int[arrays.length + 1];
        // 填充特殊的数字进新数组中
        for (int i = 0; i < newArrays.length; i++) {
            // 随意填充数组到新数组中
            newArrays[i] = randomNumber;
        }
        // 遍历题目的数组并使用index替代掉新数组的元素
        for (int i = 0; i < arrays.length; i++) {
            // 题目数组的值[0,1,2,3,4,...n]其中有一个缺失
            int index = arrays[i];
            // 重新填充到新数组上，index对应着题目数组的值
            newArrays[index] = 3333333;
        }
        // 遍历新数组，只要还有值为89898980，那么那个就是缺失的数字
        for (int i = 0; i < newArrays.length; i++) {
            if (newArrays[i] == randomNumber) {
                System.out.println("1---->缺失的数字是：" + i);
            }
        }
    }

    @Test
    public void Test6(){
        int[] arrays = new int[10];
        //对数组进行初始化
        for (int i = 0; i < 8; i++) {
            arrays[i] = i;
        }
        missingNumber(arrays);
        missingNumber2(arrays);
    }
    /**
     *
     * 优化：
     *
     * 题目给出的数组{0,1,2,3,4,5,....n}其中缺失一个数字，要把缺失的数字找出来…我们可以回顾一下高中学过的等差求和公式:Sn=(a1+an)n/2
     *
     * 图片
     * 假设我们没有缺失数字，等差求和公式可以快速得出答案。
     * 比如：{0,1,2,3}--->(0+3)*4/2--->6，
     * 如果此时缺失的是2呢，就是说题目的给出的数组是:{0,1,3}，我们利用等差公式求和之后减去数组每个元素，最后剩下的数就是缺失的数字！6-1-3-0--->2
     *
     * */
    public static void missingNumber2(int[] arrays) {
        // 套用等差求和公式
        int sum = (arrays[0] + arrays[arrays.length - 1]) * (arrays.length + 1) / 2;
        // 遍历数组，得出的sum减去数组每一位元素，最后即是缺失的数字
        for (int value : arrays) {
            sum = sum - value;
        }
        System.out.println("2---->缺失的数字是：" + sum);
    }


    /**
     * 四、将0放在数组最后
     * 将一个数组的元素，其中是0的，放在数组的最后
     *
     * 思路：
     *
     * 使用一个变量zero来记住该数组有多少个0
     *
     * 遍历这个数组，如果发现不是0的，就往数组前面移动，如果发现是0就zero++
     *
     * 数组移动的位置刚好是arr[i-zero]的
     *
     * @param arrays
     */
    public static void moveZero(int[] arrays) {
        // 记录该数组有多少个0元素
        int zero = 0;
        for (int i = 0; i < arrays.length; i++) {
            // 只要元素不为0，那么就往前面移动
            if (arrays[i] != 0) {
                arrays[i - zero] = arrays[i];
            } else {
                // 如果为0，那么zero ++
                zero++;
            }
        }
        // 1. 前面已经将非0的元素移动到数组的前面了
        // 2. 将为0的元素填满数组，填充的位置就从length - zero开始
        int j = arrays.length - zero;
        while (j < arrays.length) {
            arrays[j] = 0;
            j++;
        }
        System.out.println("---->" + Arrays.toString(arrays));
    }
    @Test
    public void Test7(){
        int[] arrays = new int[10];
        //对数组进行初始化
        for (int i = 0; i < 8; i++) {
            arrays[i] = i;
        }
        moveZero(arrays);
        moveZero2(arrays);
    }
    /**
     * 还可以换种思路(差别不大)：将数组分成几个部分：在j之前的没有0，j到i全是0，i后面还没有遍历
     *
     * 如果遍历到的数字不是0，那么跟j进行交换，j++(保证j前面没有0和j到i全是0)
     *
     * 直至i遍历完毕后，j前面都不是0，j-i都是0(这就完成我们的任务了)
     * */
    public static void moveZero2(int[] arrays) {
        // 在j前面的元素都不是0
        int j = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != 0) {
                // 跟j进行交换，保证j的前面都不是0
                int temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j]  = temp;

                j++;
            }
        }
        // 直至i遍历完毕后，j前面都不是0，j-i都是0(这就完成我们的任务了)
        System.out.println("---->" + Arrays.toString(arrays));
    }


    /**
     * 找出数组的单个数字
     * @param nums
     * @return
     */
    public static void singleNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int count = countNumber(nums, nums[i]);


            // 如果该元素只出现一次，那么就是它了！
            if (count == 1) {
                System.out.println("关注公众号：Java3y--->单一的元素是：" + nums[i]);

                return ;


            }


        }
    }

    /**
     * 五、找出数组的单个数字
     * 给你一个数组，除了一个数字外，其他的数字都出现了两次，请把这个只出现一次的数字找出来。
     *
     * 思路：
     *
     * 将该数组遍历一次，记录每个数字出现的次数
     *
     * 如果该数字出现的次数只有1，那么该数字就是单个数字～
     *
     * @param nums 数组
     * @param value 想知道出现次数的元素
     */

    public static int countNumber(int[] nums,int value) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (value == nums[i]) {
                count++;
            }
        }
        // 返回该元素出现的次数
        return count;
    }

    /**
     *
     *     优化：
     *
     *     这个问题最佳的解法是用到了位运算的异或操作：
     *
     *     如果5^5=0
     *
     *     如果5^7^5 = 7
     *
     *     如果5^6^6^5^7^8^7 = 8
     *
     *     从上面的例子可以看出：一堆数字做异或运算^，俩俩相同数字就会被抵消掉～，所以这个特性对于这个题目而言就再适合不过的了：
     *
     * 找出数组的单个数字
     * @param nums
     * @param numsSize
     * @return
     */
    public static int singleNumber(int[] nums, int numsSize) {

        // 第一个数和数组后面的数做^运算，留下的必然是单个数字
        int k = nums[0];
        for (int i = 1; i < numsSize; i++) {
            k = (k ^ nums[i]);
        }
        return k;
    }

}
