package jsProject;

public class JsFastFoodDTO {
	
	private int itemnum;
	private String menuname;
	private double price;
	private int amount;
	

	public int getItemnum() {
		return itemnum;
	}

	public void setItemnum(int itemnum) {
		this.itemnum = itemnum;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

	@Override
	public String toString() {
		return "JsFastFoodDTO [itemnum=" + itemnum + ", menuname=" + menuname + ", price=" + price + ", amount="
				+ amount + "]";
	}

	
	
	public JsFastFoodDTO(int itemnum, String menuname, double price, int amount) {
		super();
		this.itemnum = itemnum;
		this.menuname = menuname;
		this.price = price;
		this.amount = amount;
	}

	public JsFastFoodDTO(String menuname, double price, int amount) {
		super();
		this.menuname = menuname;
		this.price = price;
		this.amount = amount;
	}

	public JsFastFoodDTO(String menuname, double price) {
		super();
		this.menuname = menuname;
		this.price = price;
	}
	
	public JsFastFoodDTO(String menuname, int amount) {
		super();
		this.menuname = menuname;
		this.amount = amount;
	}
	
	public JsFastFoodDTO(String menuname) {
		super();
		this.menuname = menuname;
		this.price = price;
	}

	public JsFastFoodDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
