import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Scanner;

class Book{
    private long id;
    private String name;
    private String author;
    private double cost;

    Book(long id, String name, String author, double cost){
        this.id = id;
        this.name = name;
        this.author = author;
        this.cost = cost;
    }
    
    public String getName(){
        return name;
    }

    public void showDetails(){
        System.out.println("id : "+id);
        System.out.println("name : "+name);
        System.out.println("author : "+author);
        System.out.println("cost : "+cost);
    }
}

class BookManagementSystem{
    
    static HashMap<Integer, Book> bookList = new HashMap<>();
    static Scanner in = new Scanner(System.in);

    static int idCount = 0;

    static int hash(String name){
        int size = name.length();

        char ch;
        int total = 0;

        for(int i=0; i<size; i++){
            ch = name.charAt(i);
            total += (int)ch;
        }

        // System.out.println(total%50);
        return total%50;
    }

    static void insert(Book book){
        int hashValue = hash(book.getName());
        if(bookList.get(hashValue) == null)
            bookList.put(hashValue, book);
        else{
            while(bookList.get(hashValue) != null)
                hashValue++;

            bookList.put(hashValue, book);
        }
    }

    static void showAll(){
        Collection<Book> values = bookList.values();
        ArrayList<Book> showList = new ArrayList<>(values);
        for(Book b : showList)
            b.showDetails();
    }

    static int search(String name){
        int hashValue = hash(name);
        
        Book result = bookList.get(hashValue);
        
        if(result == null){
            return -1;
        }
        else{
            if(result.getName().equals(name)){
                return hashValue;
            }
            else{
                while(!bookList.get(hashValue).getName().equals(name)){
                    hashValue++;

                    if(bookList.get(hashValue) == null){
                        return -1;
                    }
                }
                // bookList.get(hashValue).showDetails();               
                return hashValue; 
            }
        }
    }

    static boolean delete(String name){
        int key = search(name);
        if(key == -1)
            return false;
        else{
            bookList.remove(key);
            return true;
        }          
    }

    public static void main(String[] args){
        char repeat;

        do{
            System.out.println("\n---- Menu ----");
            System.out.println("1. Insert");
            System.out.println("2. Show");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.print("Select your choice : ");
            
            char choice = in.nextLine().charAt(0);
            
            // String input = in.nextLine();                //other next() methods create problem
            // int choice = Integer.parseInt(input);        //for nextLine()
            // System.out.println("Choice : "+choice);
    
            switch(choice){
                case '1' : 
                        System.out.println("Enter book details : ");
                        System.out.print("Enter name : ");
                        String name = in.nextLine();
                        System.out.print("Enter author : ");
                        String author = in.nextLine();
                        System.out.print("Enter cost : ");
                        double cost = Double.parseDouble(in.nextLine());
                        
                        idCount++;
                        Book book = new Book(idCount, name, author, cost);
                        // Book b2 = new Book(2, "Harry Potter-2", "JK Rowling", 800.00);
                        // Book b3 = new Book(3, "Harry Potter-3", "JK Rowling", 950.00);
                        insert(book);
                        break;
                        
                case '2' : 
                        showAll();
                        System.out.println();
                        break;

                case '3' :
                        System.out.print("Enter book-name to search : ");
                        String bookName = in.nextLine();
                        int key = search(bookName);
                        if(key == -1)
                            System.out.println("No search found !");
                        else
                            bookList.get(key).showDetails();
                        break;
                
                case '4' :
                        System.out.print("Enter name of the book to be deleted ! : ");
                        bookName = in.nextLine();
                        if(delete(bookName))
                            System.out.println("Book : "+bookName+" deleted !");
                        else
                            System.out.println(bookName+" not found !"); 
                        break;

                default : 
                        System.out.println("Choice Incorrect");
                        break;
            }
            System.out.print("\nDo you want to continue ? (Y/N) : ");
            repeat = in.nextLine().charAt(0);
        }while(repeat == 'y' || repeat == 'Y');
    }
}