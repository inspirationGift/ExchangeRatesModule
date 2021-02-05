package com.exchange.rate.exchrate.service;

import com.exchange.rate.exchrate.enteties.Code;
import com.exchange.rate.exchrate.repo.CodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;

@Service
public class CodesService {
    private final CodeRepo codesRepository;

    public CodesService(CodeRepo codesRepository) {
        this.codesRepository = codesRepository;
    }

    public String getCurrencyNameByCode(Integer code) {
        Code name = codesRepository.findByCode(code).orElse(null);
        return String.valueOf(name);
    }

}
