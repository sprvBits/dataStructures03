public class LifoManager implements InventoryControl
{
   private StackInt<Inventory> myStack = new LinkedStack<>();
   
   Inventory item = new Inventory();
   private int inventoryBalance;
   private int inventoryUnits;
   private double grossProfit;
   
   public void purchase(int units, double unitCost)
   {
      
      item.setNumberItem(units);
      item.setCostItem(unitCost);
      
      
      
      myStack.push(item);
    
      
         //inventoryUnits += units;
         inventoryBalance += units * unitCost;
   

         
   }
   
   
   public double sale(int units, double salePrice)
   {  
      
      double costSold = 0;
      int inventoryUnits = myStack.peek().getNumberItem();
      
      //System.out.print(inventoryUnits);
      boolean flag ;
      if(units < inventoryUnits)
      {
         costSold = units * myStack.peek().getCostItem();
         myStack.peek().setNumberItem(inventoryUnits - units);  
         
         flag = true;
      }
      
      else
      {
         flag = false;
      }
      while(!flag)
      {  
         inventoryUnits = myStack.peek().getNumberItem(); 
         System.out.println(inventoryUnits);
         costSold += inventoryUnits  * myStack.peek().getCostItem();
         units= units - inventoryUnits;
         
         myStack.pop();
          
         inventoryUnits = myStack.peek().getNumberItem(); 
         if(units > inventoryUnits)
         {
            flag = false;
         }
         
         else
         {
            flag = true;
         }
         //inventoryUnits = myStack.remove().getNumberItem();   
      }
         
      
        
      grossProfit +=  units*salePrice - costSold;
      inventoryBalance -= costSold;
      return costSold;


}
   
 
   public double grossProfit()
   {
      return grossProfit;
   }
   
   public double balance()
   {
      return inventoryBalance;
   }
   
   public String toString()
   {
      String output = "";
      while(myStack.peek() != null)

      {
         output += myStack.pop() + "\n";

      }
      return output;
      
   }
   
 }