package org.myventures.in;

public class Book {
private int id;
private String name;
private String author;
private String pub;
private int prise;
public Book(int id,String name, String author, String pub, int prise) {
	this.id=id;
	this.name = name;
	this.author = author;
	this.pub = pub;
	this.prise = prise;
}
public Book()
{
	
}
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
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPub() {
	return pub;
}
public void setPub(String pub) {
	this.pub = pub;
}
public int getPrise() {
	return prise;
}
public void setPrise(int prise) {
	this.prise = prise;
}


}
