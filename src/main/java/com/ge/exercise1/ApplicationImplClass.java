package com.ge.exercise1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApplicationImplClass extends Application{
	
	private Collection<UserImplClass> users =  new ArrayList<>();
	
	private List<GroupImplClass> groups = new ArrayList<>();

	public ApplicationImplClass() {
		
	}

	public ApplicationImplClass(String id, String name) {
		super(id, name);
	}

	@Override
	public Collection<UserImplClass> getUsers() {
		return this.users;
	}

	@Override
	public User getUser(String userId) {
		for(User eachUser: users){
			if(eachUser.getId().equals(userId)){
				return eachUser;
			}
		}
		return null;
	}

	@Override
	public Collection<GroupImplClass> getGroups() {
		return groups;
	}

	@Override
	public Group getGroup(String groupId) {
		for(Group eachGroup: groups){
			if(eachGroup.getId().equals(groupId)){
				eachGroup.size = 1;
				return eachGroup;
			}
		}
		return null;
	}


	@Override
	public String toString() {
		return "ApplicationImplClass [users=" + users + ", groups=" + groups + "]";
	}
	
}
