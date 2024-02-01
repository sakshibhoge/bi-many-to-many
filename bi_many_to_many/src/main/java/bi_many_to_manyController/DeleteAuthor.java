package bi_many_to_manyController;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bi_many_to_many.Author;
import bi_many_to_many.Book;

public class DeleteAuthor {
public static void  main(String[]args) {
		
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("bi_many_to_many");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

		Book book = manager.find(Book.class, 4);
		 List<Author> authors = book.getAuthors();
		 Author target = null;
		 for(Author author : authors) {
			 if(author.getId() == 3) {
				 target = author;
			 }
		 }
		 if(target != null) {
			 transaction.begin();
			 authors.remove(target);
			 book.setAuthors(authors);
			 manager.persist(book);
			 transaction.commit();
			 System.out.println("One author is deleted");
}
}}
