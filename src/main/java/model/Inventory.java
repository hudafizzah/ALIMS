package model;

public class Inventory {

	private int id;
	private String modelName;
	private String manufacturer;
	private int totalAssets;
	
	public Inventory() {
		
	}

	public Inventory(int id, String modelName, String manufacturer, int totalAssets) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.manufacturer = manufacturer;
		this.totalAssets = totalAssets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(int totalAssets) {
		this.totalAssets = totalAssets;
	}
	
	public String getCompleteName() {
		return manufacturer + " " + modelName;
	}
	
}
