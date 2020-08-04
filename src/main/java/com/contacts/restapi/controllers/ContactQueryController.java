package com.contacts.restapi.controllers;

import com.contacts.restapi.dto.ContactQueryDTO;
import com.contacts.restapi.entity.Contact;
import com.contacts.restapi.services.ContactQueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/contacts")
public class ContactQueryController {

    @Autowired
    private ContactQueryService contactQueryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ContactQueryDTO>> listAllContacts(){
        return new ResponseEntity<>(contactQueryService.listAllContacts(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContactQueryDTO> getContact(@PathVariable(value = "id") String id){
    	if(contactQueryService.getContact(id)!=null)
        	return new ResponseEntity<>(contactQueryService.getContact(id), HttpStatus.OK);
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteContact(@PathVariable(value = "id") String id){
    	boolean flag = contactQueryService.deleteContact(id);
    	return flag?new ResponseEntity<>(HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContactQueryDTO> updateContact(@PathVariable(value = "id") String id,  @Valid @RequestBody Contact contactDetails){
    	return new ResponseEntity<>(contactQueryService.updateContact(id,contactDetails), HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createContact(@Valid @RequestBody Contact contactDetails){
    	boolean flag = contactQueryService.createContact(contactDetails);
    	return flag?new ResponseEntity<>(HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
}
