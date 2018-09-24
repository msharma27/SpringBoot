package org.learn.java;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest")
public class BookRestController {

	// List<Book> books = BookRepository.BOOKS;
	Map<Integer, Book> bookMap = BookRepository.BOOKMAP;

	// allowing access
	@GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public ResponseEntity<Collection<Book>> getAll() {
		// List<Book> books = BookRepository.BOOKS;
		return new ResponseEntity<Collection<Book>>(bookMap.values(), HttpStatus.OK);
	}

	// displaying a book by id
	@GetMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public ResponseEntity<Book> getOne(@PathVariable Integer id) {
		// Map<Integer, Book> bookMap = BookRepository.BOOKMAP;
		Book book = bookMap.get(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);

	}

	// addding a book to the repository

	@PostMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public ResponseEntity<Void> Create(@RequestBody(required = true) Book book) {
		// List<Book> books = BookRepository.BOOKS;
		// books.add(book);
		bookMap.put(book.getId(), book);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// put method

	@PutMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> update(@RequestBody(required = true) Book book) {
		if (bookMap.containsKey(book.getId())) {
			bookMap.replace(book.getId(), book);
		} else {
			return Create(book);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	// delete operation
	@DeleteMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

	// different way of doing it would be:

	// @RequestMapping(value = "/books/{id}",method=RequestMethod.DELETE, produces =
	// MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		if (bookMap.containsKey(id)) {
			bookMap.remove(id);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
