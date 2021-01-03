package model;

public class User_Details {
    public String ID;
    public String Username;
    public String FirstName;
    public String LastName;
    public String birthday;
    public String gender;
    public String Email;
    public String Password;
    public String Mobile;


    public User_Details(String Id, String username, String fname,String lname,String birthday,String gender, String email, String password, String mobile) //Constructor with all parameters
    {
        ID = Id;
        Username = username;
        FirstName = fname;
        LastName = lname;
        this.birthday = birthday;
        this.gender =  gender;
        Email = email;
        Password = password;
        Mobile = mobile;

    }
    public User_Details(String Password) //Constructor with one parameter
    {
        this.Password = Password;
    }
}
