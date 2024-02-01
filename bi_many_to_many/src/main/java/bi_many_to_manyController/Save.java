package bi_many_to_manyController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bi_many_to_many.Author;
import bi_many_to_many.Book;

public class Save {
	
public static void  main(String[]args) {
		
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("bi_many_to_many");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
	Author author1 = new Author();
	author1.setId(1);
	author1.setName("sudha murty");
	author1.setGenreExperties("motivational");
	author1.setBirthDate(LocalDate.of(2000, 06, 12));
	author1.setTotalBooksPub(5);
	
	Author author2 = new Author();
	author2.setId(2);
	author2.setName("sakshi");
	author2.setGenreExperties("sci-fiction");
	author2.setBirthDate(LocalDate.of(2002, 8, 23));
	author2.setTotalBooksPub(4);
	
	Book book1 = new Book();
	book1.setId(1);
	book1.setTitle("geography");
	book1.setIsbn(1223);
	book1.setPublication("sciencebooks");
	book1.setGenre("science");
	
	Book book2 = new Book();
	book2.setId(2);
	book2.setTitle("abc");
	book2.setIsbn(456);
	book2.setPublication("mehta pub");
	book2.setGenre("sci-fiction");
	
	Book book3 = new Book();
	book3.setId(3);
	book3.setTitle("history");
	book3.setIsbn(987);
	book3.setPublication("mehta pub");
	book3.setGenre("history");
	
	List<Book> books1 = new ArrayList<>();
	books1.add(book1);
	books1.add(book3);
	List<Book> books2 = new ArrayList<>();
	books2.add(book2);
	
	book1.setAuthors(Arrays.asList(author1));
	book3.setAuthors(Arrays.asList(author1));
	book2.setAuthors(Arrays.asList(author2));
	
	transaction.begin();
	author1.setBooks(books1);
	author2.setBooks(books2);
	manager.persist(author1);
	manager.persist(author2);
	manager.persist(book1);
	manager.persist(book2);
	manager.persist(book3);
	transaction.commit();
	System.out.println("All details Saved!");
}}
