package com.exchange.rate.exchrate.repo;

import com.exchange.rate.exchrate.enteties.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeRepo extends JpaRepository<Code, Integer> {

    @Override
    Optional<Code> findById(Integer integer);

    Optional<Code> findByCode(Integer code);

    Optional<Code> findByName(String name);

}
