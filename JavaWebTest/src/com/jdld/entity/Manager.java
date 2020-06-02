package com.jdld.entity;

public class Manager {
	private String IDU;
	private String LOGINNAME;
	private String LOGINPASS;
	private boolean login;
	
	public String getIDU() {
		return IDU;
	}

	public void setIDU(String iDU) {
		IDU = iDU;
	}

	public String getLOGINNAME() {
		return LOGINNAME;
	}

	public void setLOGINNAME(String lOGINNAME) {
		LOGINNAME = lOGINNAME;
	}

	public String getLOGINPASS() {
		return LOGINPASS;
	}

	public void setLOGINPASS(String lOGINPASS) {
		LOGINPASS = lOGINPASS;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Manager [IDU=" + IDU + ", LOGINNAME=" + LOGINNAME + ", LOGINPASS=" + LOGINPASS + ", login=" + login
				+ "]";
	}

	public Manager(String iDU, String lOGINNAME, String lOGINPASS, boolean login) {
		super();
		IDU = iDU;
		LOGINNAME = lOGINNAME;
		LOGINPASS = lOGINPASS;
		this.login = login;
	}

	public Manager() {
		super();
	}
	
}
