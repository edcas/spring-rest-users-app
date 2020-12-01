package com.eduardnow.acl.repositories;

import com.eduardnow.acl.entitites.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
