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