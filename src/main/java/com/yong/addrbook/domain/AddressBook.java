package com.yong.addrbook.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongliu on 30/7/18.
 */
public class AddressBook {

    private int id;
    List<Contact> contacts = new ArrayList<>();

    public AddressBook() {
    }

    public AddressBook(int id) {
        this.id = id;
    }

    public AddressBook(int id, List<Contact> contacts) {
        this.id = id;
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "id=" + id +
                ", contacts=" + contacts +
                '}';
    }
}
