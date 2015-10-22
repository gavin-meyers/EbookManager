package com.github.gavinmeyers.ebookmanager.store;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.github.gavinmeyers.ebookmanager.model.EBook;


public interface EBookStore extends MongoRepository<EBook, String> {

	@Query("{ 'title' : ?0 }")
	public EBook findByTitle(String title);

	@Query("{ 'type' : ?0 }")
	public List<EBook> findByType(String type);

	@Query("{ 'author' : ?0 }")
	public List<EBook> findByAuthor(String author);

	@Query("{ 'type' : ?0 }")
	public List<EBook> findByBookType(String type);

	@Query("{ 'type' : {$ne : ?0} }")
	public List<EBook> findByBookTypeNot(String type);

}
