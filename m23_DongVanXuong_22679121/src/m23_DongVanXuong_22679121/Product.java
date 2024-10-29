package m23_DongVanXuong_22679121;

import java.util.Objects;

public class Product {
	private String product_id;
	private String name;
	private String description;
	private String manufacture;
	private Supplier supplier;
	private double price;
	public Product(String product_id, String name, String description, String manufacture, Supplier supplier,
			double price) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.manufacture = manufacture;
		this.supplier = supplier;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", description=" + description
				+ ", manufacture=" + manufacture + ", supplier=" + supplier + ", price=" + price + "]";
	}

	
	
	
}
