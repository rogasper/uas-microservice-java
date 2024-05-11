package com.k3519074.multipicationserver1.service;


import com.k3519074.multipicationserver1.dto.InputDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("service1")
public class MultipicationService {
    public Double calculate(InputDto inputDto){return inputDto.getA() * inputDto.getB();}
}
