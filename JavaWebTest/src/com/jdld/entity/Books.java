package com.jdld.entity;
/**
 * @ 书本实体类
 * **/
public class Books {
	private String BID;
	private String BNAME;
	private String AUTHER;
	private double PRICE;
	private double CURRPRICE;
	private double DISCOUNT;
	private	String PRESS;
	private String PUBLISHTIME;
	private Integer EDITION;
	private Integer PAGNUM;
	private Integer WORDNUM;
	private String PRINTTIME;
	private Integer BOOKSIZE;
	private String PAPER;
	private String CID;
	private String IMAGE_W;
	private String IMAGE_B;
	private Integer ORDERBY;
	private Integer SALESVOL;
	private Integer page;
	private Integer list;
	
	public String getBID() {
		return BID;
	}

	public void setBID(String bID) {
		BID = bID;
	}

	public String getBNAME() {
		return BNAME;
	}

	public void setBNAME(String bNAME) {
		BNAME = bNAME;
	}

	public String getAUTHER() {
		return AUTHER;
	}

	public void setAUTHER(String aUTHER) {
		AUTHER = aUTHER;
	}

	public double getPRICE() {
		return PRICE;
	}

	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}

	public double getCURRPRICE() {
		return CURRPRICE;
	}

	public void setCURRPRICE(double cURRPRICE) {
		CURRPRICE = cURRPRICE;
	}

	public double getDISCOUNT() {
		return DISCOUNT;
	}

	public void setDISCOUNT(double dISCOUNT) {
		DISCOUNT = dISCOUNT;
	}

	public String getPRESS() {
		return PRESS;
	}

	public void setPRESS(String pRESS) {
		PRESS = pRESS;
	}

	public String getPUBLISHTIME() {
		return PUBLISHTIME;
	}

	public void setPUBLISHTIME(String pUBLISHTIME) {
		PUBLISHTIME = pUBLISHTIME;
	}

	public Integer getEDITION() {
		return EDITION;
	}

	public void setEDITION(Integer eDITION) {
		EDITION = eDITION;
	}

	public Integer getPAGNUM() {
		return PAGNUM;
	}

	public void setPAGNUM(Integer pAGNUM) {
		PAGNUM = pAGNUM;
	}

	public Integer getWORDNUM() {
		return WORDNUM;
	}

	public void setWORDNUM(Integer wORDNUM) {
		WORDNUM = wORDNUM;
	}

	public String getPRINTTIME() {
		return PRINTTIME;
	}

	public void setPRINTTIME(String pRINTTIME) {
		PRINTTIME = pRINTTIME;
	}

	public Integer getBOOKSIZE() {
		return BOOKSIZE;
	}

	public void setBOOKSIZE(Integer bOOKSIZE) {
		BOOKSIZE = bOOKSIZE;
	}

	public String getPAPER() {
		return PAPER;
	}

	public void setPAPER(String pAPER) {
		PAPER = pAPER;
	}

	public String getCID() {
		return CID;
	}

	public void setCID(String cID) {
		CID = cID;
	}

	public String getIMAGE_W() {
		return IMAGE_W;
	}

	public void setIMAGE_W(String iMAGE_W) {
		IMAGE_W = iMAGE_W;
	}

	public String getIMAGE_B() {
		return IMAGE_B;
	}

	public void setIMAGE_B(String iMAGE_B) {
		IMAGE_B = iMAGE_B;
	}

	public Integer getORDERBY() {
		return ORDERBY;
	}

	public void setORDERBY(Integer oRDERBY) {
		ORDERBY = oRDERBY;
	}

	public Integer getSALESVOL() {
		return SALESVOL;
	}

	public void setSALESVOL(Integer sALESVOL) {
		SALESVOL = sALESVOL;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getList() {
		return list;
	}

	public void setList(Integer list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Books [BID=" + BID + ", BNAME=" + BNAME + ", AUTHER=" + AUTHER + ", PRICE=" + PRICE + ", CURRPRICE="
				+ CURRPRICE + ", DISCOUNT=" + DISCOUNT + ", PRESS=" + PRESS + ", PUBLISHTIME=" + PUBLISHTIME
				+ ", EDITION=" + EDITION + ", PAGNUM=" + PAGNUM + ", WORDNUM=" + WORDNUM + ", PRINTTIME=" + PRINTTIME
				+ ", BOOKSIZE=" + BOOKSIZE + ", PAPER=" + PAPER + ", CID=" + CID + ", IMAGE_W=" + IMAGE_W + ", IMAGE_B="
				+ IMAGE_B + ", ORDERBY=" + ORDERBY + ", SALESVOL=" + SALESVOL + ", page=" + page + ", list=" + list
				+ "]";
	}

	public Books(String bID, String bNAME, String aUTHER, double pRICE, double cURRPRICE, double dISCOUNT, String pRESS,
			String pUBLISHTIME, Integer eDITION, Integer pAGNUM, Integer wORDNUM, String pRINTTIME, Integer bOOKSIZE,
			String pAPER, String cID, String iMAGE_W, String iMAGE_B, Integer oRDERBY, Integer sALESVOL, Integer page,
			Integer list) {
		super();
		BID = bID;
		BNAME = bNAME;
		AUTHER = aUTHER;
		PRICE = pRICE;
		CURRPRICE = cURRPRICE;
		DISCOUNT = dISCOUNT;
		PRESS = pRESS;
		PUBLISHTIME = pUBLISHTIME;
		EDITION = eDITION;
		PAGNUM = pAGNUM;
		WORDNUM = wORDNUM;
		PRINTTIME = pRINTTIME;
		BOOKSIZE = bOOKSIZE;
		PAPER = pAPER;
		CID = cID;
		IMAGE_W = iMAGE_W;
		IMAGE_B = iMAGE_B;
		ORDERBY = oRDERBY;
		SALESVOL = sALESVOL;
		this.page = page;
		this.list = list;
	}

	public Books() {
		super();
	}
	
}
