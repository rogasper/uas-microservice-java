package com.k3519074.divisionservice.service;

import com.k3519074.divisionservice.dto.InputDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("service1")
public class DivisionService {
    public Double calculate(InputDto inputDto) { return inputDto.getA()/ inputDto.getB();}
}
