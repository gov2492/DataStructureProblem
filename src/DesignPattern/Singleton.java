package DesignPattern;

import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {
    //   static Singleton soleInstance = new Singleton();//Eager Loading
    static volatile Singleton soleInstance = null;

    private Singleton() {
        if (soleInstance != null) {
            throw new RuntimeException("Please use getInstance");
        }
    }

    protected Object readResolve() throws ObjectStreamException {
        System.out.println("Read Resolve");
        return soleInstance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // return super.clone();
        throw new RuntimeException("don't clone Singleton");
    }

    public static Singleton getInstance() {

        if (soleInstance == null) {
            soleInstance = new Singleton();
        }
        return soleInstance;
    }
}
