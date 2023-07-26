package model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Application {

	private int appid;
	private String status_app;
	private String purpose;
	private int total_asset;
	private Date datereturned;
	private Date startdateloan;
	private String asset_status;
	private int assetid;
	private int staffid;
	private String modelName;
	
	public Application() {
		
	}
	
	public String getLoanPeriodDetails() {
		
		LocalDate currentDate = datereturned.toLocalDate();
		LocalDate purchaseDate = startdateloan.toLocalDate();

		Period period = Period.between(purchaseDate, currentDate);
		return period.getDays() + " Days";
		
	}
	
	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String model) {
		this.modelName = model;
	}

	public int getAppid() {
		return appid;
	}

	public void setAppid(int appid) {
		this.appid = appid;
	}

	public String getStatus_app() {
		return status_app;
	}

	public void setStatus_app(String status_app) {
		this.status_app = status_app;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public int getTotal_asset() {
		return total_asset;
	}

	public void setTotal_asset(int total_asset) {
		this.total_asset = total_asset;
	}

	public Date getDatereturned() {
		return datereturned;
	}

	public void setDatereturned(Date datereturned) {
		this.datereturned = datereturned;
	}

	public Date getStartdateloan() {
		return startdateloan;
	}

	public void setStartdateloan(Date startdateloan) {
		this.startdateloan = startdateloan;
	}

	public String getAsset_status() {
		return asset_status;
	}

	public void setAsset_status(String asset_status) {
		this.asset_status = asset_status;
	}

	public int getAssetid() {
		return assetid;
	}

	public void setAssetid(int assetid) {
		this.assetid = assetid;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	
}
