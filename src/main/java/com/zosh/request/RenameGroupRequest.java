package com.zosh.request;

public class RenameGroupRequest {

	private String groupName;

	public RenameGroupRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public RenameGroupRequest(String groupName) {
		super();
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
