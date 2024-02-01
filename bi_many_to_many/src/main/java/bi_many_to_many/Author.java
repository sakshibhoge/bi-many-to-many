package bi_many_to_many;



import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
	public class Author {
		@Id
		private int id;
		private String name;
		private LocalDate birthDate;
		private String genreExperties;
		private int totalBooksPub;
		
		@ManyToMany(mappedBy = "authors")
		private List<Book> books;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LocalDate getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}

		public String getGenreExperties() {
			return genreExperties;
		}

		public void setGenreExperties(String genreExperties) {
			this.genreExperties = genreExperties;
		}

		public int getTotalBooksPub() {
			return totalBooksPub;
		}

		public void setTotalBooksPub(int totalBooksPub) {
			this.totalBooksPub = totalBooksPub;
		}

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}

		public Author() {
			super();
		}
		
		

		
	}

