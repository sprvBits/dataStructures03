public class Inventory
{
   private int numberItem;
   private double costItem;
   
   public void setNumberItem(int n)
   {
      numberItem = n;
   }
   
   public void setCostItem(double c)
   {
      costItem = c;
   }
   
   public int getNumberItem()
   {
      return numberItem;
   }
   
   public double getCostItem()
   {
      return costItem;
   }
   
   public String toString()
   {
      return  numberItem + " at " + "$" + costItem;
   }
}