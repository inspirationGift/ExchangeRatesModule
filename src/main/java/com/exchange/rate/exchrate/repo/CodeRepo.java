package com.exchange.rate.exchrate.repo;

import com.exchange.rate.exchrate.enteties.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepo extends JpaRepository<Code, Integer> {

    Code findByCode(String code);

    Code findByName(String name);

}
