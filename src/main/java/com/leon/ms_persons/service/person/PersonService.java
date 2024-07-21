package com.leon.ms_persons.service.person;

import com.leon.ms_persons.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonService {
    Person savePerson(Person persona);
    Page<Person> getAllPersons(Pageable pageable);
    Optional<Person> getPersonById(Long id);
    void deletePerson(Long id);
    Person updatePerson(Long id, Person person);
}
