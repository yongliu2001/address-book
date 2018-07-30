package com.yong.addrbook.service;

import com.yong.addrbook.domain.AddressBook;
import com.yong.addrbook.domain.BookCase;
import com.yong.addrbook.domain.Contact;

import java.util.List;

/**
 * Created by yongliu on 30/7/18.
 */
public interface AddressBookService {


    /**
     * Add a new contact to address book. If a contact exist in the address book,
     * the contact will be skipped to adding to address book
     *
     * @param addressBook address book object
     * @param contact contact object
     */
    void addContactToAddressBook(AddressBook addressBook, Contact contact);

    /**
     * Add contact entries to address book. If a contact exist in the address book, the contact will be skipped.
     * the add will continue.
     *
     * @param addressBook address book object
     * @param contacts list of contacts
     */
    void addContactsToAddressBook(AddressBook addressBook, List<Contact> contacts);

    /**
     * Remove a contact From address book
     * @param addressBook address book object
     * @param contact contact object
     */
    void removeContactFromAddressBook(AddressBook addressBook, Contact contact);

    /**
     * Remove contacts From address book
     * @param addressBook address book object
     * @param contacts list of contact
     */
    void removeContactsFromAddressBook(AddressBook addressBook, List<Contact> contacts);

    /**
     * Add a new address book to book case
     * @param bookCase book case object
     * @param addressBook address object
     */
    void addAddressBook(BookCase bookCase, AddressBook addressBook);

    /**
     * remove a address book from book case
     * @param bookCase book case object
     * @param addressBook address book object
     */
    void removeAddressBook(BookCase bookCase, AddressBook addressBook);

    /**
     * print the contacts of an address book
     * @param addressBook address book object
     * @return outputString
     */
    String printAddressBook(AddressBook addressBook);

    /**
     * print unique contacts in you address books
     * @param addressBooks list of address books
     * @return outputString
     */
    String printUniqueContacts(List<AddressBook> addressBooks);

    AddressBook findAddressBookById(List<AddressBook> addressBooks, int id);

}
