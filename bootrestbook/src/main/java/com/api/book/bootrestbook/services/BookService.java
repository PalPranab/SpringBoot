package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

	private static List<Book> list = new ArrayList<>();

	static {
		list.add(new Book(12, "Java Complete Reference", "xyz"));
		list.add(new Book(13, "Learn Java First", "abc"));
		list.add(new Book(14, "Things in Java", "lmn"));
	}

	// Get all books
	public List<Book> getAllBooks() {
		return list;
	}

	// Get a single book
	public Book getBook(int id) {
		Book book = null;
		try {
			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// Adding the book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

	// Delete a book
	public void deleteBook(int id) {

		list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
	}

	// Update book
	public void updateBook(Book book, int bookId) {

		list.stream().map(b -> {
			if (b.getId() == bookId) {
				b.setId(book.getId());
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}

}
