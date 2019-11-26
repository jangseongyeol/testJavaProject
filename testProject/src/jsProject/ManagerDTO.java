package jsProject;

public class ManagerDTO {
	
	private String managerid, managerpwd;

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public String getManagerpwd() {
		return managerpwd;
	}

	public void setManagerpwd(String managerpwd) {
		this.managerpwd = managerpwd;
	}

	@Override
	public String toString() {
		return "ManagerDTO [managerid=" + managerid + ", managerpwd=" + managerpwd + "]";
	}

	public ManagerDTO(String managerid, String managerpwd) {
		super();
		this.managerid = managerid;
		this.managerpwd = managerpwd;
	}

	public ManagerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ManagerDTO(String managerid) {
		super();
		this.managerid = managerid;
		this.managerpwd = managerpwd;
	}
	
	

}
