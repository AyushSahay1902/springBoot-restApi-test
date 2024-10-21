package com.restapi.test_rest_api.service;

import com.restapi.test_rest_api.dao.persondao;
import com.restapi.test_rest_api.model.person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final persondao personDao;

    @Autowired
    public PersonService(persondao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(person person) {
        return personDao.addPerson(person);
    }

    public List<person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int updatePerson(UUID id, person newPerson) {
        return personDao.updatePerson(id, newPerson);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePerson(id);
    }
}
