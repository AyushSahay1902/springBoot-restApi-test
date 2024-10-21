package com.restapi.test_rest_api.dao;

import com.restapi.test_rest_api.model.person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface persondao {
    int addPerson(UUID id, person person);

    default int addPerson(person person) {
        UUID id = UUID.randomUUID();
        return addPerson(id, person);
    }

    Optional<person> selectPersonById(UUID id);

    List<person> selectAllPeople();

    int updatePerson(UUID id, person person);

    int deletePerson(UUID id);
}
