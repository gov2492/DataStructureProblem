package DesignPattern.factory;

public class App {
    public static void main(String[] args) {
        FactoryClass factoryClass = new FactoryClass();
        OS os = factoryClass.getInstance(Type.IOS);
        os.spec();
    }
}
