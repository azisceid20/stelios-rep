abstract public class Item {
    private String iname;
    private double price;
    private String description;
    int stock;
    private int id;
    public String Category;
    Item ( String iname , double price , String description , int stock , int id)
    {
        this.iname = iname;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.id = id;
        
    }
    abstract String getCategory();
    
    public String getBasicInfo(){
         return ("Name: " + getBasicInfo() + "Price:" +getPrice() + " Description:" + getDetails() + "Stock: " + getStock() + "ID: " + getid());
    }
    public void setBasicInfo(String iname){
        this.iname = iname;
    }
    double getPrice (){
        return price;
    }
    public void setStock ( int stock ) {
        this.stock = stock;
    }
    int getStock(){
        return stock;
    }
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }
    abstract String getDetails();
     @Override 
    public String toString(){ 
        return (getBasicInfo() + getDetails());
    }
}

