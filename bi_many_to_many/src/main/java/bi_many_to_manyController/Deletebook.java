package bi_many_to_manyController;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bi_many_to_many.Author;
import bi_many_to_many.Book;

public class Deletebook {
public static void  main(String[]args) {
		
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("bi_many_to_many");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

	Author author = manager.find(Author.class, 1);
	Book book = manager.find(Book.class, 3);
	
	List<Book> books = author.getBooks();
	Iterator<Book> iterator = books.iterator();
	while(iterator.hasNext()) {
		Book book1 = iterator.next();
		Iterator<Author> iterator1 = book.getAuthors().iterator();
		while(iterator1.hasNext()) {
			Author author1 = iterator1.next();
			iterator.remove();
			iterator1.remove();
			
			break;
		}
		break;
	}
	transaction.begin();
	author.setBooks(books);
	transaction.commit();
	System.out.println("one book removed");
}
}