package com.finax.api.domain.postaladdress;

public record PostalAddressDTO(
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String country,
        String zipCode
) {
    public PostalAddressDTO(PostalAddress address) {
        this(address.getStreet(), address.getNumber(), address.getComplement(), address.getNeighborhood(), address.getCity(), address.getState(), address.getCountry(), address.getZipCode());
    }
}
