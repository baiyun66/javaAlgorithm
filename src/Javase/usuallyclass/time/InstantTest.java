package Javase.usuallyclass.time;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTest {

    public static void main(String[] args) {

        // 本初子午线获标准的时间点
        Instant instant = Instant.now();
        System.out.println(instant);


        // 偏移到对应的时区
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);


        //获取时间戳
        System.out.println(instant.toEpochMilli());

    }
}
