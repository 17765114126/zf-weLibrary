package Test;

/**
 * @ClassName LogInTest
 * @Author zhaofu
 * @Date 2020/8/24
 * @Version V1.0
 **/
public class LogInTest {

//    同时支持手机号、用户名、邮箱登录


    public static void main(String[] args) {

//String e = "257@qq.com";

        String e = "15315315326@163.com";

        String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

//String ph = " ^[1][358][0-9]{9}$";

        String ph = "^[1][3578]\\d{9}$";

//Pattern pemail = Pattern.compile("em");

        System.out.println(e.matches(em));

        System.out.println(e.matches(ph));

        if (e.matches(em)) {//邮箱登录

            System.out.println("邮箱");

        } else if (e.matches(ph)) {//手机号登录

            System.out.println("手机号");

        } else {//就是用户名登录

            System.out.println("用户名");

        }

//    项目中的使用：

//判断用户的登录方式

//        String loginmethod = webParams.reqString("phone");
//
//        String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
//
//        String ph = "^[1][3578]\\d{9}$";
//
//        if (loginmethod.matches(em)) {//邮箱登录
//
//            userGetMap.put("email", loginmethod);
//
//        } else if (loginmethod.matches(ph)) {//手机号登录
//
//            userGetMap.put("phone", webParams.reqString("phone"));
//
//        } else {//就是用户名登录
//
//            userGetMap.put("username", webParams.reqString("phone"));
//
//        }
//
//        DbResultMap userObj = dao.selectObj(UserBiz.USER_GET, userGetMap);
    }


}
