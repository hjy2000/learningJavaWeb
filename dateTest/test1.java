import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {
    public static void test()
    {
        // 按指定模式在字符串查找
        String line = "192.168.0.1";
        String ipPattern = "^([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}$";

        // 创建 ipPattern 对象
        Pattern ip = Pattern.compile(ipPattern);

        // 创建 matcher 对象
        Matcher m = ip.matcher(line);

        System.out.println(m.matches());

    }

    public static void main(String[] args) {
        test();
    }
}
