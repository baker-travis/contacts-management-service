package com.bakercreations.contacts.contactmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bakercreations.contacts.contactmanager.entities.Contact;

import org.springframework.stereotype.Component;

@Component
public class ContactsRepository {
    private Map<String, Contact> contacts;

    public ContactsRepository() {
        this.contacts = new HashMap<>();
    }

    public Contact addContact(Contact toAdd) throws Error {
        if (toAdd == null) {
            throw new Error("Invalid contact");
        }
        String uuid = UUID.randomUUID().toString();
        toAdd.setUuid(uuid);
        
        contacts.put(uuid, toAdd);

        return toAdd;
    }

    public List<Contact> getContacts() {
        return new ArrayList<>(contacts.values());
    }

    // TODO: When implementing updates, uncomment
    // public Contact updateContact(String uuid, Contact updatedContact) throws Error {
    //     if (uuid != updatedContact.getUuid()) {
    //         throw new Error("uuid's do not match");
    //     }

    //     contacts.put(uuid, updatedContact);
    //     return updatedContact;
    // }

    public void deleteContact(String uuid) {
        // TODO: if contact doesn't exist, throw error
        contacts.remove(uuid);
    }
}