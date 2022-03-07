package Javase.usuallyclass.time;

import java.util.Date;

public class Time {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        System.out.println(t);

        Date date = new Date();
        System.out.println( date.getTime());

        java.sql.Date date1 = new java.sql.Date(t);
        System.out.println( date1.getTime());

        //date  sql 是 util 的子类
    }
}
