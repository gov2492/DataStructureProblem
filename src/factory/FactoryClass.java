package factory;

public class FactoryClass {

    public static Vehicle getInstance(String name){
        if(name.equals("Bike")){
            return new Bike();
        }
        else{
            return null;
        }
    }
}
