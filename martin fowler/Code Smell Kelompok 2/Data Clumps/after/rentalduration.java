package data_clumps.after;

import java.util.*;

public class RentalDuration {
	private Date start;
	private Date end;
	
	public Rental(Date start, Date end) {
		if(start.after(end)) {
			throw new IllegalArgumentException("Start Date must be before End Date");
			
		}
		this.start = start;
		this.end = end;
	}

	
	public Date getStart() {
		return start;
	}
	
	public Date getEnd() {
		return end;
	}
}
