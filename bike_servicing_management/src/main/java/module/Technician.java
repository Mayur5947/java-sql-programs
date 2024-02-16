package module;

public class Technician {

	private int technician_id;
	private String first_name;
	private String last_name;
	private String specialization;

	public int getTechnician_id() {
		return technician_id;
	}

	public void setTechnician_id(int technician_id) {
		this.technician_id = technician_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Technician [technician_id=" + technician_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", specialization=" + specialization + "]";
	}

}
