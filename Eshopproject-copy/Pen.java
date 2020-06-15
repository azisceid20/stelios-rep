public class Pen extends Item
{
    private String color;
    private double tipSize;
    private String Category = "Pen";
    Pen(String iname, double price, String description, int stock, int id, double tipSize, String color)
        {
        super(iname, price, description,stock,id);
        this.tipSize = tipSize;
        this.color = color;
        
    }
    public String getCategory(){
        return Category;
    }
    String getDetails(){
        return color;
    }
    public void setDetails(String color){
        this.color = color;
    }
    Double getTipSize(){
        return tipSize;
    }
    public void setTipSize(double tipSize) {
        this.tipSize = tipSize;
       
    }
}