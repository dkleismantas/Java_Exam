package lt.techin.library.pt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookCatalogDainiusK implements BookCatalog {

    List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        if (book == null ||
                book.getIsbn() == null ||
                book.getIsbn().isEmpty() ||
                book.getTitle() == null ||
                book.getTitle().isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (Book i : books) {
            if (i.getIsbn().equals(book.getIsbn())) {
                return;
            }
        }
        books.add(book);
    }

    @Override
    public int getTotalNumberOfBooks() {
        return books.size();
    }

    @Override
    public void printBookTitles() {
        for (Book i : books) {
            System.out.println(i.getTitle());
        }
    }

    @Override
    public void printTitlesOfBooksPublishedAfter(int i) {
        for (Book j : books) {
            if (j.getPublicationYear() > i) {
                System.out.println(j.getTitle());
            }
        }
    }

    @Override
    public Book getBookByIsbn(String s) {
        Book whichIsNeeded = null;
        for (Book i : books) {
            if (i.getIsbn().equals(s)) {
                whichIsNeeded = i;
            }
        }
        if (whichIsNeeded == null) throw new BookNotFoundException("");
        return whichIsNeeded;
    }

    @Override
    public List<Book> searchBooksByAuthor(String s) {
        if (s.isEmpty()) throw new IllegalArgumentException();
        List<Book> newListOfBooks = new ArrayList<>();
        for (Book i : books) {
            if (i.getAuthor().getName().equals(s)) {
                newListOfBooks.add(i);
            }
        }
        return newListOfBooks;
    }

    @Override
    public boolean isBookInCatalog(String s) {
        if (s.isEmpty()) throw new IllegalArgumentException();
        for (Book i : books) {
            if (i.getIsbn().equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isBookAvailable(String s) {
        if (s.isEmpty()) throw new IllegalArgumentException();
        for (Book i : books) {
            if (isBookInCatalog(s)) {
                if (i.isAvailable()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public double calculateTotalPrice() {
        double sum = 0;
        for (Book i : books) {
            sum += i.getPrice();
        }
        return sum;
    }

    @Override
    public double calculateAveragePrice() {
        return calculateTotalPrice() / books.size();
    }

    @Override
    public List<Book> getSortedBooks() {
        List<Book> newListOfBooks = new ArrayList<>(books);
        newListOfBooks.sort(Comparator.comparing(Book::getPublicationYear));
        return newListOfBooks;
    }

    @Override
    public List<Book> searchBooksByTitleContaining(String s) {
        List<Book> newListOfBooks = new ArrayList<>();
        if (s.isEmpty()) {
            return newListOfBooks;
        }
        for (Book i : books) {
            if (i.getTitle().toLowerCase().contains(s.toLowerCase())) {
                newListOfBooks.add(i);
            }
        }

        return newListOfBooks;
    }

    @Override
    public Book findNewestBookByPublisher(String s) {
        Book newestBook = null;
        int newest = 0;
        for (Book i : books) {
            if (i.getPublisher().equals(s)) {
                if (newest < i.getPublicationYear()) {
                    newest = i.getPublicationYear();
                    newestBook = i;
                }
            }
        }
        if (newestBook == null) throw new BookNotFoundException("");
        return newestBook;
    }

    @Override
    public List<Book> filterBooks(Predicate<Book> predicate) {
        return books.stream()
                .filter(predicate).toList();
    }

    @Override
    public Map<String, List<Book>> groupBooksByPublisher() {
        return books
                .stream()
                .collect(Collectors.groupingBy(Book::getPublisher));
    }
}
