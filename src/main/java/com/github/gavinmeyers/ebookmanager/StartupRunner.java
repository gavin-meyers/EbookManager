package com.github.gavinmeyers.ebookmanager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.github.gavinmeyers.ebookmanager.model.EBook;
import com.github.gavinmeyers.ebookmanager.store.EBookStore;

public class StartupRunner implements CommandLineRunner {
	protected final Log LOGGER = LogFactory.getLog(getClass());

	@Autowired
	EBookStore repository;

	/**
	 * This is a sample runner to test MongoDB connectivity and functionality.
	 * TODO: need to replace with production worthy code
	 */
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Hello");
		repository.deleteAll();
		LOGGER.info("Collection deleted");

		repository.save(new EBook("A Tale Of Two Cities", "Charles Dickens", "Novel", 10));
		repository.save(new EBook("The Da Vinci Code", "Dan Brown", "thriller", 12));
		repository.save(new EBook("Think and Grow Rich", "Napoleon Hill", "Motivational", 10));
		repository.save(new EBook("The Hobbit", "J.R.R. Tolkien", "Fantasy", 8));
		repository.save(new EBook("Le Petit Prince", "Antoine de Saint-Exupery", "Novel", 8));

		LOGGER.info("Book found with findAll():");
		LOGGER.info("-------------------------------");
		for (EBook bstore : repository.findAll()) {
			LOGGER.info(bstore);
		}
		System.out.println();

		LOGGER.info("Book found with findByTitle('The Da Vinci Code'):");
		LOGGER.info("--------------------------------");
		EBook book1 = repository.findByTitle("The Da Vinci Code");
		book1.setPrice(5);
		// Update Book
		repository.save(book1);

		book1 = repository.findByTitle("The Da Vinci Code");
		LOGGER.info(book1);

		// Delete Book
		repository.delete(book1);

		LOGGER.info("Book found with findByType('Novel'):");
		LOGGER.info("--------------------------------");
		for (EBook book : repository.findByType("Novel")) {
			LOGGER.info(book);
		}

	}

}
