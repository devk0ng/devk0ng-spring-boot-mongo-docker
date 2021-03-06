package com.devkong.api.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepository extends MongoRepository<Customer, Long> {

}
