package com.swsa.exception;

    public class AddressNotFoundException extends RuntimeException {
        public AddressNotFoundException(Long id) {
            super("Address not found with id: " + id);
        }
    }

