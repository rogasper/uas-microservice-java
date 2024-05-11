package com.k3519074.divisionservice.controller;

import com.k3519074.divisionservice.dto.InputDto;
import com.k3519074.divisionservice.dto.OutputDto;
import com.k3519074.divisionservice.entity.DivisionEntity;
import com.k3519074.divisionservice.repository.DivisionRepository;
import com.k3519074.divisionservice.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DivisionController {
    @Autowired
    private DivisionService divisionService;

    @Autowired
    private DivisionRepository divisionRepository;

    public void inputToDatabase(OutputDto outputDto){
        DivisionEntity divisionDb = new DivisionEntity();
        divisionDb.setA(outputDto.getA());
        divisionDb.setB(outputDto.getB());
        divisionDb.setResult(outputDto.getResult());

        DivisionEntity divisionEntity = divisionRepository.save(divisionDb);
    }

    @PostMapping("/calc")
    public ResponseEntity<OutputDto> calculate(@RequestBody InputDto inputDto){
        OutputDto outputDto = new OutputDto();
        outputDto.setA(inputDto.getA());
        outputDto.setB(inputDto.getB());
        outputDto.setResult(divisionService.calculate(inputDto));
        inputToDatabase(outputDto);
        System.out.println("Input A: "+inputDto.getA()+" B:"+ inputDto.getB()+" Division Server Instance 1");
        return ResponseEntity.ok(outputDto);
    }
}
