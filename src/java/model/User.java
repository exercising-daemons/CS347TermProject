package model;

/**
 * User represents users of the application
 * @author Eric Walters
 * @acknowledgements - Ralph Grove for source code to base off of
 */
public class User 
{ 
	 private int id = 0;
    private String fName,mName,lName,address,email,password;
    private int phoneNum = 0;
	 private int admin = 0;
	 private int payment_info_id = 0;
	
    public User(int id, String fName, String mName,String lName,
	String address, String email, String password, int phoneNum,
	int admin, int payment_info_id)
   {
		  this.id = id;
        this.fName = fName;
		  this.mName = mName;
		  this.lName = lName;
        this.address = address;
        this.email = email;
		  this.password = password;
        this.phoneNum = phoneNum;
		  this.admin = admin;
		  this.payment_info_id = payment_info_id;
    }
    public int getId() {return id;}
    public String getfName() {return fName;}
	 public String getmName() {return mName;}
	 public String getlName() {return lName;}
	 public String getAddress() {return address;}
	 public String getEmail() {return email;}
	 public String getPassword() {return password;}
	 public int getPhoneNum() {return phoneNum;}
	 public int getAdmin() {return admin;}
	 public int getPaymentInfoId() {return payment_info_id;}
}