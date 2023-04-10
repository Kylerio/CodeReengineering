
public class Main {

	public static void main(String[] args) {
		Customer cs = new Customer("Budi", 20, new Credit(20));
		cs.printDetails();
	}

}
