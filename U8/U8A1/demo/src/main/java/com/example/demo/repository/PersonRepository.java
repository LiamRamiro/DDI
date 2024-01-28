package com.example.demo.repository;

import com.example.demo.dto.PersonDTO;
public interface PersonRepository {

	void persist(PersonDTO personDTO);

}
