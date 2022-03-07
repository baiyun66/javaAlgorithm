package Javase.usuallyclass.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeTest {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localTime);
        System.out.println(localDate);
        System.out.println(localDateTime);

        //of 设置指定的时分秒，没有偏移量

        localDateTime = LocalDateTime.of(2022,1,21,10,20,50,40);
        System.out.println(localDateTime);

        //getXXX,获取相应的属性值

        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMinute());

        //withXXX  修改，不可变性，返回的是新的对象，原来的对象值不变。
        System.out.println(localDateTime.withDayOfYear(19));
        //plus
        System.out.println(localDateTime.plusDays(2));



        // local时间的转换字符串，字符串转换local时间

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(dateTimeFormatter);
        System.out.println(dateTimeFormatter.format(localDateTime));

//        System.out.println(dateTimeFormatter.parse("时间字符串"));


        //  自定义转换为的格式

        dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY:MM:dd hh:mm:ss");

        System.out.println(dateTimeFormatter.format(localDateTime));

    }
}
