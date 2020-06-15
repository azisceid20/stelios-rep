public class Buyer extends User{
    private int  bonus;
    String buyerCategory;
    ShoppingCart basket = new ShoppingCart(this);
    private int id;
    private boolean isAdmin = false;
    Buyer(String name, String email)
    {
        super ( name , email );
        bonus = 0;
        buyerCategory ="BRONZE";
    }
    public void awardBonus(double points){
        bonus+=points;
        setbuyerCategory();
    }
    public void setbuyerCategory()
    {        
        if (bonus >= 200){
            buyerCategory = "GOLD"; 
        }
        
        else if (bonus >=100 && bonus <=200){
            buyerCategory = "SILVER";
        }
        
        else{
            buyerCategory = "BRONZE"; 
        }
    }
    public String getbuyerCategory(){return buyerCategory;}
    public void placeOrder(Item item , int quantity){
        ItemOrdered order = new ItemOrdered(item,quantity);
        basket.addItemOrdered(order);
    }
    
    public void setId(int id){
         this.id = id;
    }
    
    public int getId(){
        return id;
    }
    public int getBonus()
    {
        return bonus;
    }
    public String getName(){return name;}
    public ShoppingCart getBasket(){
        return basket;
    }
    
}