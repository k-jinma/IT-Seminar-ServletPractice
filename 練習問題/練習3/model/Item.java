package model;

public class Item {
	private int no;
	private String name;
	private int price;
	private String detail;
	private String fname;

	public Item(int no, String name, int price, String detail, String fname) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.fname = fname;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
}
