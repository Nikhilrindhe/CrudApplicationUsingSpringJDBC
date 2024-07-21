package org.myventures.in;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
@Repository("bookRepo")
public class BookRepo {

	@Autowired
	JdbcTemplate template;
	public boolean isAddBook(final Book book)
	{
		int val=template.update("insert into Book values('0',?,?,?,?)",(PreparedStatement ps)->{
						ps.setString(1, book.getName());
						ps.setString(2,book.getAuthor());
						ps.setString(3, book.getPub());
						ps.setInt(4, book.getPrise());
			});
		return val>0?true:false;
	}
	public List<Book> viewAllBook()
	{
		
		List <Book>li=template.query("select *from book",(ResultSet rs,int rowNum)->
		new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5))
				);
		return li;
	}
	public List <Book> serchByName(String name) {
		
		@SuppressWarnings("deprecation")
		List<Book>li=template.query("select *from book where name=?",new Object[] {name} , (ResultSet rs,int rowNum)->
		
			new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5))
				);
		return li;
	}
	public List<Book> serchByAuthor(String name) {
		@SuppressWarnings("deprecation")
		List<Book>li=template.query("select *from book where author=?",new Object[] {name} , (ResultSet rs,int rowNum)->
		
			new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5))
				);
		return li;
	}
	public boolean isDeleteBook(int id) {
		
		int val=template.update("delete from book where id=?",(PreparedStatement ps)->
		ps.setInt(1, id)
		);
		
		return val>0?true:false;
	}
	public boolean isUpdateBook(int id, String name, String author) {
		int val=template.update("update book set name=?,author=? where id=?",(PreparedStatement ps)->
		{
		ps.setString(1,name);
		ps.setString(2,author);
		ps.setInt(3, id);
		}
		);
		return val>0?true:false;
	}

}
