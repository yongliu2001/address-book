package com.yong.addrbook.service;

import com.yong.addrbook.domain.AddressBook;
import com.yong.addrbook.domain.BookCase;
import com.yong.addrbook.domain.Contact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongliu on 30/7/18.
 */
public class AddressBookServiceImplTest {

    private static final int FIRST_ADDRESS_BOOK_ID = 1;
    private static final int SECOND_ADDRESS_BOOK_ID = 2;

    private AddressBookService addressBookService;

    private BookCase bookCase;

    private AddressBook addressBook;


    @Before
    public void setUp() throws Exception {
        addressBookService = new AddressBookServiceImpl();
        bookCase = initAddressBookCase();
        addressBook = addressBookService.findAddressBookById(bookCase.getAddressBooks(), FIRST_ADDRESS_BOOK_ID);
    }

    @Test
    public void testAddContactToAddressBook() throws Exception {
        System.out.println("testAddContactToAddressBook");

        Contact lee = new Contact("Lee", "3456789");
        addressBookService.addContactToAddressBook(addressBook, lee);

        Assert.assertEquals(3, addressBook.getContacts().size());
    }

    @Test
    public void testAddContactToAddressBookWithDuplicate() throws Exception {
        System.out.println("testAddContactToAddressBookWithDuplicate");

        Contact lee = new Contact("Lee", "3456789");
        Contact lee1 = new Contact("Lee", "3456789");

        addressBookService.addContactToAddressBook(addressBook, lee);
        addressBookService.addContactToAddressBook(addressBook, lee1);
        Assert.assertEquals(3, addressBook.getContacts().size());

        Contact lee2 = new Contact("Lee", "3456780");
        addressBookService.addContactToAddressBook(addressBook, lee2);
        Assert.assertEquals(4, addressBook.getContacts().size());
    }

    @Test
    public void testAddContactsToAddressBook() throws Exception {
        System.out.println("testAddContactsToAddressBook");

        Contact lee = new Contact("Lee", "3456789");
        Contact james = new Contact("James", "1234567");

        List<Contact> contactList = new ArrayList<>();

        contactList.add(lee);
        contactList.add(james);

        addressBookService.addContactsToAddressBook(addressBook, contactList);
        Assert.assertEquals(3, addressBook.getContacts().size());
    }

    @Test
    public void testRemoveContactFromAddressBook() throws Exception {
        System.out.println("testRemoveContactFromAddressBook");

        Contact james = new Contact("James", "1234567");
        addressBookService.removeContactFromAddressBook(addressBook, james);

        Assert.assertEquals(1, addressBook.getContacts().size());

        Contact lee = new Contact("Lee", "3456789");
        addressBookService.removeContactFromAddressBook(addressBook, james);

        Assert.assertEquals(1, addressBook.getContacts().size());

    }

    @Test
    public void testRemoveContactsFromAddressBook() throws Exception {
        System.out.println("testRemoveContactsFromAddressBook");

        Contact james = new Contact("James", "1234567");
        Contact mark = new Contact("Mark", "2345678");
        Contact lee = new Contact("Lee", "3456789");

        List<Contact> contactList = new ArrayList<>();
        contactList.add(james);
        contactList.add(mark);
        contactList.add(lee);

        addressBookService.removeContactsFromAddressBook(addressBook, contactList);

        Assert.assertEquals(0, addressBook.getContacts().size());

    }

    @Test
    public void testAddAddressBook() throws Exception {
        System.out.println("testAddAddressBook");

        AddressBook secondAddressBook = createSecondAddressBook();
        addressBookService.addAddressBook(bookCase, secondAddressBook);

        Assert.assertEquals(2, bookCase.getAddressBooks().size());

        AddressBook addressBook2 = addressBookService.findAddressBookById(bookCase.getAddressBooks(), SECOND_ADDRESS_BOOK_ID);
        Assert.assertEquals(3, addressBook2.getContacts().size());


    }

    @Test
    public void testRemoveAddressBook() throws Exception {
        System.out.println("testRemoveAddressBook");

        AddressBook removeAddressBook = addressBookService.findAddressBookById(bookCase.getAddressBooks(), FIRST_ADDRESS_BOOK_ID);

        if (removeAddressBook != null) {
            addressBookService.removeAddressBook(bookCase,removeAddressBook);
        }

        Assert.assertEquals(0, bookCase.getAddressBooks().size());

    }

    @Test
    public void testPrintAddressBook() throws Exception {
        System.out.println("testPrintAddressBook");

        String expectedOutput = "Address Book List\n" +  "[Name: James, PhoneNumber: 1234567]\n" + "[Name: Mark, PhoneNumber: 2345678]\n";

        String output = addressBookService.printAddressBook(addressBook);

        Assert.assertEquals(expectedOutput, output);

        System.out.println(output);

    }

    @Test
    public void testPrintUniqueContacts() throws Exception {
        System.out.println("testPrintUniqueContacts");

        AddressBook secondAddressBook = createSecondAddressBook();
        addressBookService.addAddressBook(bookCase, secondAddressBook);

        String expectedOutput = "Address Book List\n" +  "[Name: James, PhoneNumber: 1234567]\n" + "[Name: Mark, PhoneNumber: 2345678]\n"
                + "[Name: Chris, PhoneNumber: 1234567]\n" +"[Name: Troy, PhoneNumber: 2345678]\n";

        String output = addressBookService.printUniqueContacts(bookCase.getAddressBooks());

        Assert.assertEquals(expectedOutput, output);
        System.out.println(output);
    }

    private BookCase initAddressBookCase() {

        BookCase bookCase = new BookCase();

        Contact james = new Contact("James", "1234567");
        Contact mark = new Contact("Mark", "2345678");

        AddressBook firstAddressBook = new AddressBook(FIRST_ADDRESS_BOOK_ID);
        firstAddressBook.getContacts().add(james);
        firstAddressBook.getContacts().add(mark);

        bookCase.getAddressBooks().add(firstAddressBook);

        return bookCase;
    }


    private AddressBook createSecondAddressBook() {
        Contact chris = new Contact("Chris", "1234567");
        Contact troy = new Contact("Troy", "2345678");
        Contact mark = new Contact("Mark", "2345678");

        AddressBook secondAddressBook = new AddressBook(2);
        secondAddressBook.getContacts().add(chris);
        secondAddressBook.getContacts().add(troy);
        secondAddressBook.getContacts().add(mark);

        return secondAddressBook;
    }

}