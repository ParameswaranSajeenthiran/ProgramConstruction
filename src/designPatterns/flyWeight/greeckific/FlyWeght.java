package designPatterns.flyWeight.greeckific;

import java.util.*;

public class FlyWeght {

    /*
     * Video Reference: https://youtu.be/qscOsQV-K14
     */
    private static final int BOOK_TYPES = 2;
    private static final int BOOKS_TO_INSERT = 10_000_000;

    public static void main(String[] args) {

        Store store = new Store();
        for (int i = 0; i < BOOKS_TO_INSERT / BOOK_TYPES; i++) {
            store.storeBook(getRandomName(), getRandomPrice(), "Action", "Follett", "Stuff");
            store.storeBook(getRandomName(), getRandomPrice(), "Fantasy", "Ingram", "Extra");
        }
//        store.displayBooks();
        System.out.println(BOOKS_TO_INSERT + " Books Inserted");
        System.out.println("==========================================");
        System.out.println("Memory Usage: ");
        System.out.println("Book Size (20 bytes) * " + BOOKS_TO_INSERT + " + BookTypes Size (30 bytes) * " + BOOK_TYPES + "");
        System.out.println("==========================================");
        System.out.println("Total: " + ((BOOKS_TO_INSERT * 20 + BOOK_TYPES * 30) / 1024 / 1024) + "MB (instead of " + ((BOOKS_TO_INSERT * 50) / 1024 / 1024) + "MB)");
        // Tip: Try to comment out the @ToString annotation in the BookType class and check that indeed the same two objects are being referenced by all our books!

    }

    private static String getRandomName() {
        List<String> books = List.of("book_1", "book_2", "book_3", "book_4", "book_5", "book_6", "book_7", "book_8", "book_9", "book_10");
        return books.get(new Random().nextInt(books.size()));
    }

    private static double getRandomPrice() {
        return new Random().nextDouble();
    }

}

class Book {
    String name;
    double price;

    BookType bookType;


    public Book(String name, double price, BookType bookType) {
        this.name = name;
        this.price = price;
        this.bookType = bookType;
    }
}

class BookType{
    String type;

    String distributor;
    String otherData;


    public BookType(String type, String distributor, String otherData) {
        this.type = type;
        this.distributor = distributor;
        this.otherData = otherData;
    }


}

class FlyWeightFactory{

    public  static  final Map<String,BookType> bookTypes=new HashMap<>();


    public static BookType getBookType(String type,String distributor,String otherData){
        if(bookTypes.get(type)==null){
            return new BookType(type,distributor,otherData);
        }else{
            return bookTypes.get(type);

        }

    }




}

class Store {

    public static  final List<Book> books=new ArrayList<>();

    public void storeBook(String name, double price, String type, String distributor, String otherData) {
        BookType bookType = FlyWeightFactory.getBookType(type, distributor, otherData);
        books.add(new Book(name, price, bookType));
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }
}




