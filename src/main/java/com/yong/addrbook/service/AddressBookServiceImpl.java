package com.yong.addrbook.service;

import com.yong.addrbook.domain.AddressBook;
import com.yong.addrbook.domain.BookCase;
import com.yong.addrbook.domain.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yongliu on 30/7/18.
 */
public class AddressBookServiceImpl implements AddressBookService {

    Logger LOG = Logger.getLogger(this.getClass().getName());


    @Override
    public void addContactToAddressBook(AddressBook addressBook, Contact contact) {

        if (addressBook.getContacts().stream().noneMatch(ct -> ct.equals(contact))) {
            addressBook.getContacts().add(contact);
        } else {
            String message = String.format("Contact [%s, %s] has already in AddressBook [%s].", contact.getName(), contact.getPhoneNumber(), addressBook.getId());
            LOG.log(Level.WARNING, message);
        }
    }

    @Override
    public void addContactsToAddressBook(AddressBook addressBook, List<Contact> contacts) {
        for (Contact contact : contacts) {
            addContactToAddressBook(addressBook, contact);
        }
    }

    @Override
    public void removeContactFromAddressBook(AddressBook addressBook, Contact contact) {
        boolean result = addressBook.getContacts().remove(contact);
        if (!result) {
            String message = String.format("Contact [%s, %s] is NOT in AddressBook [%s].", contact.getName(), contact.getPhoneNumber(), addressBook.getId());
            LOG.log(Level.WARNING, message);
        }

    }

    @Override
    public void removeContactsFromAddressBook(AddressBook addressBook, List<Contact> contacts) {
        for (Contact contact : contacts) {
            removeContactFromAddressBook(addressBook, contact);
        }
    }

    @Override
    public void addAddressBook(BookCase bookCase, AddressBook addressBook) {
        bookCase.getAddressBooks().add(addressBook);

    }

    @Override
    public void removeAddressBook(BookCase bookCase,AddressBook addressBook) {
        bookCase.getAddressBooks().remove(addressBook);
    }

    @Override
    public String printAddressBook(AddressBook addressBook) {

        StringBuilder sb = new StringBuilder();
        sb.append("Address Book List\n");
        for (Contact contact: addressBook.getContacts()) {
            sb.append(String.format("[Name: %s, PhoneNumber: %s]\n", contact.getName(), contact.getPhoneNumber()));

        }
        return sb.toString();
    }

    @Override
    public String printUniqueContacts(List<AddressBook> addressBooks) {

        AddressBook totalAddressBook = new AddressBook();

        for (AddressBook addressBook: addressBooks) {
            addContactsToAddressBook(totalAddressBook, addressBook.getContacts());
        }

        return printAddressBook(totalAddressBook);
    }

    @Override
    public AddressBook findAddressBookById(List<AddressBook> addressBooks, int id) {

        if (addressBooks != null) {
            return addressBooks.stream().filter(addressBook -> addressBook.getId() == id).findFirst().orElse(null);
        }
        return null;
    }
}
