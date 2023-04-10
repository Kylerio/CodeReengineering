import java.util.ArrayList;
import java.util.List;

public class TotalCalculator {
	private List<Item> items;
	private double totalPrice;
	
	public TotalCalculator(List<Item> items) {
		this.items = items;
		this.totalPrice = 0.0;
		
		for(Item item : items) {
			totalPrice += item.getPrice();
		}
	}
	
	public void updateTotalPrice(double price) {
		totalPrice += price;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
}
