package com.contacts.restapi;

import com.contacts.restapi.entity.Address;
import com.contacts.restapi.entity.Contact;
import com.contacts.restapi.entity.Name;
import com.contacts.restapi.entity.Phone;
import com.contacts.restapi.repositories.AddressRepository;
import com.contacts.restapi.repositories.ContactRepository;
import com.contacts.restapi.repositories.NameRepository;
import com.contacts.restapi.repositories.PhoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootContactsApplication.class, args);
	}

}

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PhoneRepository phoneRepository;
	@Autowired
	private NameRepository nameRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Name n1 = new Name("def", "123","qq");
		nameRepository.save(n1);
		Address a1 = new Address("poiyt", "ajknkjbs", "zanakxn", "qwerty");
		addressRepository.save(a1);
		Phone p1 = new Phone("1234567890", "work");
		Phone p2 = new Phone("1234567890", "mobile");
		List<Phone> phoneList = Arrays.asList(p1, p2);
		phoneRepository.saveAll(phoneList);

		Contact c1 = new Contact(n1, a1, phoneList, "avshavsha@gmail.com");
		contactRepository.save(c1);
		
		Name n2 = new Name("def", "123","qq");
		nameRepository.save(n2);
		Address a2 = new Address("poiyt", "ajknkjbs", "zanakxn", "qwerty");
		addressRepository.save(a2);
		Phone p3 = new Phone("1234567890", "work");
		Phone p4 = new Phone("1234567890", "mobile");
//		phoneList.clear();
		phoneList = Arrays.asList(p3, p4);
		phoneRepository.saveAll(phoneList);

		Contact c2 = new Contact(n1, a1, phoneList, "avshavsha@gmail.com");
		contactRepository.save(c2);
		

	}
}

