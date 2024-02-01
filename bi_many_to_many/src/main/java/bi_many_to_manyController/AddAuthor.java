package bi_many_to_manyController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bi_many_to_many.Author;
import bi_many_to_many.Book;

public class AddAuthor {
public static void  main(String[]args) {
		
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("bi_many_to_many");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

	 Book book = manager.find(Book.class, 4);
	 
	 Author author = new Author();
	 author.setId(3);
	 author.setName("abc");
	 author.setGenreExperties("fiction");
	 author.setBirthDate(LocalDate.now());
	 author.setTotalBooksPub(5);
	 
	 List<Author> authors = book.getAuthors();
	 authors.add(author);
	 
	 transaction.begin();
	 book.setAuthors(authors);
	 author.setBooks(Arrays.asList(book));
	 manager.persist(author);
	 transaction.commit();
	 System.out.println("New author Added!");
}
}