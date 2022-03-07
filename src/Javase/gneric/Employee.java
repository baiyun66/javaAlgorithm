package Javase.gneric;

public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        System.out.println("compareTo");
        if(this.name.compareTo(o.name)!=0){
            return this.name.compareTo(o.name);
        }
        return this.birthday.compareTo(o.birthday);
    }
}
