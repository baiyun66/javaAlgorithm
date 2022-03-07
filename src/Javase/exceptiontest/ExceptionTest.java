package Javase.exceptiontest;

import org.junit.Test;


/*
获取异常
    1 try catch finally
    2 throw Exception
抛出异常
    3 throw new Exception
自定义异常类
    4 extends Exception , static final long serialVersionUID = XXXXXXX,   super(msg)
 */

public class ExceptionTest {

    @Test
    public void test1(){
        try {
            int a= 0;
            int b = 10/a;
//            test2();
        }catch (ArithmeticException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }


    @Test
    public void test3(){
        try {
            test2();
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("解决ArithmeticException");
        }catch (Exception e){
           e.printStackTrace();
            System.out.println("解决Exception");
        } finally {
            System.out.println("最终解决");
        }
    }
    public void test2() throws ArithmeticException{
            int a= 0;
            int b = 10/a;
//        int [] a = {1,2,3};
//        a[10] = 5;


    }

    @Test
    public void test6(){
        try {
            test5();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test5() throws Exception {
        int a=2;
       if(a>1){
//           throw new RuntimeException("运行时错误！");
//           throw new ArithmeticException("错误！");
           throw new MyException("自定义错误！");
       }
    }

    @Test
    public void test7(){
        try {
            test5();
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println("使用自己的异常类");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    class MyException extends Exception{
        static final long serialVersionUID = 4551121112365665444L;
        public MyException(){

        }
        public MyException(String msg){
            super(msg);
        }
    }

}
