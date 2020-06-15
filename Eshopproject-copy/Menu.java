import java.util.Scanner;
import java.util.HashMap;
import java.util.*;
public class Menu{
    Eshop eshop;
    Owner owner;
    ShoppingCart basket;
    Buyer buyeruser=null;
    Stack st = new Stack();
    String currentComm=null;
    String prevComm=null;
    public void RunMenu(){
        if(buyeruser!=null){
        System.out.println("What do you want to do?");
        Scanner decideInput = new Scanner(System.in);
        String dcdInput = decideInput.nextLine();
        if(prevComm!=null){
            st.push(prevComm);
        }
        switch(dcdInput){
            case "Logout":
                prevComm=currentComm;
                currentComm="Logout";
                buyeruser=null;
                loginSetup();
                RunMenu();
                break;
            case "Browse" :
                prevComm=currentComm;
                currentComm="browse";
                browseStore();
                RunMenu();
                break;
            
            case "Choose Category":
                prevComm=currentComm;
                currentComm="Choose Category";
                chooseCat(eshop.showCategories());
                RunMenu();
                break;
            case "View":
                prevComm=currentComm;
                currentComm="View";
                ViewCart(basket.showCart());
                RunMenu();
                break;
            
            case "Checkout":
                prevComm=currentComm;
                currentComm="Checkout";
                basket.checkout();
                RunMenu();
                break;
             
            case "Back":
                String comm=(String)st.pop();
                System.out.println(comm);
                if(comm.equals("Logout")){
                    
                    buyeruser=null;
                    loginSetup();
                    RunMenu();
                    
                }
                else if(comm.equals("Browse")){
                    
                    
                    currentComm="browse";
                    browseStore();
                    RunMenu();
                    
                    
                }
                else if(comm.equals("Choose Category")){
                    
                    currentComm="Choose Category";
                    chooseCat(eshop.showCategories());
                    RunMenu();
                   
                    
                }
                else if(comm.equals("View")){
                   currentComm="View";
                   ViewCart(basket.showCart());
                   RunMenu();
                }
                else if(comm.equals("Checkout")){
                   currentComm="Checkout";
                   basket.checkout();
                   RunMenu();
                   
                }
                RunMenu();
                break;
                
            case "Exit":    
                prevComm=currentComm;
                currentComm="Exit";
                System.out.println("Exiting..");
                break;
                
            case "Default":
                RunMenu();
                break;
       
                
        }
    }else {
        System.out.println("What do you want to do?");
        Scanner decideInput = new Scanner(System.in);
        String dcdInput = decideInput.nextLine();
        
        switch(dcdInput){
            case "Logout":
                buyeruser=null;
                loginSetup();
                RunMenu();
                break;
            case "Checkstatus" :
                eshop.checkStatus();
                RunMenu();
                break;
            case "Browse":
                prevComm=currentComm;
                currentComm="browse";
                browseStore();
                RunMenu();
                break;
            
            case "Choose Category":
                chooseCat(eshop.showCategories());
                RunMenu();
                break;
            case "View":
                ViewCart(basket.showCart());
                RunMenu();
                break;
            
            case "Checkout":
                basket.checkout();
                RunMenu();
                break;
             
            case "Back":
                String comm=(String)st.pop();
                System.out.println(comm);
                if(comm.equals("Logout")){
                    
                    buyeruser=null;
                    loginSetup();
                    RunMenu();
                    
                }
                if(comm.equals("Browse")){
                    
                    
                    currentComm="browse";
                    browseStore();
                    RunMenu();
                    
                    
                }
                if(comm.equals("Choose Category")){
                    
                    currentComm="Choose Category";
                    chooseCat(eshop.showCategories());
                    RunMenu();
                   
                    
                }
                if(comm.equals("View")){
                   currentComm="View";
                   ViewCart(basket.showCart());
                   RunMenu();
                }
                if(comm.equals("Checkout")){
                   currentComm="Checkout";
                   basket.checkout();
                   RunMenu();
                   
                }
                RunMenu();
                break;
                
            case "Exit":
                System.out.println("Exiting..");
                break;
                
            case "Default":
                RunMenu();
                break;
       
                
        }
        
        
        
    }
}
    public void filltheStore(){
        
        Eshop eshop = new Eshop("Amazon") ;
        
        Owner owner = new Owner("Jeff Bezos","JBezos@gmail.com");
        Buyer buyer1 = new Buyer ("Despoina Botsa","Dbotsa@gmail.com");
        Buyer buyer2 = new Buyer ("Stelios Azis","Sazis@gmail.com");
        
            eshop.addBuyer(buyer1);
            eshop.addBuyer(buyer2);
        
        
        try{
            eshop.addItem(new Pen("Bic", 1.15, "Student Pen", 100, 1111,0.3,"Blue")); 
            eshop.addItem(new Pen("Pilot", 1.20, "Professional Pen", 100, 1112,0.4,"red")); 
            eshop.addItem(new Pen("Peni", 1.30, "Child Pen", 100, 1113,0.5,"purple")); 
            try{
                eshop.addItem(new Pencil("Pale", 1.25, "Pen for girls", 100, 2421,0.5,"H")); 
                eshop.addItem(new Pencil("Pirate", 1.42, "Pen for boys", 100, 2422,0.6,"HB")); 
                eshop.addItem(new Pencil("Pecnilare", 1.57, "Pen for adults",100, 2423, 0.7,"B")); 
            }catch(NotTheRightType nt){
                System.out.println(nt.getMessage());
            }
            eshop.addItem(new Paper("Tree", 5.5, "Special paper", 50, 1000, 3, 3000)); 
            eshop.addItem(new Paper("Parasite", 5.5, "Good paper", 50, 4, 2, 2000));
            eshop.addItem(new Paper("Peares", 5.5, "Everyday use paper", 50, 2, 1, 1000));
            eshop.addItem(new Notebook("Noteszw", 5.5, "Vacation notebook", 5 , 10 , 11));
            eshop.addItem(new Notebook("RealPaper", 5.5, "Everyday use notebook",6, 5 , 6));
            eshop.addItem(new Notebook("Barcelona", 5.5, "Special paper", 4 , 3 , 12));
            }catch(AlreadyExistsException a){System.out.println("Already exists!");}
            this.eshop = eshop;
            this.owner = owner;
        
    }
    public void loginSetup(){
        
        System.out.println(" Please enter your email:");

        Scanner useremail = new Scanner (System.in);
        String usersInput = useremail.nextLine();
        for (int i=0; i < eshop.buyerArray.size();i++){
            if(eshop.buyerArray.get(i).getEmail().equals(usersInput)){
                buyeruser = eshop.buyerArray.get(i);
                basket = buyeruser.getBasket();
                System.out.println("Welcome back mr/mrs" + buyeruser.getName());
                break;
            }
        }
        if(buyeruser==null){
            if(owner.getEmail().equals(usersInput)) {
                System.out.println("Welcome back mr" + owner.getName());
            }else {
                buyeruser = signUp();
            }
        } 
     
    }
    public Buyer signUp() {
        System.out.println("Would you like to sign?(y/n)");
        Scanner input = new Scanner(System.in);
        String clientinput = input.nextLine();
        Buyer newBuyer = null;
        if(clientinput.equals("y")){
           
            System.out.println("Type your name:");
            String newbuyername = input.nextLine();
            newBuyer = new Buyer(newbuyername,clientinput);
            System.out.println("New Buyer is created!");
        }else if(clientinput.equals("n")){
        }
        else{
            System.out.println("Not the input we asked for.");
            System.out.println("Would you like to sign?(y/n)");
            clientinput = input.nextLine(); 
        }
              
        
             if(eshop.buyerArray.contains(newBuyer)){
                System.out.println("Buyer already Exists");}
             else eshop.addBuyer(newBuyer);
        
        
        
        return newBuyer;
    }
    public void browseStore(){
           System.out.println("Welcome to"+ eshop.getShopName() +" Online Itemshop. "); 
           HashMap<Integer,String> ordercat = eshop.showCategories();
           
           
           
        
    }
    public void chooseCat(HashMap<Integer,String> orderedCategοry){
        System.out.println("Choose the Category you like to shop!(1-4)");
        Scanner ch = new Scanner(System.in);
        String chcat = ch.nextLine();
        for (HashMap.Entry<Integer,String> entry : orderedCategοry.entrySet()){
            if(Integer.parseInt(chcat)== entry.getKey()){
                eshop.showProductInCategory(entry.getValue());
                break;
            }  
        }
        if(buyeruser!=null){
            System.out.println("Choose the ");
        }
    }
    public void chooseProduct(){
        System.out.println("Enter the ID of the product you would like to buy:");
        Scanner idinput = new Scanner(System.in);
        int clientsInput = idinput.nextInt();
        
        
        Item it=eshop.getItemByld(clientsInput);
        if(it!=null){
            System.out.println("Add to basket?(y/n)");
            Scanner input = new Scanner(System.in);
            String stinput = input.nextLine();
            while(!(input.equals("y")|| input.equals("n"))){
                System.out.println("Not the input we asked for.");
                System.out.println("Add to basket?(y/n)");
            }
            if(input.equals("y")){
                System.out.println("Set quantity:");
                Scanner quantityInput = new Scanner(System.in);
                int qInput = quantityInput.nextInt();
                basket.addItemOrdered(it,qInput);
            }
            
            eshop.showProduct(it);
        }else 
        System.out.println("Wrong ID!");
        if(buyeruser!=null){
            System.out.println("Enter the ID of the product you like to edit:");
            Scanner quantityInput = new Scanner(System.in);
            int quInput = quantityInput.nextInt();
            eshop.getItemByld(quInput);
            Item itm = eshop.getItemByld(quInput);
            System.out.println("Would you like to update the stock?(y/n)");
            Scanner ynInput = new Scanner(System.in);
            String ynynInput = ynInput.nextLine();
            if(ynynInput.equals("y")){
                System.out.println("Give the stock:");
                Scanner stockInput = new Scanner(System.in);
                int stInput=stockInput.nextInt();
                eshop.updateItemStock(itm,stInput);
            }
            
        }
    }    
        
        
        
        
    
    public void ViewCart(HashMap<ItemOrdered,Integer> basketMap){
        System.out.println("Your basket:" + basketMap);
        System.out.println("Choose the continue of the process:");
        System.out.println("1)Choose a line from your basket to edit the order");
        System.out.println("2)Clear your basket");
        System.out.println("3)Checkout");
        
        Scanner lineInput = new Scanner(System.in);
        int linput = lineInput.nextInt();
        switch(linput){
                case 1: {
                    for(HashMap.Entry<ItemOrdered,Integer> entry : basketMap.entrySet()){
                        if(linput == entry.getValue()){
                        }
        
                        System.out.println("For the line you selected you have the following options:(1/2)");
                        System.out.println("1) Remove the item");
                        System.out.println("2) Edit the quantity of the item");
                        Scanner optionsInput = new Scanner(System.in);
                        int optInput = optionsInput.nextInt();
                        switch(optInput){
                            case 1:{
                                basket.removeItemOrdered(entry.getKey());
                                break;
                            }
                            case 2:{
                                System.out.println("Set the quantity you would like to order:");
                                Scanner quantityInput = new Scanner(System.in);
                                int qInput = quantityInput.nextInt();
                                basket.changeItemOrderedQuantity(entry.getKey(),qInput);
                                break;
                            }
                        }
        
                    }
                }
                case 2:{
                        basket.clearCart();
                }
                case 3:{
                        basket.checkout();
                }
        }
        
    }
    
    public void logOut(){
        System.out.println("Logging off..");
        loginSetup();
    }
}
  



