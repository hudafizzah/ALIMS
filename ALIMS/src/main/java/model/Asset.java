package model;
import java.sql.*;

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




}
