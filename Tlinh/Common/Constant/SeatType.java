package Constant;

public enum SeatType {
	HS("HS","310000"),
	SS("SS","335000"),
	SSC("SSC","360000"),
	HB("HB","410000"),
	SB("SB","460000"),
	SBC("SBC","510000");
	private String seatTypeCode;
	private String price;
	public String getSeatTypeCode() {
		return seatTypeCode;
	}
	public void setSeatTypeCode(String seatTypeCode) {
		this.seatTypeCode = seatTypeCode;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	SeatType(String seatTypeCode, String price)
	{
		this.seatTypeCode=seatTypeCode;
		this.price=price;
	}
}
