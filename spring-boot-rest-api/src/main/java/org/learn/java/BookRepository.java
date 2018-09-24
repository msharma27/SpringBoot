package org.learn.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

	public static List<Book> BOOKS = new ArrayList<>(5);
	public static Map<Integer, Book> BOOKMAP = new HashMap<>(5);
	
	static {
		BOOKS.add(new Book(1001, "Eleven"));
		BOOKS.add(new Book(1002, "Monk who sold his ferrari"));
		BOOKS.add(new Book(1003, "Alchemist"));
		BOOKS.add(new Book(1004, "Harry Potter"));
		
		// inserting values to the map
		for(Book book: BOOKS)
		{
			BOOKMAP.put(book.getId(), book);
		}
	}
	
}
