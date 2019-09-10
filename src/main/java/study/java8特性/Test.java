package study.java8特性;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName Test
 * @Author zhaofu
 * @Date 2019/8/7
 * @Version V1.0
 **/

class User {
    private int id;
    private String name;
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
}

public class Test {
    public static void main(String[] args) {
//        现在有一个List<User> 的集合，如何把这个list转换成Map<Integer, User> 其中，key是user id，value是User对象
//        代码如下：
        List<User> users = Arrays.asList(new User(1, "Tomcat"), new User(2, "Apache"), new User(3, "Nginx"));
        Map<Integer, User> map = users.stream().collect(Collectors.toMap(obj -> obj.getId(), obj -> obj));
        System.out.println(map);
//        或者使用方法的引用
        Map<Integer, User> map4 = users.stream().collect(Collectors.toMap(User::getId, obj -> obj));
//        示例二：
//        有如下List<Map<String, String>>
        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> map1 = new HashMap<>();
        map1.put("id", "101");
        map1.put("name", "Tomcat");

        Map<String, String> map2 = new HashMap<>();
        map2.put("id", "102");
        map2.put("name", "Apache");

        Map<String, String> map3 = new HashMap<>();
        map3.put("id", "103");
        map3.put("name", "Nginx");

        list.add(map1);
        list.add(map2);
        list.add(map3);
//        如何把list中的每个map中的id取出来，转换成list<String>
//        参考代码如下：
        List<String> ids = list.stream().map(entity -> entity.get("id")).collect(Collectors.toList());
        System.out.println(ids);
//        或者
        List<Object> ids3 = Arrays.asList(list.stream().map(entity -> entity.get("id")).toArray());
//        示例三：
//        如何把url的请求参数（如：type=1&from=APP&source=homePage）转换成Map<String, String>
//        参考代码：
        String queryString = "type=1&from=APP&source=homePage";
        Map<String, String> map5 = Stream.of(queryString.split("&")).map(obj -> obj.split("=")).collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
        System.out.println(map5);
//        示例四：
//        把List<String> 转换成List<Integer >
                List < String > strs = Arrays.asList("1", "2", "3");
        List<Integer> ints = strs.stream().map(obj -> Integer.valueOf(obj)).collect(Collectors.toList());
    }
}
