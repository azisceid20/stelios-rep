public class Notebook extends Item{
private int sections;
private String Category = "Notebook";
Notebook(String iname, double price, String description, int stock, int id, int sections)
{
    super(iname, price, description,stock,id);
    this.sections = sections;
    
}
String getDetails(){
        return "";
    }
public String getCategory(){
        return Category;
    }
int getSections(){
    return sections;
}
public void setSections(int sections) {
    this.sections = sections;
}
}