package com.bakercreations.contacts.contactmanager;

import static org.assertj.core.api.Assertions.assertThat;

import com.bakercreations.contacts.contactmanager.entities.Contact;
import com.bakercreations.contacts.contactmanager.exceptions.ContactNotFoundException;
import com.bakercreations.contacts.contactmanager.exceptions.InvalidContactException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactsRepositoryTests {
    private ContactsRepository contactsRepo;

    @Before
    public void setUp() {
        contactsRepo = new ContactsRepository();
    }

    @Test
    public void createsEmptyList() {
        assertThat(contactsRepo.getContacts().size()).isEqualTo(0);
    }

    @Test
    public void addContactSuccess() {
        Contact contact = setUpContact();
        contactsRepo.addContact(contact);

        assertThat(contactsRepo.getContacts().size()).isEqualTo(1);
        assertThat(contact.getUuid()).isNotBlank();
    }

    @Test(expected = InvalidContactException.class)
    public void addContactFailure() throws Error {
        contactsRepo.addContact(null);
        assertThat(contactsRepo.getContacts()).isEmpty();
    }

    @Test
    public void deleteContact() {
        Contact contact = setUpContact();
        contactsRepo.addContact(contact);

        assertThat(contactsRepo.getContacts().size()).isEqualTo(1);
        assertThat(contact.getUuid()).isNotBlank();

        contactsRepo.deleteContact(contact.getUuid());
        assertThat(contactsRepo.getContacts()).isEmpty();
    }

    @Test(expected = ContactNotFoundException.class)
    public void deleteContactThatDoesntExist() {
        contactsRepo.deleteContact("someRandomUuidThatDoesntExist");
    }

    private Contact setUpContact() {
        Contact contact = new Contact();
        contact.setFirstName("Johnny");
        contact.setLastName("Doe");
        contact.setEmail("johnny.doe@intuit.com");
        contact.setPhone("4691234567");
        contact.setStreet("123 Main St");
        contact.setCity("Plano");
        contact.setState("TX");
        contact.setZip("75083");
        return contact;
    }
}