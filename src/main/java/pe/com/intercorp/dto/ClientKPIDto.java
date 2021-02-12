package pe.com.intercorp.dto;

public class ClientKPIDto {
	private Double averageAge;
	private Double starndarDeviationOfAge;
	
	public ClientKPIDto() {
		super();
	}

	public ClientKPIDto(Double averageAge, Double starndarDeviationOfAge) {
		super();
		this.averageAge = averageAge;
		this.starndarDeviationOfAge = starndarDeviationOfAge;
	}
	

	public Double getAverageAge() {
		return averageAge;
	}
	public void setAverageAge(Double averageAge) {
		this.averageAge = averageAge;
	}
	public Double getStarndarDeviationOfAge() {
		return starndarDeviationOfAge;
	}
	public void setStarndarDeviationOfAge(Double starndarDeviationOfAge) {
		this.starndarDeviationOfAge = starndarDeviationOfAge;
	}
	
}
