package com.jdld.entity;
/**
 * @对应购物车表
 * @author q1942
 *
 */
public class ShoppMsg {
	private String ORDERITEMID;//主键,即对于用户uid
	private Integer QUANTITY;//数量
	private Integer SUBTOTAL;//小计
	private String BID;//书本id
	private String BNAME;//图书名称
	private Integer CURRPRICE;//图书当前价
	private String IMAGE_B;//图书小图路径
	private String OID;//所属订单号
	private String HAS;//删除状态
	
	public String getHAS() {
		return HAS;
	}

	public void setHAS(String hAS) {
		HAS = hAS;
	}

	public String getORDERITEMID() {
		return ORDERITEMID;
	}

	public void setORDERITEMID(String oRDERITEMID) {
		ORDERITEMID = oRDERITEMID;
	}

	public Integer getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(Integer qUANTITY) {
		QUANTITY = qUANTITY;
	}

	public Integer getSUBTOTAL() {
		return SUBTOTAL;
	}

	public void setSUBTOTAL(Integer sUBTOTAL) {
		SUBTOTAL = sUBTOTAL;
	}

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

	public Integer getCURRPRICE() {
		return CURRPRICE;
	}

	public void setCURRPRICE(Integer cURRPRICE) {
		CURRPRICE = cURRPRICE;
	}

	public String getIMAGE_B() {
		return IMAGE_B;
	}

	public void setIMAGE_B(String iMAGE_B) {
		IMAGE_B = iMAGE_B;
	}

	public String getOID() {
		return OID;
	}

	public void setOID(String oID) {
		OID = oID;
	}

	

	@Override
	public String toString() {
		return "ShoppMsg [ORDERITEMID=" + ORDERITEMID + ", QUANTITY=" + QUANTITY + ", SUBTOTAL=" + SUBTOTAL + ", BID="
				+ BID + ", BNAME=" + BNAME + ", CURRPRICE=" + CURRPRICE + ", IMAGE_B=" + IMAGE_B + ", OID=" + OID
				+ ", HAS=" + HAS + "]";
	}

	public ShoppMsg(String oRDERITEMID, Integer qUANTITY, Integer sUBTOTAL, String bID, String bNAME, Integer cURRPRICE,
			String iMAGE_B, String oID, String hAS) {
		super();
		ORDERITEMID = oRDERITEMID;
		QUANTITY = qUANTITY;
		SUBTOTAL = sUBTOTAL;
		BID = bID;
		BNAME = bNAME;
		CURRPRICE = cURRPRICE;
		IMAGE_B = iMAGE_B;
		OID = oID;
		HAS = hAS;
	}

	public ShoppMsg() {
		super();
	}
	
}
