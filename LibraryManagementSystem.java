import java.util.*;
import java.text.SimpleDateFormat;  
import java.io.IOException;

public class Library{



	
	public static int noOfbooks=0;
	private static ArrayList<BookDetails> books = new ArrayList<BookDetails>();  //creating arraylist of class bookdetails so that it can store the values of the diffrent objects of the same class bookdetails and we can access them whenever we need it.
	private static int studentid;  	
	private static String passwordAdmin="admin";
	private static String passwordUser="user";
	private static String password;
	private static String user;

    

	public static void main(String[] args) 
	{
		   // LABEL
			
			login();
	}
	private static void login(){	
			System.out.println("Press 1 to go to Admin LOGIN menu");
			System.out.println("Press 2 to go to Member LOGIN menu");

			Scanner p=new Scanner(System.in);
			int you=p.nextInt();	
		boolean cInput=true;
		
		if(you==1)
		{
			System.out.println("----------------------------ADMIN LOGIN PAGE----------------------------------");
			
			Scanner pass=new Scanner(System.in);
			do{
				try{
					System.out.println("User ID : ");
					user=pass.nextLine();
					cInput=false;
			    }
		    	catch(Exception e){System.out.println("WRONG ADMIN USER NAME"); pass.nextLine();}
				
	   	 	}while(cInput);
	   	 	System.out.println("Password : ");
			password=pass.nextLine();
	    }
		else if(you==2){
			System.out.println("----------------------------MEMBER LOGIN PAGE----------------------------------");
			
			Scanner pass1=new Scanner(System.in);
			
			do{
				try{
					System.out.println("User ID : ");
					int user1=pass1.nextInt();
					pass1.nextLine();
					studentid=user1;
					cInput=false;
			    }
		    	catch(Exception e){System.out.println("WRONG MEMBER USER NAME");pass1.nextLine();}
				
	   	 	}while(cInput);
	   	 	System.out.println("Password : ");
			password=pass1.nextLine();
		}
		else{System.out.println("INVALID INPUT. PLEASE TRY AGAIN"); login();}
		if(password.equals(passwordAdmin))
		{
			librarian();
		}
		else if (password.equals(passwordUser))
		{
			
			member();			
		}
		else
		{
			System.out.println("Wrong Password! PLEASE TRY AGAIN ");
			login();
			
		}   

	}
	private static void librarian()
	{	
		System.out.println("-------------------WELCOME TO LIBRARY MANAGEMENT SYSTEM---------------------");
		
		System.out.println("Press 1 to Add a book");
		System.out.println("Press 2 to Modify a book");
		System.out.println("Press 3 to Search a book");
		System.out.println("Press 4 to See all books");
		System.out.println("Press 5 to Remove a book");
		System.out.println("Press 6 to Go to LOGIN PAGE");
		System.out.println("Press 7 to exit");
		Scanner c = new Scanner(System.in);
		int choice = c.nextInt();
		
			switch (choice) {
			case 1:
				addBook();
				break;
			case 2:
				modifyBook();
				break;
			case 3:
				searchBook();
				break;
			case 4: showBooks();
				break;
			case 5:
				removeBook();
				break;	
			case 6: login();
			case 7:
				System.exit(0);
			default:
				System.out.println("Invalid input");
				librarian();
			}
			
	}
	//------------------------------------EXIT CONTROL--------------------------------------------------
	public static void EXIT()
	{
		System.out.println("Press 1 to go back or 0 to exit");
		Scanner s=new Scanner(System.in);
		int ch=s.nextInt();
		if(ch==1){librarian();}
		else if(ch==0){System.exit(0);}
		else{System.out.println("Inavlid Input");}
	}
	//-----------------------------------------CONTINUE------------------------------------------------------------
	public static void CONTINUE(){
		System.out.println("PRESS 1 to CONTINUE or 0 to go BACK");
		Scanner c=new Scanner(System.in);
		int ch=c.nextInt();
		if(ch==1){return;}
		else if(ch==0){librarian();}
		else{System.out.println("Invalid Input! Please Try Again"); CONTINUE();}
	}
	
	//--------------------------------------ShowAllBooks------------------------------------------------
	private static void showBooks(){
		
		CONTINUE();
		System.out.println("Total Books : "+noOfbooks);
		System.out.println("------------------------------------------------------------------------");
		for(int i=0;i<books.size();i++)
		{
			BookDetails b=books.get(i);
			System.out.println("Book Number      : "+b.getBookNumber());
			System.out.println("Book Name 	 : "+b.getBookName());
			System.out.println("Author Name      : "+b.getAuthor());
			System.out.println("Number of copies : "+b.getCopies());

			System.out.println("------------------------------------------------------------------------");
		}
		EXIT();
	}
	
	//---------------------------------------ADD BOOK-----------------------------------------------
	private static void addBook()
	{	
		CONTINUE();
		boolean cInput=true;
		char choice;
     do{
	      try{	
	          do{	

		   		 Scanner c = new Scanner(System.in);

		   		 System.out.println("Enter Book number");
		   		 int bookNumber = c.nextInt();
		   		 c.nextLine(); 								// skiping the newline character
		   		 System.out.println("Enter Book Name");
		   		 String name = c.nextLine();
		   		 System.out.println("Enter author Name:");
		   		 String author=c.nextLine();
		   		 System.out.println("Enter Number of copies:");  // number of copies of books
		   		 int copies=c.nextInt();
		   		
		  		 BookDetails book = new BookDetails(bookNumber, name, author,copies);
		  		 noOfbooks++;
		  		 book.setCount(noOfbooks);
		  		 books.add(book);	  

				 System.out.println("Want to Add more....(y/n)?");
				 choice = c.next().charAt(0);
	    		}while(choice =='Y' || choice =='y');
             cInput=false;
	    	}
	      catch(Exception ex)
	      {
		  	System.out.println("Try again.("+"Incorrect: Input not correct)");
		  }
	 }while(cInput);
	
	    EXIT();
	}
	//---------------------------------------SEARCH BOOK-------------------------------------------
	private static void searchBook()
	{
		
		CONTINUE();
		int check=0; 
		System.out.println("Enter Book Name: ");
		Scanner s=new Scanner(System.in);
		String search=s.nextLine();
		
		for(int i=0;i<books.size();i++)   //iterating the objects of class Bookdetails present the arraylist books
		{  
			BookDetails b = books.get(i);
			
			if(b.getBookName().equals(search)){

				check=1;
				System.out.println("--------------------BOOK FOUND----------------------");
				System.out.println("BOOK NUMBER      : "+b.getBookNumber());
				System.out.println("BOOK NAME        : "+b.getBookName());
				System.out.println("AUTHOR NAME      : "+b.getAuthor());
				System.out.println("Number of copies : "+b.getCopies());
				EXIT();   //changed
			}
			else{
				check=0;
			}
		}
		if(check==0){System.out.println("BOOK NOT FOUND IN DATABASE");}
		EXIT();
	}
	//---------------------------------------MODIFY BOOK--------------------------------------------
	private static void modifyBook()
	{	
		
		CONTINUE();
		System.out.print("Enter BOOK Number : ");
		Scanner c=new Scanner(System.in);
		int Bnumber=c.nextInt();
		c.nextLine();
		System.out.println("");
		for(int i=0;i< books.size();i++)
		{

			BookDetails b= books.get(i);
			if(b.getBookNumber()==Bnumber)
			{
				System.out.println("BOOK FOUND");
				System.out.println("Press 1 to Modify Book Number");
				System.out.println("Press 2 to Modify Book Name");
				System.out.println("Press 3 to Modify Author Name");
				System.out.println("Press 4 to Modify Book Issue settings");
				System.out.println("Press 5 to Modify the Number of copies present");
				System.out.println("Press 6 to Go Back");
				System.out.println("Press 7 to Go to LOGIN PAGE");
				System.out.println("Press 8 to exit");
				int choice=c.nextInt();
				c.nextLine();
				switch(choice)
				{
					case 1: System.out.print("Enter new Book Number : ");
						int num=c.nextInt();
						c.nextLine();
						for(int h=0;h<books.size();h++)
						{
							BookDetails boo=books.get(h);
							if(boo.getBookNumber()==num){
								System.out.println("BOOK NUMBER SHOULD BE UNIQUE. PLEASE TRY AGAIN");
								modifyBook();
							}
						}
						// can implement try catch here.............................................................
						b.setBookNumber(num);
						System.out.println("");
						System.out.println("BOOK NUMBER SUCCESSFULLY UPDATED");
						EXIT();
					case 2: System.out.print("Enter new Book Name : ");

						String s=c.nextLine();
						// can implement try catch here.............................................................
						b.setBookName(s);
						System.out.println("");
						System.out.println("BOOK NAME SUCCESSFULLY UPDATED");
						EXIT();
					case 3: System.out.print("Enter new Author Name : ");
						String x=c.nextLine();
						// can implement try catch here.............................................................
						b.setAuthor(x);
						System.out.println("");
						System.out.println("AUTHOR NAME SUCCESSFULLY UPDATED");
						EXIT();
					case 4:
						BookIssueDetails y=new BookIssueDetails();
						System.out.println("Allowable limit for issuing books :");
						int all=c.nextInt();
						y.setTotalBookAllowed(all);
						System.out.println("Limit Updated");
						EXIT();
					case 5: System.out.print("Enter new number of copies : ");
						int cop=c.nextInt();
						c.nextLine();
						b.setCopies(cop);
						System.out.println("");
						System.out.print("COPIES SUCCESSFULLY UPDATED ");
						EXIT();
					case 6:librarian();
					case 7:login();
					case 8: EXIT();
							
					default:
						System.out.println("Invalid input");
						c.nextLine();
						modifyBook();
				}
			}
			else{System.out.println("BOOK NOT FOUND"); modifyBook();}
		}
	}
	
	//-----------------------------------------REMOVE BOOK----------------------------------------------------------
	
	
	private static void removeBook()
	{
		
		CONTINUE();
		int check=0;
		System.out.println("Enter Book Number : ");
		Scanner x= new Scanner(System.in);
		int numb=x.nextInt();
		 for(int i=0;i<books.size();i++){
		 	BookDetails b=books.get(i);
		 	if(b.getBookNumber()==numb){
		 		check=1;
				System.out.println("Book Name : "+b.getBookName()+" is Successfully Removed");
		 		books.remove(b);     
		 		EXIT();
		 	}
		 	else{check=0;}
		 }
		if(check==0){
			System.out.println("BOOK NUMBER NOT FOUND, PLEASE TRY AGAIN");
			removeBook();
		}
		
	}
 //-------------------------------------------USER--------------------------------------------------
	public static void EXITUSER()
	{
		System.out.println("Press 1 to go back or 0 to exit");
		Scanner s=new Scanner(System.in);
		int ch=s.nextInt();
		if(ch==1){member();}
		else if(ch==0){System.exit(0);}
		else{System.out.println("Inavlid Input");}
	}
	public static void CONTINUEUSER(){
		System.out.println("PRESS 1 to CONTINUE or 0 to go BACK");
		Scanner c=new Scanner(System.in);
		int ch=c.nextInt();
		if(ch==1){return;}
		else if(ch==0){member();}
		else{System.out.println("Invalid Input! Please Try Again"); CONTINUEUSER();}
	}
	private static void member()
	{	
		System.out.println("-------------------WELCOME TO LIBRARY MANAGEMENT SYSTEM---------------------");
		
		System.out.println("Press 1 to Issue a book");
		System.out.println("Press 2 to Return a book");
		System.out.println("Press 3 to Print your issue detais");
		System.out.println("Press 4 to Go to Login Page");
		System.out.println("Press 5 to Exit");
		Scanner c = new Scanner(System.in);
		int choice = c.nextInt();
		do {
			switch (choice) {
			
			case 1:
				issueBook();
				break;
			case 2:
				returnBook();
				break;
			case 3:
				printCompleteIssueDetails();
				break;
			case 4: login();
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid input");
				member();
				
			}
			c = new Scanner(System.in);
			choice = c.nextInt();
		} while (choice > 0 && choice < 6);
	}
	
	private static ArrayList<BookIssueDetails> booksIssue=new ArrayList<BookIssueDetails>();
	//----------------------------------------ISSUE BOOKS----------------------------------------------
	public static int che=0;// to control the book issue
	public static String issueDate;
	private static void issueBook() //user
	{   
	    
	    CONTINUEUSER();
	    Scanner c = new Scanner(System.in);	
        
        int bookNumber;

        BookIssueDetails bookIssu = new BookIssueDetails();
        
		System.out.println("Enter Student Id : ");        
		int studentId = c.nextInt();
		c.nextLine();
		System.out.println("Enter Student Name : ");
		String name = c.nextLine();
		System.out.println("Number of Book issued : ");
		int bookIssued=c.nextInt();

			//issue date
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
   		Date date = new Date();  
    		issueDate=formatter.format(date);  //formating date in dd/mm/yyyy formal and then convert it into string
		
		if(bookIssued>bookIssu.getTotalBookAllowed()){
			System.out.println("You cannot issue more than "+bookIssu.getTotalBookAllowed()+" books");
			issueBook();
		}
		if(bookIssued>=1){
			for(int i=0;i<bookIssued;i++){
				System.out.println("Enter Book Number : ");
				bookNumber = c.nextInt();
				System.out.println("No.of books Issued : "+bookIssued);
				for(int j=0;j<books.size();j++){
					BookDetails bo=books.get(j);
					if(bo.getBookNumber()==bookNumber){
						BookIssueDetails bookIssue=new BookIssueDetails(studentId,bookNumber,name,bookIssued,issueDate);
	    				booksIssue.add(bookIssue);
	    				printBookDetails(bookNumber,bookIssued);
					}	
				}
				if(bookIssued==che){EXITUSER();}
	    	}
	    }	    
	}
	//-------------------------------------print book issued detail--------------------------------------------------
	private static void printBookDetails(int bookNos,int bookIssued){
		CONTINUEUSER();
		BookIssueDetails issue = new BookIssueDetails();

		
		System.out.println("------------------------------------------------------------");
		for(int i=0;i<books.size();i++)
		{
			BookDetails boo = books.get(i);
			if(boo.getBookNumber()==bookNos)
			{
				if(boo.getCopies()==0){System.out.println("ISSUE UNSUCCESSFUL! BOOK OUT OF STOCK");}
				else
				{    che++;
					System.out.println("-------------BOOK ISSUED SUCCESSFULLY----------------");
					System.out.println("BOOK NUMBER : "+boo.getBookNumber());
					System.out.println("BOOK NAME   : "+boo.getBookName());
					System.out.println("AUTHOR NAME : "+boo.getAuthor());
					int y=boo.getCopies()-1;   //book issued so the book copies will be decrement by 1 whenever someone issue a book
					boo.setCopies(y);
					issue.setReturnDate(issueDate);
					System.out.println("Return Date : "+issue.getReturnDate());
					System.out.println("------------------------------------------------------------");
			    }
			    if(bookIssued>1){return;}
			}
		} 
		EXITUSER();   
	}
  //==========================================return book==========================================================
	public static int flag=0;
	private static void returnBook()
	{
		
		CONTINUEUSER();
		int check=0;
		char ch;
		System.out.println("Enter your Student Id : ");
		Scanner m=new Scanner(System.in);
		int id=m.nextInt();
		for(int i=0;i<booksIssue.size();i++)
		{
			BookIssueDetails b=booksIssue.get(i);
		
			if(b.getStudentId()==id)
			{
				flag++;		   
				if(check==0)
				{
					System.out.println("ID   : "+b.getStudentId());
					System.out.println("NAME : "+b.getStudentName());
						
					check++;
			 	}
			 	
		 		System.out.println("----------------------YOU HAVE ISSUED-----------------------");
		 		System.out.println("BOOK NUMBER  : "+b.getBookNumber());
		 		for(int j=0;j<books.size();j++)
		 		{
		 			BookDetails boo=books.get(i);
		 			if(boo.getBookNumber()==b.getBookNumber())
					{
						System.out.println("BOOK NAME    : "+boo.getBookName());
						System.out.println("AUTHOR NAME  : "+boo.getAuthor());
						RETURNBOOK(boo,b);
						break;
		   		    }
		   		}
			}
		}	
	}
	public static void RETURNBOOK(BookDetails boook,BookIssueDetails b)
	{

		System.out.println("WANT TO RETURN BOOK(Y/N) : ");
		Scanner re=new Scanner(System.in);
		char ret=re.next().charAt(0);
		if(ret=='Y' || ret=='y')
		{
			System.out.println("BOOK RETURN SUCCESSFULLY");
			int y=boook.getCopies()+1;  //book get return so book copies get incremented by 1
			boook.setCopies(y);
			booksIssue.remove(b);  //to remove the issued book from student id
			
		}
		else
		{
			System.out.println("BOOK RETURN UNSUCCESFULL");
			EXITUSER();
		}
		if(flag==b.getNoOfBookIssued()){EXITUSER();}
		if(b.getNoOfBookIssued()>1){return;}
		

	}
  
	private static void printCompleteIssueDetails()
	{   
		
		CONTINUEUSER();
		BookIssueDetails issue=new BookIssueDetails();
		
		for(int i=0;i<booksIssue.size();i++)
		{   
			BookIssueDetails boook=booksIssue.get(i);
            if(boook.getStudentId()==studentid)
            {	
            	for(int j=0;j<books.size();j++)
            	{
    	        	BookDetails bdetail=books.get(j);

		            if(boook.getBookNumber()==bdetail.getBookNumber())
					{	
						System.out.println("------------------BOOK ISSUED DETAILS---------------------");
						System.out.println("BOOK NUMBER : "+bdetail.getBookNumber());
						System.out.println("BOOK NAME   : "+bdetail.getBookName());
						System.out.println("AUTHOR NAME : "+bdetail.getAuthor());
						System.out.println("ISSUE DATE  : "+boook.getIssueDate());
						issue.setReturnDate(boook.getIssueDate());
						System.out.println("Return Date : "+issue.getReturnDate());
						System.out.println("------------------------------------------------------------");
					}
					else{System.out.println("You have no book issued");}			
				}
			}	
			else{continue;}	
		}
		EXITUSER();
	}
}
//---------------------------------------------BOOK DETAILS-----------------------------------------------------------
class BookDetails {
	private int bookNumber;
	private String bookName;
	private String author;
	public  int count;
	public int copies;

	public BookDetails(int bookNumber,String name,String author,int copies)
	{
		this.bookNumber=bookNumber;
		this.bookName=name;
		this.author=author;
		this.copies=copies;
		
	}
	public BookDetails()
	{
		
		
	}
	public int getCopies() {  //return copies of books
		return copies;
	}
	public void setCopies(int copies) { //set new copies of books
		this.copies = copies;
	}
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getBookNumber() {
		return bookNumber;
	}
	
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}
//=========================Book Issue Details============================================
class BookIssueDetails extends BookDetails  //using inheritance for controling the number of copies of books are left 
{
	private int booksNumber;
	private String name;
	private int studentId;
	private int totalBookAllowed = 2;
	private int noOfBookIssued;
	private String issueDate;
	private String returnDate;
	// private String booksName;

	
	public BookIssueDetails(int studentId,int booksNumber,String name,int n,String issueDate)
	{
		this.studentId=studentId;
		this.booksNumber=booksNumber;
		this.name=name;
		this.noOfBookIssued=n;
		this.issueDate=issueDate;
	}
	public BookIssueDetails()
	{
		
	}
	public int getStudentId()
	{
		return studentId;
	}
	public String getStudentName(){
		return name;
	}
	public int getBookNumber() 
	{
		return booksNumber;
	}

	public int getNoOfBookIssued()
	{
		return noOfBookIssued;
	}

	public String getIssueDate()
	{ 
		return issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String issuDate) //you can issue books for 7 days only 
	{
		
	SimpleDateFormat sdF = new SimpleDateFormat("dd/mm/yyyy");
	Calendar c = Calendar.getInstance();
	try{
	   									
	   c.setTime(sdF.parse(issuDate));
	}
	catch(Exception e){
		e.printStackTrace();
	 }
	c.add(Calendar.DAY_OF_MONTH, 7);  
	this.returnDate = sdF.format(c.getTime());  
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalBookAllowed() {
		return totalBookAllowed;
	}

	public void setTotalBookAllowed(int totalBookAllowed) {
		this.totalBookAllowed = totalBookAllowed;
	}
}

