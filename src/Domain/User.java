package Domain;

/**
 * Created by atulsharma on 20/02/17.
 */
public class User {
    private int user_id;
    private String user_name;
    private String user_add;
    private String user_email;

    public  User(){}
    public  User(int user_id,String user_name,String user_add,String user_email)
    {
        this.user_id=user_id;
        this.user_name=user_name;
        this.user_add=user_add;
        this.user_email=user_email;
    }
    public int getUserId()
    { return user_id;
    }
    public void setUserId(int user_id)
    {
        this.user_id=user_id;
    }
    public String getUserName()
    {
        return user_name;
    }
    public void setUserName(String user_name)
    {
        this.user_name=user_name;
    }
    public String getUserAdd()
    {
        return user_add;
    }
    public void setUserAdd(String user_add)
    {
        this.user_add=user_add;
    }
    public String getEmail()
    {
        return user_email;
    }
    public void setEmail(String user_email){
        this.user_email=user_email;
    }
    public String toString()
    {
     return "User{" +
             "userId=" + user_id +
             ", name='" + user_name + '\'' +
             ", address='" + user_add + '\'' +
             ", email='" + user_email + '\'' +
             '}';

    }
}
