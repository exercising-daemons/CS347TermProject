package model;

/**
 * Item represents items in the store
 * @author Eric Walters
 * @acknowledgements - Ralph Grove for source code to base off of
 */
public class User 
{ 
    //private int id = 0;
    private String fName, mName, lName, address, password, email;
    private int admin, phone, id;
	
	
    public User(int id, String fName, String mName, String lName, String address, 
            String password, int admin, int phone, String email)
   {
       this.id = id;
       this.fName = fName;
       this.mName= mName;
       this.lName= lName;
       this.address = address;
       this.password = password;
       this.admin = admin;
       this.phone = phone;
       this.email=email;
    }
    public String getFirstName() {return fName;}
    public String getMiddleName() {return mName;}
    public String getLastName() {return lName;}
    public String getAddress() {return address;}
    //maybe get rid of this
    public String getPassword() {return password;}
    public int getAdmin() {return admin;}
    public int getPhone() {return phone;}
    public String getEmail() {return email;}

}