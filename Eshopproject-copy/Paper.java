public class Paper extends Item {
    private int weight;
    private int pages;
    private String Category = "Paper";
    Paper(String iname,double price,String description,int id,int stock , int weight , int pages )
    {
        super (iname , price , description , stock , id );
        this.weight = weight;
        this.pages = pages;
        
    }
    String getDetails(){
        return "";
    }
    public String getCategory(){
        return Category;
    }
    
    public void setWeight ( int weight ) 
    {
        this.weight = weight;
    }
    public int getWeight()
    {
        return weight;
    }
    public void setPages(int pages)
    {
        this.pages = pages;
    }
    public int getPages()
    {
        return pages;
    }
    
}