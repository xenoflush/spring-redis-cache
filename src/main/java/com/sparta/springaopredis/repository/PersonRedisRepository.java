package com.sparta.springaopredis.repository;

import com.sparta.springaopredis.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<Person, String> {
}