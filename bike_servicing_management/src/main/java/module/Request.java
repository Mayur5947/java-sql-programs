package module;

public class Request {

	private int request_id;
	private String status;
	private String description;

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Request [request_id=" + request_id + ", status=" + status + ", description=" + description + "]";
	}

}
