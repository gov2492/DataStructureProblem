package DesignPattern.prototype;

public class ProtypeMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop bs=new BookShop();
        bs.setSname("shop1");
        bs.load();
         BookShop bs1= (BookShop) bs.clone();
         bs.getBookList().remove(2);
        System.out.println(bs);

        System.out.println(bs1);
    }
}
