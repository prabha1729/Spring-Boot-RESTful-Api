package com.contacts.restapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.contacts.restapi.entity.Phone;

@RepositoryRestResource(collectionResourceRel = "phones", path = "phones")
public interface PhoneRepository extends CrudRepository<Phone, String> {
    
}