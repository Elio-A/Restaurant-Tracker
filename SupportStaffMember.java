package project.g7;

public class SupportStaffMember {
	private String phoneNumber;
	private String name;
	
	public SupportStaffMember(String phoneNumber, String name) {
		this.phoneNumber = phoneNumber;
		this.name = name;
	}
	
	public boolean setPhoneNum(String phoneNumber) {
		boolean success = false;
		
		if(phoneNumber != null) {
			success = true;
			this.phoneNumber = phoneNumber;
		}
		
		return success;
	}
	
	public boolean setName(String name) {
		boolean success = false;
		
		if(name != null) {
			success = true;
			this.name = name;
		}
		
		return success;
	}
	
	public String getPhoneNum() {
		return phoneNumber;
	}
	
	public String getName() {
		return name;
	}
}
