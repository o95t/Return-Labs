package Product;

public class Product {
	
	private int productId;
	private String name;
	private String dateSupplied;
	private double unitPrice;
	
	public Product(int productId, String name, String dateSupplied, double unitPrice) {
		this.productId = productId;
		this.name = name;
		this.dateSupplied = dateSupplied;
		this.unitPrice = unitPrice;
	}
		
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateSupplied() {
		return dateSupplied;
	}
	public void setDateSupplied(String dateSupplied) {
		this.dateSupplied = dateSupplied;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
