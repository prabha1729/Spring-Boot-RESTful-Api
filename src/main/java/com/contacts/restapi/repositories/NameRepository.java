package com.contacts.restapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.contacts.restapi.entity.Name;

@RepositoryRestResource(collectionResourceRel = "names", path = "names")
public interface NameRepository extends CrudRepository<Name, String> {
    
}