import java.util.ArrayList;

class List{
    Node head;

    List(){
        head = new Node();
    }

    void insert(Node newNode){
        if(head.next == null)
            head.next = newNode;                //inserting at the 1st position
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void show(){
        if(head.next == null){
            System.out.println("List is empty !");
        }
        else{
            Node temp = head.next;

            while(temp.next != null){
                temp.book.printInfo();
                temp = temp.next;
            }
            temp.book.printInfo();
        }
    }

    Book searchId(long id){
        if(this.head.next == null)
            return null; 
        else{
            Node temp = head.next;

            while(temp != null){
                if(temp.book.getId() == id)
                    return temp.book;

                temp = temp.next;
            }
        }
        return null;
    }

    ArrayList<Book> searchName(String name){              
        if(this.head.next == null)
            return null;
        else{
            ArrayList<Book> result = new ArrayList<>();
            Node temp = head.next;

            while(temp != null){
                if(temp.book.getName().contains(name)){
                    result.add(temp.book);
                }
                temp = temp.next;
            }
            return result;
        }
    }

    ArrayList<Book> searchAuthor(String author){
        if(this.head.next == null)
            return null;  
        else{
            ArrayList<Book> result = new ArrayList<>();
            Node temp = head.next;

            while(temp != null){
                if(temp.book.getAuthor().contains(author)){
                    result.add(temp.book);
                }
                temp = temp.next;
            }
            return result;
        }
    }

    ArrayList<Book> searchCost(double cost){
        if(this.head.next == null)
            return null;  
        else{
            ArrayList<Book> result = new ArrayList<>();
            Node temp = head.next;
            
            while(temp != null){

                if(temp.book.getCost() == cost){
                    result.add(temp.book);
                }
                temp = temp.next;
            }
            return result;
        }
    }

    Node delete(String name){
        if(this.head.next == null)
            return null;
        else{
            Node temp = head.next;

            while(temp != null){
                if(temp.book.getName().equals(name)){
                    break;
                }
                temp = temp.next;
            }
            
            if(temp != null){
                Node temp2 = head.next;
                while(temp2.next != temp){
                    temp2 = temp2.next;
                }
                temp2.next = temp.next;
            }
            
            return temp;
        }
    }
}