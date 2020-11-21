public interface InventoryControl
{
	// adds the specified number of units at the given price to the inventory system
	void purchase(int units, double unitCost);
   
	// removes the specified number of units from the system and 
	// returns the cost of the units sold.
	double sale(int units, double salePrice);  
   
    // returns the gross profit accumulated based on all purchases and sales to date.
	double grossProfit();
   
    // returns the total cost of inventory after all purchases and sales are recorded.
	double balance();
}
