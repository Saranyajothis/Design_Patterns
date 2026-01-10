package Behavioral;

class Book{
    private String name;

    public Book(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

interface Iterator<T>{
    boolean hasNext();
    T next();
}

interface Container<T>{
    Iterator<T> getIterator();
}

class BookCollection implements Container<Book>{
    private Book[] books;
    private int index = 0;

    public BookCollection(int size){
        books = new Book[size];
    }

    public void addBook(Book book){
        if(index < books.length){
            books[index++] = book;
        }
    }

    @Override
    public Iterator<Book> getIterator() {
        return new BookIterator();
    }

    private class BookIterator implements Iterator<Book>{
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        public Book next() {
            return books[currentIndex++];
        }
    }

}
    
public class IteratorMain {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection(3);
        collection.addBook(new Book("Book One"));
        collection.addBook(new Book("Book Two"));
        collection.addBook(new Book("Book Three"));

        Iterator<Book> iterator = collection.getIterator();
        while(iterator.hasNext()){
            Book book = iterator.next();
            System.out.println("Book Name: " + book.getName());
        }
    }
}
