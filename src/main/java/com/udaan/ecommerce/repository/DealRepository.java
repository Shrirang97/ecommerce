package com.udaan.ecommerce.repository;

import com.udaan.ecommerce.model.Deal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends CrudRepository<Deal, Integer> {
}
