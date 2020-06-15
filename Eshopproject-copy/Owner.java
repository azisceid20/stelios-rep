public class Owner extends User
{
    private boolean isAdmin = true;
    
    Owner(String name , String email)
    {
        super ( name , email );
        
    }
    public String getEmail(){return email;}
    public void setEmail(String email) {
        this.email = email;
    }
    public void setOwner(String name) {
        this.name = name;
    }
}