package DesignPattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {

    private String sname;

    private List<Book> bookList=new ArrayList<>();

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "sname='" + sname + '\'' +
                ", bookList=" + bookList +
                '}';
    }

    public void load() {
        for (int i = 0; i < 10; i++) {
            Book bs = new Book();
            bs.setBid(i);
            bs.setBname("book" + i);
            getBookList().add(bs);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
       BookShop bs=new BookShop();
       for(Book s:getBookList()){
           bs.getBookList().add(s);
       }
       return bs;
    }
}
