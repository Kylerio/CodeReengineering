package dead_code;

import java.util.*;

public class DiscountCalculator {
	public double setFinalPrice(int priceBefore) {
		
		double finalPrice=0;
		
		//Setelah toko baju lumayan lama berdiri, pengunjung semakin sedikit dan diskon baju itu 10% untuk semua item
		finalPrice = priceBefore - (priceBefore*0.1);
		
		return finalPrice;
	}
}
