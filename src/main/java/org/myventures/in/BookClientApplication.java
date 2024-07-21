package org.myventures.in;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookClientApplication {

	public static void main(String[] args) {
		java.util.Scanner niks=new java.util.Scanner(System.in);
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		BookService bser=(BookService)context.getBean("bookService");
		do {
			System.out.println("\ncase 1:Add new Book");
			System.out.println("case 2:View All Book");
			System.out.println("case 3:Search Book");
			System.out.println("case 4:Delete Book");
			System.out.println("case 5:Update Book");
			System.out.println("Enter the choice");
			int choice=niks.nextInt();
			niks.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the Book name,author name,publish name,prise");
				
				String name=niks.nextLine();
				String author=niks.nextLine();
				String pub=niks.nextLine();
				
				int prise=niks.nextInt();
				
				Book book=new Book();
				book.setName(name);
				book.setAuthor(author);
				book.setPub(pub);
				book.setPrise(prise);
				
				if(bser.isAddBook(book))
				{
					System.out.println("Book added successfully!!!");
				}
				else {
					System.out.println("Book not added!!!");
				}
				

				break;
			case 2:
				List <Book>list=bser.viewAllBook();
				for(Book b:list)
				{
					System.out.println(b.getId()+"\t"+b.getName()+"\t"+b.getAuthor()+"\t"+b.getPub()+"\t"+b.getPrise());
				}
				break;
			case 3:
				String ch=null;
				
				do {
					System.out.println("\npress 'name' for serch by name");
					System.out.println("press 'author' for serch by author");
					System.out.println("press 'exit' for exit");
					
					System.out.println("Enter the choice");
					ch=niks.nextLine();
					switch(ch)
					{
					case "name":
						System.out.println("enter the book name for serching");
						name=niks.nextLine();
						
						List <Book>li=bser.serchByName(name);
						for(Book bb:li)
						{
							System.out.println(bb.getId()+"\t"+bb.getName()+"\t"+bb.getAuthor()+"\t"+bb.getPub()+"\t"+bb.getPrise());
						}
						break;
					case "author":
						System.out.println("enter the Author name for serching");
						name=niks.nextLine();
						
						li=bser.serchByAuthor(name);
						for(Book bb:li)
						{
							System.out.println(bb.getId()+"\t"+bb.getName()+"\t"+bb.getAuthor()+"\t"+bb.getPub()+"\t"+bb.getPrise());
						}
						break;
						
				}
					}while(!(ch.equals("exit")));
				
				break;
			case 4:
				System.out.println("Enter the id for delete book");
				int id=niks.nextInt();
				String s=bser.isDeleteBook(id)?"deleted successfully":"not deleted";
			System.out.println(s);
				break;
				
			case 5:
				System.out.println("Enter the Book id,name,author name for update");
				id=niks.nextInt();
				niks.nextLine();
				name=niks.nextLine();
				author=niks.nextLine();
				 s=bser.isUpdateBook(id,name,author)?"Updated successfully":"not Updated";
				System.out.println(s);
				break;
				
				
				default:
					System.out.println("Enter valid choice");
			}
		}while(true);
		
	}

}
