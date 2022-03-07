package Javase.usuallyclass.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        SimpleDateFormat sd = new SimpleDateFormat();
        String t = sd.format(new Date().getTime()); // 日期转字符串
        System.out.printf("%s\n", t);
        try {
            Date date = sd.parse(t);
            System.out.println( date); //字符串转换为日期
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 转化为特殊格式的字符串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        System.out.print(simpleDateFormat.format(new Date().getTime()));
    }
}
