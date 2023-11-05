public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();


        Book book1 = new Book("Book 1", "Author 1", "1234567890", 2020);
        library.addBook(book1);

        library.displayBooks();


        Book foundBook = library.searchByTitle("Book 1");
        if (foundBook != null) {
            System.out.println("Found Book: " + foundBook.getTitle());
        } else {
            System.out.println("Book not found");
        }

        boolean deleted = library.deleteBookByISBN("1234567890");
        if (deleted) {
            System.out.println("Book deleted");
        } else {
            System.out.println("Book not found");
        }
    }
}
