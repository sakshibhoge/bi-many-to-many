package bi_many_to_manyController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bi_many_to_many.Author;
import bi_many_to_many.Book;

public class Find {
public static void  main(String[]args) {
		
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("bi_many_to_many");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();


		Author author =  manager.find(Author.class, 1);
		if(author != null) {
			System.out.println("-----------------------------------");
			System.out.println("Author Id : "+author.getId());
			System.out.println("Author Name : "+author.getName());
			System.out.println("Author BirtDate : "+author.getBirthDate());
			System.out.println("Author Genre Experties : "+author.getGenreExperties());
			System.out.println("Author Total Books Published : "+author.getTotalBooksPub());
			System.out.println("-----------------------------------");
			for(Book book : author.getBooks()) {
				System.out.println("-----------------------------------");
				System.out.println("Book Id : "+book.getId());
				System.out.println("Book Title : "+book.getTitle());
				System.out.println("Book Genre : "+book.getGenre());
				System.out.println("Book Publication : "+book.getPublication());
				System.out.println("Book ISBN : "+book.getIsbn());
			}
		}
		
}}