package com.contacts.restapi.services;

import java.util.List;
import javax.validation.Valid;

import com.contacts.restapi.dto.ContactQueryDTO;
import com.contacts.restapi.entity.Contact;

public interface ContactQueryService {

    public ContactQueryDTO getContact(String contact_id);
    public List<ContactQueryDTO> listAllContacts();
	public boolean deleteContact(String id);
	public ContactQueryDTO updateContact(String id, @Valid Contact contactDetails);
	public boolean createContact(@Valid Contact contactDetails);
}
