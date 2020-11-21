/**
   Client program to test the basic functionality of the FifoManager and
   LifoManager classes.
*/
public class InvControlTest
{
   public static void main(String [] args)
   {
      System.out.println("FIFO");
      InventoryControl inv = new FifoManager();
      inv.purchase(100, 20.00);
      System.out.printf("\nCost of goods sold: $%7.2f", inv.sale(70, 30.00));
      inv.purchase(80, 21.00);
      System.out.printf("\nCost of goods sold: $%7.2f", inv.sale(40, 30.00));
      System.out.printf("\nCost of goods sold: $%7.2f", inv.sale(20, 30.00));
      inv.purchase(100, 22.00);
      System.out.printf("\nGross profit:       $%7.2f", inv.grossProfit());
      System.out.printf("\nInventory Balance:  $%7.2f", inv.balance());
      System.out.println("\n" + inv);
	  
      System.out.println("\n\nLIFO");
      inv = new LifoManager();
      inv.purchase(100, 20.00);
      System.out.printf("\nCost of goods sold: $%7.2f", inv.sale(70, 30.00));
      inv.purchase(80, 21.00);
      System.out.printf("\nCost of goods sold: $%7.2f", inv.sale(40, 30.00));
      System.out.printf("\nCost of goods sold: $%7.2f", inv.sale(20, 30.00));
      inv.purchase(100, 22.00);
      System.out.printf("\nGross profit:       $%7.2f", inv.grossProfit());
      System.out.printf("\nInventory Balance:  $%7.2f", inv.balance());
      System.out.println("\n" + inv);
    }
}

//10 30, 5 20, 20 10