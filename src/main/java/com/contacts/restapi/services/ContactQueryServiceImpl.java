package com.contacts.restapi.services;

import com.contacts.restapi.dto.ContactQueryDTO;
import com.contacts.restapi.entity.Contact;
import com.contacts.restapi.repositories.AddressRepository;
import com.contacts.restapi.repositories.ContactRepository;
import com.contacts.restapi.repositories.NameRepository;
import com.contacts.restapi.repositories.PhoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@Service
public class ContactQueryServiceImpl implements ContactQueryService {

	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PhoneRepository phoneRepository;
	@Autowired
	private NameRepository nameRepository;

	@Override
	public ContactQueryDTO getContact(String contactId) {
		if (contactRepository.findByContactId(contactId).isPresent()) {
			Contact fetchedContact = contactRepository.findByContactId(contactId).get();
//            List<Phone> phonesList = new ArrayList<>();
			return new ContactQueryDTO(fetchedContact.getContact_id(), fetchedContact.getAddress(),
					fetchedContact.getName(), fetchedContact.getPhones(), fetchedContact.getEmail());
		} else {
			return null;
		}
	}

	@Override
	public List<ContactQueryDTO> listAllContacts() {
		List<ContactQueryDTO> contactsList = new ArrayList<>();
		
		contactRepository.findAll().forEach(fetchedContact -> {
			System.out.println(fetchedContact.getPhones());
			contactsList.add(new ContactQueryDTO(fetchedContact.getContact_id(), fetchedContact.getAddress(),
					fetchedContact.getName(), fetchedContact.getPhones(), fetchedContact.getEmail()));
		});

		return contactsList;
	}

	@Override
	public boolean deleteContact(String id) {
		if (contactRepository.findByContactId(id).isPresent()) {
			contactRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public ContactQueryDTO updateContact(String id,@Valid Contact contactDetails) {
		if (contactRepository.findByContactId(id).isPresent()) {
			Contact fetchedContact = contactRepository.findByContactId(id).get();
			fetchedContact.setName(contactDetails.getName());
			fetchedContact.setAddress(contactDetails.getAddress());
			fetchedContact.setEmail(contactDetails.getEmail());
			phoneRepository.saveAll(contactDetails.getPhones());
			fetchedContact.setPhones(contactDetails.getPhones());
			contactRepository.save(fetchedContact);
			return new ContactQueryDTO(fetchedContact.getContact_id(), fetchedContact.getAddress(),
					fetchedContact.getName(), fetchedContact.getPhones(), fetchedContact.getEmail());
		}
		else 
			return null;
	}

	@Override
	public boolean createContact(@Valid Contact contactDetails) {
		if (!contactRepository.findByContactId(contactDetails.getContact_id()).isPresent()) {
			nameRepository.save(contactDetails.getName());
			addressRepository.save(contactDetails.getAddress());
			phoneRepository.saveAll(contactDetails.getPhones());
			contactRepository.save(contactDetails);
			return true;
		}
		else 
			return false;
	}
}
