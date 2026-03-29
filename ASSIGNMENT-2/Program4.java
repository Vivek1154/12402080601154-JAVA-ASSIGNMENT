import java.util.*;

// Book class implementing Comparable
class Book implements Comparable<Book> {
    int id;
    String title;
    double price;

    Book(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int compareTo(Book b) {
        return this.title.compareTo(b.title);
    }

    public String toString() {
        return id + " " + title + " " + price;
    }
}


class PriceComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        return Double.compare(b1.price, b2.price);
    }
}

public class Program4 {
    public static void main(String[] args) {

        ArrayList<Book> list = new ArrayList<>();

        list.add(new Book(1, "Java", 500));
        list.add(new Book(2, "Python", 300));
        list.add(new Book(3, "C++", 400));

        System.out.println("Before Sorting:");
        for (Book b : list) {
            System.out.println(b);
        }

        Collections.sort(list);
        System.out.println("\nSorted by Title (Comparable):");
        for (Book b : list) {
            System.out.println(b);
        }

        Collections.sort(list, new PriceComparator());
        System.out.println("\nSorted by Price (Comparator):");
        for (Book b : list) {
            System.out.println(b);
        }
    }
}
