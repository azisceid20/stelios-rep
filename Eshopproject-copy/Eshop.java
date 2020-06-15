import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;
public class Eshop {
    public String shopname;
    Owner owner;
    ArrayList<Item> itemArray = new ArrayList<Item>();
    ArrayList<Buyer> buyerArray = new ArrayList<Buyer>();
    Eshop(String shopname){
        this.shopname = shopname;
    }
    public void addItem(Item item)throws AlreadyExistsException {
            if (!itemArray.contains(item)){
                   
                itemArray.add(item); 
                return;
                   
                }
            throw new AlreadyExistsException("The item already exists!"); 
             
    }        
    public void updateItemStock(Item item, int newStock){        
        if(itemArray.contains(item)){
            item.setStock(newStock); 
        }
    }

    
    
    public Item getItemByld(int id){
        for (int i = 0;  i < itemArray.size();  i++ ) {
            itemArray.get(i).getid();
            if ( id == itemArray.get(i).getid()){
                return itemArray.get(i);
            }   
        }
        return null;
    }
    public void removeItem(Item item){
            itemArray.remove(item);
    }

    public void addBuyer(Buyer buyer)throws ItemAlreadyAddedException {
        
            if (buyerArray.contains(buyer)){
            throw ItemAlreadyAddedException ;
        }
         else   buyerArray.add(buyer);
        
        
         
    }

 
    public void removeBuyer(Buyer buyer){
        buyerArray.remove(buyer);
    }
    public HashMap<Integer,String> showCategories(){
        Integer counterPen=1;
        Integer counterPencil=2;
        Integer counterNotebook=3;
        Integer counterPaper=4;
        HashMap<Integer,String> orderedCategories= new HashMap<Integer,String>();
        for (int i=0; i < itemArray.size(); i++) {
             
             if(itemArray.get(i).getCategory().equals("Pen")){
                orderedCategories.put(counterPen, itemArray.get(i).getCategory());
                
             }
             else if(itemArray.get(i).getCategory().equals("Pencil")){
                orderedCategories.put(counterPencil, itemArray.get(i).getCategory());
                
             }
             else if(itemArray.get(i).getCategory().equals("Notebook")){
                orderedCategories.put(counterNotebook, itemArray.get(i).getCategory());
                
             }
             else if(itemArray.get(i).getCategory().equals("Paper")){
                orderedCategories.put(counterPaper, itemArray.get(i).getCategory());
                
             }
             
        }
        Iterator orderedCategoriesIterator = orderedCategories.entrySet().iterator(); 
        while (orderedCategoriesIterator.hasNext()) { 
                Map.Entry mapElement = (Map.Entry)orderedCategoriesIterator.next(); 
                System.out.println(mapElement.getKey() + ") " + mapElement.getValue()); 
        }
        return orderedCategories;
        
    }
    public void showProductInCategory(String category){
        for (int i = 0; i < itemArray.size(); i++){
                if (itemArray.get(i).getCategory().equals(category)) {
                    System.out.println(itemArray.get(i).toString());
                }
        }
    }

    public void showProduct(Item a){
        System.out.println(a.toString());
    }
 
    public String getShopName(){
        return shopname;
    }
    public void checkStatus(){
        Integer counter=1;
        HashMap<Integer, Buyer> buyersMap= new HashMap<Integer, Buyer>();
        for (int i=0; i < buyerArray.size(); i++) {
             buyersMap.put(counter,buyerArray.get(i));
             counter++;
        }
        Iterator buyersMapIterator = buyersMap.entrySet().iterator(); 
        while (buyersMapIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)buyersMapIterator.next(); 
            Buyer b=(Buyer)mapElement.getValue();
            System.out.println(mapElement.getKey() + ") " + " Bonus: " +b.getBonus() + " Category: " + b.getbuyerCategory()); 
        }
        
        Scanner chBuyer= new Scanner(System.in);
        int chooseBuyer=chBuyer.nextInt();
        
        
    }   
}   
