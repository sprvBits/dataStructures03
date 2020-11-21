import java.util.*;
public class FifoManager implements InventoryControl
{

   
    Queue<Inventory> myQueue = new LinkedList<Inventory>();
   
   Inventory item = new Inventory();
   private int inventoryBalance;
   //private int inventoryUnits;
   private double grossProfit;
   
   public void purchase(int units, double unitCost)
   {
      
      item.setNumberItem(units);
      item.setCostItem(unitCost);
      
      
      
      myQueue.add(item);
    
      
         //inventoryUnits += units;
         inventoryBalance += units * unitCost;
   

         
   }
   
   
   public double sale(int units, double salePrice)
   {  
      
      double costSold = 0;
      int inventoryUnits = myQueue.peek().getNumberItem();
      
      //System.out.print(inventoryUnits);
      
      // if(units < inventoryUnits)
//       {
//          costSold = units * myQueue.peek().getCostItem();
//          myQueue.peek().setNumberItem(inventoryUnits - units);  
//          
//          flag = true;
//       }
//       
//       else
//       {
//          flag = false;
//       }
//       while(!flag)
//       {  
//          inventoryUnits = myQueue.peek().getNumberItem(); 
//          System.out.println(inventoryUnits);
//          costSold += inventoryUnits  * myQueue.peek().getCostItem();
//          units= units - inventoryUnits;
//          
//          myQueue.poll();
//           
//          inventoryUnits = myQueue.peek().getNumberItem(); 
//          if(units > inventoryUnits)
//          {
//             flag = false;
//          }
//          
//          else
//          {
//             flag = true;
//          }
//          //inventoryUnits = myQueue.remove().getNumberItem();   
//       }
   
      if(units < inventoryUnits)
      {
         costSold += units * myQueue.peek().getCostItem();
         myQueue.peek().setNumberItem(inventoryUnits - units);
      }
      
      else
      {
         do
         {
            costSold += inventoryUnits * myQueue.peek().getCostItem();
            units = units- inventoryUnits;
            myQueue.poll();
            costSold += units * myQueue.peek().getCostItem();
            myQueue.peek().setNumberItem(myQueue.peek().getNumberItem() - units);            
            inventoryUnits = myQueue.peek().getNumberItem();

            
         }
         
         while(units > inventoryUnits);
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
      while(myQueue.peek() != null)

      {
         output += myQueue.remove() + "\n";

      }
      return output;
   }
}