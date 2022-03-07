package Javase.gneric;

import leetcode.AlgorithmBasis.Tree;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

public class GenericTest {

    @Test
    public void test1(){
        HashMap<String,Integer> job= new HashMap<>();
        job.put("刘欢",20);
        job.put("张三",19);

        Set<Map.Entry<String, Integer>> entrySet = job.entrySet();

        Iterator<Map.Entry<String,Integer>> iterator = entrySet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        TreeSet<Employee> treeSet = new TreeSet<>();
        treeSet.add(new Employee("jack",28,new MyDate(1998,10,10)));
        treeSet.add(new Employee("marry",20,new MyDate(1992,11,10)));
        treeSet.add(new Employee("tom",19,new MyDate(1980,10,4)));
        treeSet.add(new Employee("jack",21,new MyDate(1998,10,9)));
        treeSet.add(new Employee("hali",10,new MyDate(1950,2,10)));

        Iterator<Employee> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        TreeSet<Employee> treeSet = new TreeSet<>();
        treeSet.add(new Employee("jack",28,new MyDate(1998,10,10)));
        treeSet.add(new Employee("marry",20,new MyDate(1992,11,10)));
        treeSet.add(new Employee("tom",19,new MyDate(1980,10,4)));
        treeSet.add(new Employee("jack",21,new MyDate(1998,10,9)));
        treeSet.add(new Employee("jack",21,new MyDate(1997,10,9)));
        treeSet.add(new Employee("hali",10,new MyDate(1950,2,10)));

        Iterator<Employee> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }



    @Test
    public void test4(){
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                LocalDate date1 = LocalDate.of(o1.getBirthday().getYear(),o1.getBirthday().getMonth(),o1.getBirthday().getDay());
                LocalDate date2 = LocalDate.of(o2.getBirthday().getYear(),o2.getBirthday().getMonth(),o2.getBirthday().getDay());
                return date1.compareTo(date2);
            }
        };
        TreeSet<Employee> treeSet = new TreeSet<Employee>(comparator);
        treeSet.add(new Employee("jack",28,new MyDate(1998,10,10)));
        treeSet.add(new Employee("marry",20,new MyDate(1992,11,10)));
        treeSet.add(new Employee("tom",19,new MyDate(1980,10,4)));
        treeSet.add(new Employee("jack",21,new MyDate(1998,10,9)));
        treeSet.add(new Employee("jack",21,new MyDate(1997,10,9)));
        treeSet.add(new Employee("hali",10,new MyDate(1950,2,10)));


        Iterator<Employee> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
