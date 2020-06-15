import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;
public class ShoppingCart {
Buyer buyer; 
ShoppingCart (Buyer b){
    buyer=b;
}  
ArrayList<ItemOrdered> orderList = new ArrayList<ItemOrdered>();
public void addItemOrdered(ItemOrdered order){
    order.getItem().setStock(order.getItem().getStock() - order.getQuantity());
    orderList.add(order);
    
}
public void addItemOrdered(Item item , int quantity){
    if ( quantity <= item.getStock()){
        ItemOrdered itorder =  new ItemOrdered (item,quantity);    
        item.setStock(item.getStock() - quantity);
        if (orderList.contains(itorder)){
            for ( int i = 0; i < orderList.size(); i++) {
                if(orderList.get(i).getItem().getid() == itorder.getItem().getid()){
                    orderList.get(i).setQuantity(orderList.get(i).getQuantity()+quantity);
                }
            }
        }
        else{
            orderList.add(itorder);
        }
    }
    else System.out.println("Not enought Stock!!");
}


public void removeItemOrdered(ItemOrdered itorder){
    if (orderList.contains(itorder)){
        for ( int i=0 ; i<orderList.size(); i++){
            if(orderList.get(i).getItem().getid() == itorder.getItem().getid()){
                    orderList.get(i).getItem().setStock(orderList.get(i).getQuantity()+ orderList.get(i).getItem().getStock());
                    orderList.remove(i);
            }
        } 
    }
}
public void changeItemOrderedQuantity(ItemOrdered itorder,int changedQuantity){
    if (orderList.contains(itorder)){
        for (int i=0;i<orderList.size();i++){
            if(orderList.get(i).getItem().getid() == itorder.getItem().getid()){
                orderList.get(i).setQuantity(changedQuantity);
            }
        }
    }
}
public HashMap<ItemOrdered,Integer> showCart(){
        Integer counter=1;
        HashMap<ItemOrdered, Integer> basketMap= new HashMap<ItemOrdered, Integer>();
        for (int i=0; i < orderList.size(); i++) {
             basketMap.put(orderList.get(i),counter);
             counter++;
        }
        Iterator basketMapIterator = basketMap.entrySet().iterator(); 
        while (basketMapIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)basketMapIterator.next(); 
            System.out.println(mapElement.getValue() + ") " + mapElement.getKey()); 
        }
        return basketMap;
}
public void clearCart(){
        for (int i=0; i <orderList.size(); i++){
            orderList.remove(i);
    }
}
public void checkout(){
    System.out.println("Continue to payment ? (y/n)"); 
    Scanner answerReader = new Scanner(System.in);
    String answerInput = answerReader.nextLine();
    while(!(answerInput.equals("y") || answerInput.equals("n")))
    { 
        System.out.println("Not the input we asked for.");
        System.out.println("Continue to payment ? (y/n)"); 
        answerReader = new Scanner(System.in);
        answerInput = answerReader.nextLine();
    }
    if (answerInput.equals("y")){
        buyer.awardBonus(calculateNet()/10);
    }
}
public double calculateNet(){
    int sum=0;
    for(int i=0;i<orderList.size();i++){
        sum +=orderList.get(i).getItem().getPrice();
    }
    return sum;
}
public double calculateCourierCost(){
    double courierCost=0;
    if (buyer.getbuyerCategory().equals("GOLD")){
        courierCost = calculateNet();
    }
    else if (buyer.getbuyerCategory().equals("SILVER")){
        courierCost = (calculateNet() * 0.5)/2;
    }
    else if (buyer.getbuyerCategory().equals("BRONZE")){
        courierCost = ( calculateNet() * 0.02);
    }
    return courierCost;
}
}
