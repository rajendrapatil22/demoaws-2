package com.in28minutes.rest.webservices.restfulwebservices;

public class Result {
	private Integer id;
	private String testCaseName;
public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getResponse() {
		return Response;
	}
	public void setResponse(Object response) {
		this.Response = response;
	}
private String status;
private Object Response;

}
