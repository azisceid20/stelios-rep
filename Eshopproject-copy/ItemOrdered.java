public class ItemOrdered {
  private Item item;
  private int quantity;

public ItemOrdered(Item item, int quantity) {        
    this.item = item;        
    this.quantity = quantity;    
}

public int getQuantity(){
    return quantity;
}
public Item getItem(){
    return item;
}
public void setItem(Item item){
    this.item=item;
}
public void setQuantity(int quantity){
    this.quantity=quantity;
}
}