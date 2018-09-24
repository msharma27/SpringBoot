package org.learn.java;

import java.io.Serializable;

public class Book implements Serializable {
 
	private static final long serialVersionUID = 4300002660428133001L;
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
	
	public Book(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Book()
	{
		super();
	}

	
	
	
}
