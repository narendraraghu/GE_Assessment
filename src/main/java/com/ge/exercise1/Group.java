package com.ge.exercise1;

import java.util.ArrayList;
import java.util.List;

public abstract class Group {
    private String id;
    private String name;
    
    public Group() {
		super();
	}

	private List<UserImplClass> users =  new ArrayList<>();
    
    public Group(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
	public List<UserImplClass> getUsers() {
		return users;
	}

	public void setUsers(List<UserImplClass> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", users=" + users + ", size=" + size + "]";
	}

	public int size;

}
