package com.swsa.service;


import com.swsa.model.Address;
import com.swsa.repository.AddressRepository;

import java.sql.SQLException;
import java.util.List;

public class AddressService {

    private AddressRepository addressRepository = new AddressRepository();

    public boolean insertAddress(Address address) throws SQLException {
        if (addressRepository.insertAddress(address)) {
            System.out.println("Address inserted successfully!");
        } else {
            System.out.println("Failed to insert Address.");
            return false;
        }
        return true;
    }
    public List<Address> retrieveAddress() throws SQLException {
        System.out.println("Inside retrieve address service layer");
        return addressRepository.retrieveAddress();
    }
}
