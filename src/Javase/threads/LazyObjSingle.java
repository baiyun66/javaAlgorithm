package Javase.threads;

import java.util.concurrent.SynchronousQueue;

public class LazyObjSingle {
    public static void main(String[] args) {

    }
}

// 懒汉式单例模式
class CreatObj{
    private static CreatObj creatObj=null;

//    public static synchronized CreatObj getInstance(){
    public static  CreatObj getInstance(){

        synchronized(CreatObj.class){
        if(creatObj==null) {
            creatObj = new CreatObj();
        }
        }
        return creatObj;
    }

}
