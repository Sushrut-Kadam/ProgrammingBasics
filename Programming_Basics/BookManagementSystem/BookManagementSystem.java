/**
    Title : Book Management System
 */
//----------------------------------------------------------------------------------------------
import java.util.Scanner;
import java.util.ArrayList;

class BookManagementSystem{
    static Scanner in = new Scanner(System.in);
    static int idCount = 0;

    static void search(List list){
        System.out.println("\nSelect criteria to search : ");
        System.out.println("1. ID");
        System.out.println("2. NAME");
        System.out.println("3. AUTHOR");
        System.out.println("4. COST");

        char choice;
        System.out.print("Enter your choice : ");
        choice = in.nextLine().charAt(0);

        ArrayList<Book> temp;
        int size = 0;

        switch(choice){
            case '1' :
                    System.out.print("Enter id to search : ");
                    long id = Long.parseLong(in.nextLine());
                    Book result = list.searchId(id); 
                    if(result != null)
                        result.printInfo();
                    else
                        System.out.println("No search found !");
                    break;

            case '2' : 
                    System.out.print("Enter name to search : ");
                    String name = in.nextLine().toLowerCase();
                    temp = list.searchName(name);
                    size = temp.size();
                    if(size == 0)
                        System.out.println("No search found");
                    else{
                        // System.out.println(size);
                        for(int i=0; i<size; i++){
                            temp.get(i).printInfo();
                        }
                    }
                    break;    

            case '3' : 
                    System.out.print("Enter author to search : ");
                    String author = in.nextLine().toLowerCase();
                    temp = list.searchAuthor(author);
                    size = temp.size();
                    if(size == 0)
                        System.out.println("No search found");
                    else{
                        for(int i=0; i<size; i++){
                            temp.get(i).printInfo();
                        }
                    }
                    break;    

            case '4' : 
                    System.out.print("Enter cost to search : ");
                    double cost = Double.parseDouble(in.nextLine());
                    temp = list.searchCost(cost);
                    size = temp.size();
                    if(size == 0)
                        System.out.println("No search found");
                    else{
                        for(int i=0; i<size; i++){
                            temp.get(i).printInfo();
                        }
                    }
                    break;    
        }
    }

    public static void main(String[] args){
        List myBooksList = new List();              //List created

        char repeat;

        do{
            System.out.println("\n---- Menu ----");
            System.out.println("1. Insert");
            System.out.println("2. Show");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.print("Select your choice : ");
            
            char choice = in.nextLine().charAt(0);
            // choice = in.nextInt();
    
            switch(choice){
                case '1' : 
                        System.out.println("Enter book details : ");
                        System.out.print("Enter name : ");
                        String name = in.nextLine().toLowerCase();
                        System.out.print("Enter author : ");
                        String author = in.nextLine().toLowerCase();
                        System.out.print("Enter cost : ");
                        double cost = Double.parseDouble(in.nextLine());
                        
                        idCount++;
                        Book book = new Book(idCount, name, author, cost);
                        Node newNode = new Node(book);
                        // Book b2 = new Book(2, "Harry Potter-2", "JK Rowling", 800.00);
                        // Book b3 = new Book(3, "Harry Potter-3", "JK Rowling", 950.00);
                        myBooksList.insert(newNode);
                        break;
                        
                case '2' : 
                        System.out.println("Showing all books");
                        System.out.printf("\n%-3s ","id");
                        System.out.printf("| %-12s ","name");
                        System.out.printf("| %-12s ","author");
                        System.out.printf("| %-8s\n","cost");
                        myBooksList.show();
                        System.out.println();
                        break;

                case '3' :
                        search(myBooksList);
                        break;
                
                case '4' :
                        System.out.print("Enter name of the book to be deleted ! : ");
                        name = in.nextLine().toLowerCase();
                        Node deleted = myBooksList.delete(name);
                        if(deleted == null)
                            System.out.println("Book not found !");
                        else
                            System.out.println(deleted.book.getName()+" deleted !");
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