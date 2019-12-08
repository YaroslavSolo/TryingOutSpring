package com.demo.tacocloud.services;

import org.springframework.data.repository.CrudRepository;
import com.demo.tacocloud.entities.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
