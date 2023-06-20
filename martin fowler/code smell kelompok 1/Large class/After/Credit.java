
public class Credit {
	private int amount;
	
	public Credit(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public boolean hasCredit() {
		return amount > 0;
	}
}
