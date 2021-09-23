package kenmodel;

import java.io.Serializable;

public class TourBean implements Serializable {
	private String tourId;
	private String tourName;
	private String place;
	private int price;
	private int numAdult;
	private int numChild;
	
	public String getTourId() {
		return tourId;
	}
	public void setTourId(String tourId) {
		this.tourId = tourId;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumAdult() {
		return numAdult;
	}
	public void setNumAdult(int numAdult) {
		this.numAdult = numAdult;
	}
	public int getNumChild() {
		return numChild;
	}
	public void setNumChild(int numChild) {
		this.numChild = numChild;
	}
	
	public int getNumPeople() {
		return numAdult + numChild;
	}
	
	public int getTotalAmount() {
		int adPrice = numAdult * price;
		int chPrice = numChild * price / 2;
		int totalPrice = adPrice + chPrice;
		
		if( getNumPeople() >= 4 ) {
			totalPrice = (int)(totalPrice * 0.9);
		}
		return totalPrice;
	}
	
}
