package Javase.usuallyclass.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest {
    @Test
    public void test1(){

        // 重写compareTo
        // 返回整数<0 >0 ==0  为对象和另一个对象的大小
        String[] arr = {"cc","ab","AZ","gd","jj"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){

        //自然排序，实现compare接口重写compareTo
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("小米",1000);
        arr[1] = new Goods("华为",1200);
        arr[2] = new Goods("联想",700);
        arr[3] = new Goods("oppo",2000);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3(){
        // 定制排序，在类外面自定义排序，一次性的
        String[] arr = {"cc","ab","AZ","gd","jj"};
        Arrays.sort(arr,
                new Comparator(){
                    @Override
                    public int compare(Object o1, Object o2) {
                        if(o1 instanceof String && o2 instanceof String){
                            String s1 =(String) o1;
                            String s2 = (String) o2;
                            return -s1.compareTo(s2);
                        }
                        throw new RuntimeException("两个类型不一样");
                    }
                });
        System.out.println(Arrays.toString(arr));

    }
}
