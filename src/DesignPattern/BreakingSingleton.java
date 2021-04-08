package DesignPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BreakingSingleton {

    public static void main(String[] args) throws Exception {

//        Singleton s2 = Singleton.getInstance();
//        print("s1", s1);
//        print("s2", s2);
        //Using Reflection
//        Class clazz = Class.forName("DesignPattern.Singleton");
//        Constructor ctor = clazz.getDeclaredConstructor();
//        ctor.setAccessible(true);
//        Singleton s3 = (Singleton) ctor.newInstance();
//        print("s3", s3);
//        Singleton s1 = Singleton.getInstance();
//        Singleton s2 = Singleton.getInstance();
//                print("s1", s1);
//                print("s2", s2);
        //Using Serializable

//        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("abc.ser"));
//        oos.writeObject(s2);
//        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("abc.ser"));
//        Singleton s4= (Singleton) ois.readObject();
//        print("s3", s4);

        //Using Clone
//        Singleton s3= (Singleton) s2.clone();
//       print("s3", s3);

       // Using Multiple Thread Access
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(BreakingSingleton::acess);
        executorService.submit(BreakingSingleton::acess);
        executorService.shutdown();

    }

    public static void acess() {
        Singleton s3 = Singleton.getInstance();
        print("s3", s3);
    }

    static void print(String name, Singleton object) {
        System.out.println(String.format("name:%s,hashcode:%d", name, object.hashCode()));
    }
}
