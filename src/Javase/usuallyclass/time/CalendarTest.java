package Javase.usuallyclass.time;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();// 抽象类
        System.out.println(calendar.getClass());

        int filed = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.printf("%d\n", filed);

        calendar.set(Calendar.DAY_OF_MONTH,9);
        int filed2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.printf("%d\n", filed2);

        calendar.add(Calendar.DAY_OF_MONTH,-5);
        int filed3 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.printf("%d\n", filed3);


        Date date = calendar.getTime();
        System.out.println(date);

    }
}
