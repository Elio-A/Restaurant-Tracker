package project.g7;

public class SystemAdministrator {
	private String trainingDate;
	private final String PASSWORD;
	
	public SystemAdministrator(String trainingDate, String passwordIn) {
		this.trainingDate = trainingDate;
		PASSWORD = passwordIn;
	}
	
	public boolean setTrainingDate(String trainingDate) {
		boolean success = false;
		
		if(trainingDate != null) {
			success = true;
			this.trainingDate = trainingDate;
		}
		
		return success;
	}
	
	public String getTrainingDate() {
		return trainingDate;
	}
	
	public String getPassword() {
		return PASSWORD;
	}
}
