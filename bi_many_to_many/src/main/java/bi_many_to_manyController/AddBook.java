package bi_many_to_manyController;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bi_many_to_many.Author;
import bi_many_to_many.Book;

public class AddBook {
public static void  main(String[]args) {
		
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("bi_many_to_many");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

Author author = manager.find(Author.class, 2);
		
		Book book = new Book();
		book.setId(4);
		book.setTitle("abc");
		book.setGenre("fiction");
		book.setIsbn(654);
		List<Book> books = author.getBooks();
		books.add(book);
		
		transaction.begin();
		author.setBooks(books);
		book.setAuthors(Arrays.asList(author));
		manager.persist(book);
		transaction.commit();
		System.out.println("New Book Added!");
		
}
}