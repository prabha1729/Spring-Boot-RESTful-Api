package com.contacts.restapi.dto;

import java.util.List;
import com.contacts.restapi.entity.Address;
import com.contacts.restapi.entity.Name;
import com.contacts.restapi.entity.Phone;

public class ContactQueryDTO {

	private String id;
	private Address address;
	private Name name;
	private List<Phone> phones;
	private String email;
	
	public ContactQueryDTO() {
		super();
	}
	
	public ContactQueryDTO(String id, Address address, Name name, List<Phone> phones, String email) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.phones = phones;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}
	public Name getName() {
		return name;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ContactQueryDTO {id=" + id + ", address=" + address + ", name=" + name + ", phones=" + phones
				+ ", email=" + email + "}";
	}

	
}
