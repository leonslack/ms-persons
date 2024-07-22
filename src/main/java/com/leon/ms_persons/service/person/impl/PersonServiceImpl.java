package com.leon.ms_persons.service.person.impl;

import com.leon.ms_persons.domain.Person;
import com.leon.ms_persons.exception.EntityNotFoundException;
import com.leon.ms_persons.repository.PersonRepository;
import com.leon.ms_persons.service.person.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Page<Person> getAllPersons(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person updatePerson(Long id, Person updatedPerson) {
        Optional<Person> existingPersonOptional = getPersonById(id);
        if(existingPersonOptional.isEmpty()) {
            throw new EntityNotFoundException("Person not found with id " + updatedPerson.getId());
        }

        Person existingPerson = existingPersonOptional.get();
        existingPerson.setName(updatedPerson.getName());
        existingPerson.setGender(updatedPerson.getGender());
        existingPerson.setBirthdate(updatedPerson.getBirthdate());
        existingPerson.setIdentification(updatedPerson.getIdentification());
        existingPerson.setAddress(updatedPerson.getAddress());
        existingPerson.setPhoneNumber(updatedPerson.getPhoneNumber());
        return personRepository.save(existingPerson);
    }
}
