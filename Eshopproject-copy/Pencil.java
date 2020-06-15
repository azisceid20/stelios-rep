public class Pencil extends Item{
    private double tipSize;
    private String type;
    
    private String Category = "Pencil";
    Pencil(String iname, double price, String description, int stock, int id, double tipSize, String type)throws NotTheRightType
    {
        super(iname, price, description,stock,id);
        this.tipSize = tipSize;
        if(type.equals("H")|| type.equals("B")||type.equals("HB")){
            this.type=type;
        }
        else throw new NotTheRightType("This is not the right type.");
    }
    public String getCategory(){
        return Category;
    }
    String getDetails(){
        return "";
    }
    Double getTipSize(){
        return tipSize;
    }
    public void setTipSize(double tipSize) {
        this.tipSize = tipSize;     
    }
    public String getType(){
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    }
