package org.myventures.in;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookService {

	@Autowired
	BookRepo bookRepo;
	
	public boolean isAddBook(Book book)
	{
		return bookRepo.isAddBook(book);
	}
	public List<Book> viewAllBook()
	{
		return bookRepo.viewAllBook();
		
	}
	public List<Book> serchByName(String name) {
		return bookRepo.serchByName(name);
	}
	public List<Book> serchByAuthor(String name) {
		return bookRepo.serchByAuthor(name);
	}
	public boolean isDeleteBook(int id) {
		return bookRepo.isDeleteBook(id);
	}
	public boolean isUpdateBook(int id,String name,String author) {
		return bookRepo.isUpdateBook(id,name,author);
	}
}
