package com.github.gavinmeyers.ebookmanager.store;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.github.gavinmeyers.ebookmanager.model.EBook;

@RepositoryRestResource(collectionResourceRel = "ebooks", path = "myEbooks")
public interface EBookStore extends MongoRepository<EBook, String> {

	@Query("{ 'title' : ?0 }")
	public EBook findByTitle(@Param("title") String title);

	@Query("{ 'type' : ?0 }")
	public List<EBook> findByType(@Param("type") String type);

	@Query("{ 'author' : ?0 }")
	public List<EBook> findByAuthor(@Param("author") String author);

	@Query("{ 'type' : ?0 }")
	public List<EBook> findByBookType(String type);

	@Query("{ 'type' : {$ne : ?0} }")
	public List<EBook> findByBookTypeNot(String type);

}
