package com.bakercreations.contacts.contactmanager;

import java.util.ArrayList;
import java.util.List;

import com.bakercreations.contacts.contactmanager.entities.Contact;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @RequestMapping(path="/contacts", method=RequestMethod.GET)
    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        Contact contactToAdd = new Contact();
        contactToAdd.setFirstName("Travis");
        contactToAdd.setLastName("Baker");
        contactToAdd.setCity("Little Elm");
        contactToAdd.setEmail("baker.travis.w@gmail.com");
        contactToAdd.setPhone("8325175400");
        contactToAdd.setState("TX");
        contactToAdd.setStreet("1824 Megan Creek Dr");
        contactToAdd.setUuid("1");
        contactToAdd.setZip("75068");
        contacts.add(contactToAdd);
        return contacts;
    }

    @RequestMapping(path="/contacts", method=RequestMethod.POST)
    public Contact addNewContact() {
        return new Contact();
    }

    @RequestMapping(path="/contacts", method=RequestMethod.PUT)
    public Contact updateContact() {
        return new Contact();
    }

    @RequestMapping(path="/contacts", method=RequestMethod.DELETE)
    public void removeContact() {

    }
}