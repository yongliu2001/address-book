package com.yong.addrbook.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongliu on 30/7/18.
 */
public class BookCase {

    private List<AddressBook> addressBooks = new ArrayList<>();

    public BookCase() {
    }

    public BookCase(List<AddressBook> addressBooks) {
        this.addressBooks = addressBooks;
    }

    public List<AddressBook> getAddressBooks() {
        return addressBooks;
    }

    @Override
    public String toString() {
        return "BookCase{" +
                "addressBooks=" + addressBooks +
                '}';
    }
}
