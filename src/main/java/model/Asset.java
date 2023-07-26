package model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Asset {

	private int AssetID;
	private Date asset_datepurchase;
	private String modelname;
	private String manufacturer;
	private int inventoryid;
	private int StaffID;

//constructor:to initialize the object
	public Asset() {

	}

	public int getYearsSincePurchase() {
		LocalDate currentDate = LocalDate.now();
		LocalDate purchaseDate = asset_datepurchase.toLocalDate();

		Period period = Period.between(purchaseDate, currentDate);
		return period.getYears();
	}
	
	public String getCompleteAssetString() {
		return manufacturer + " " + modelname + " - " + AssetID;
	}

	public int getAssetID() {
		return AssetID;
	}

	public void setAssetID(int assetID) {
		AssetID = assetID;
	}

	public Date getAsset_datepurchase() {
		return asset_datepurchase;
	}

	public void setAsset_datepurchase(Date asset_datepurchase) {
		this.asset_datepurchase = asset_datepurchase;
	}

	public int getInventoryid() {
		return inventoryid;
	}

	public void setInventoryid(int inventoryid) {
		this.inventoryid = inventoryid;
	}

	public int getStaffID() {
		return StaffID;
	}

	public void setStaffID(int staffID) {
		StaffID = staffID;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	

}
