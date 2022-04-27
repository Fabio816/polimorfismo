package entities;

public class ImportedProduct extends Product{
	
	private Double customsFee;
	
	@Override
	public final String PriceTag() {
		return name + " $ " + String.format("%.2f", price) + "(Customs fee: $" + String.format("%.2f", customsFee) + ")";
	}
	
	public Double TotalPrice() {
		return price + customsFee;
	}

	public ImportedProduct() {
		super();
	}
	
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	
	

}
