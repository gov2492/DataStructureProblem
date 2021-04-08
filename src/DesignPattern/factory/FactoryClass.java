package DesignPattern.factory;

public class FactoryClass {
    public OS getInstance(Type type) {
        if (type.equals(Type.ANDROID)) {
            return new Android();
        } else if (type.equals(Type.IOS)) {
            return new IOS();
        } else {
            return new Windows();
        }
    }
}
