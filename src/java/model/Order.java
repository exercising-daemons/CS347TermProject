package model; 
/**
 * Order represents orders in the system
 * @author Eric Walters
 * @acknowledgements - Ralph Grove for source code to base off of
 */
public class Order 
{ 
	private int order_ID = 0;
	private String status = "";
	private int user_ID = 0;
	
	/*Used the default constructor for Date() for now because
	I'm not sure how MySQL passes its' native time primitive
	type to Java. */
	//private Date OrderTime = new Date(); 
        private String OrderTime="";
	
	
    public Order(int order_ID, String status, int user_ID,
				  String OrderTime)
    {
		this.order_ID = order_ID;
		this.status = status;
		this.user_ID = user_ID;
		this.OrderTime = OrderTime;
    }
	
    public int getOrderID() {return order_ID;}
    public String getStatus() {return status;}
    public int getUserID() {return user_ID;}
    public String getOrderTime() {return OrderTime;}

}