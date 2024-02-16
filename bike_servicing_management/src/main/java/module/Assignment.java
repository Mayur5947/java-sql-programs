package module;

public class Assignment {

	private int assignment_id;
	private String status;
	private String date;

	public int getAssignment_id() {
		return assignment_id;
	}

	public void setAssignment_id(int assignment_id) {
		this.assignment_id = assignment_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Assignment [assignment_id=" + assignment_id + ", status=" + status + ", date=" + date + "]";
	}

}
