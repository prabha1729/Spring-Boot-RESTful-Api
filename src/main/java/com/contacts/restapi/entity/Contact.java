package com.contacts.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private String contactId;
	private Name name;
	@Column(name = "address", columnDefinition = "LONGTEXT")
	private Address address;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Phone> phones;
	private String email;

	public Contact() {
		super();
	}
	public Contact(Name name, Address address, List<Phone> phones, String email) {
		super();
		this.name = name;
		this.address = address;
		this.phones = phones;
		this.email = email;
	}

	public String getContact_id() {
		return contactId;
	}

	public void setContact_id(String contactId) {
		this.contactId = contactId;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact {contactId=" + contactId + ", name=" + name + ", address=" + address + ", phones=" + phones
				+ ", email=" + email + "}";
	}

}
