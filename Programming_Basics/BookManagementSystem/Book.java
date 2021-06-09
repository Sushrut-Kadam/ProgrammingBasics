class Book{
    private long id;
    private String name;
    private String author;
    private double cost;

    public Book(long id, String name, String author, double cost){
        this.id = id;
        this.name = name;
        this.author = author;
        this.cost = cost;
    }

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getAuthor(){
        return this.author;
    }

    public double getCost(){
        return this.cost;
    }

    public void printInfo(){
        System.out.printf("\n%-3d ",getId());
        System.out.printf("| %-12s ",getName());
        System.out.printf("| %-12s ",getAuthor());
        System.out.printf("| %-8.2f\n",getCost());
    }
}