package edu.escuelaing.arep.controller;

public enum StatusResponse {

	SUCCESS ("Success"),
    ERROR ("Error");
  
    private String status;     

    private StatusResponse(String status) {
		this.status = status;
	}
    
	private StatusResponse() {
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
