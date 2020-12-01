package com.eduardnow.acl.repositories;

import com.eduardnow.acl.entitites.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
}
