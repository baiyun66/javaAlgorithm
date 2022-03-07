package Javase.io.netio;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    //反射之前，对于Person的操作
    @Test
    public void test(){

        //1.创建类的对象
        Person p1 = new Person("jay",21);

        //2.调用对象,调用其内部的属性和方法
        p1.age = 15;
        System.out.println(p1.toString());

//        p1.show();

        //在Person类的外部，不可以通过Person类的对象调用其内部私有的结构。
        //比如：name、showNation以及私有的构造器。

    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Jon",18);
        Person p = (Person) obj;
        System.out.println(p.toString());
        //2.通过反射，调用对象指定的属性和方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);


        System.out.println("+++++++++++++++++++++++++");

        //通过反射，是可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons2 = clazz.getDeclaredConstructor(String.class);
        cons2.setAccessible(true);
        Person p1 = (Person) cons2.newInstance("kalo");
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Taoyao");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"FaceBook");
        //相当于String nation = p1.showNation("FaceBook")
        System.out.println(nation);
    }

/**
 * 疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
 * 建议：直接new的方式。
 * 什么时候会使用：反射的方式。 反射的特征：动态性
 * 疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
 * 不矛盾。
 ————————————————
 版权声明：本文为CSDN博主「lsqstudy」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/PorkBird/article/details/113727678
 **/


}
