class Node{
    Book book;
    Node next;

    Node(){
        this.book = null;
        this.next = null;
    }

    Node(Book book){
        this.book = book;
        this.next = null;
    }
}

//-----------------------------------------------------------------------------------------------
/**
OOP Concepts used :

Data Encapsulation : Data + Methods encapsulated

Data Abstraction : Using default access specifiers

Aggregation : Node 'has a' Book.
 */