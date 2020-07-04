package cn.edu.usts.cs2018.entity;

public class Book {
    private int id;
    private String author;
    private String title;
    private float price;
    private int year ;
    private String publisher;
    private String description;
    private int saleAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Book() {
    }


    public Book(int id, String author, String title, float price, int year, String publisher, String description, int saleAmount) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
        this.year = year;
        this.publisher = publisher;
        this.description = description;
        this.saleAmount = saleAmount;
    }

    @Override
    public String toString() {
        return "[" + id + ", "+author+"," + title + ", " +price+","+year + ", " +
                publisher + ", " + description + ", " + saleAmount+ "]";
    }
}
