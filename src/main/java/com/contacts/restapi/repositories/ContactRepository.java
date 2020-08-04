package com.contacts.restapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.contacts.restapi.entity.Contact;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface ContactRepository extends CrudRepository<Contact, String> {

    List<Contact> findByEmail(@Param("email") String email);

	Optional<Contact> findByContactId(String contactId);
    
}
