package com.restapi.test_rest_api.dao;

import com.restapi.test_rest_api.model.person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PersonDataAccessService implements persondao {

    private static List<person> DB = new ArrayList<>();

    @Override
    public int addPerson(UUID id, person person) {
        DB.add(new person(id, person.getName()));
        return 1;
    }

    @Override
    public List<person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updatePerson(UUID id, person update) {
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<person> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }
}
