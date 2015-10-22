package com.github.gavinmeyers.ebookmanager.store;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.gavinmeyers.ebookmanager.model.EBook;

public interface EBookStore extends MongoRepository<EBook, String> {

	public EBook findByTitle(String title);

	public List<EBook> findByType(String type);

	public List<EBook> findByAuthor(String author);

}
