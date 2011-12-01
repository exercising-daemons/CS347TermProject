package model;

/**
 * Item represents items in the store
 * @author Eric Walters
 * @acknowledgements - Ralph Grove for source code to base off of
 */
public class Item 
{ 
	private int id = 0;
    private String name, description, category;
    private double price = 0.0;
	private int stock = 0;
	
    public Item(int id, String name, String description,double price,
	String category, int stock)
   {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
		this.category = category;
        this.stock = stock;
    }
    public int getId() {return id;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getCategory() {return category;}
    public double getPrice() {return price;}
    public int getStock() {return stock;}
}