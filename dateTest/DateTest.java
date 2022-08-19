import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws IOException {

        //使用Date创建日期对象
        Date dateNow = new Date();
        System.out.println("当前的日期是------>" + dateNow);

        Date dateYesterday = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //获取昨天日期
        String yesterday = simpleDateFormat.format(dateYesterday)+" 00:00:00";
        System.out.println(yesterday);
        /**
         * 创建格式化时间日期类
         *构造入参String类型就是我们想要转换成的时间形式
         */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(dateNow);
        System.out.println(date);
//        date=date.replace();
//            return date;

//服务器文件路径
//       String parentPath = "/dev/shm/jars/siwei-api/santuheyi/order/";
        String parentPath = "C:/Users/UNICOM/Desktop/";
        //文件名
        String fileName = "orderInfo_"+date+".txt";
        //总路径拼接并返回
        String path = parentPath+fileName;
        System.out.println(path);
//        return path;

        //声明文件名对象及文件输出流
        File file = new File(path);
        if(!file.exists()){
            System.out.println("文件不存在");
            file.createNewFile();
        }
        String word = "hahahahhahahahhah";
        FileOutputStream fileOutputStream = null;
        fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(word.getBytes("gbk"));
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
