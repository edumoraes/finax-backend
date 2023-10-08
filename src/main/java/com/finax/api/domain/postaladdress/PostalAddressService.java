package com.finax.api.domain.postaladdress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostalAddressService {

    @Autowired
    private PostalAddressRepository repository;

    public PostalAddress create(PostalAddressDTO data) {
        return repository.save(new PostalAddress(data));
    }
}
