package com.k3519074.multipicationserver1.controller;

import com.k3519074.multipicationserver1.dto.InputDto;
import com.k3519074.multipicationserver1.dto.OutputDto;
import com.k3519074.multipicationserver1.entity.MultipicationEntity;
import com.k3519074.multipicationserver1.repository.MultipicationRepository;
import com.k3519074.multipicationserver1.service.MultipicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultipicationController {
    @Autowired
    private MultipicationService multipicationService;

    @Autowired
    private MultipicationRepository multipicationRepository;

    public void inputToDatabase(OutputDto outputDto){
        MultipicationEntity multiDb = new MultipicationEntity();
        multiDb.setA(outputDto.getA());
        multiDb.setB(outputDto.getB());
        multiDb.setResult(outputDto.getResult());

        MultipicationEntity multipicationEntity = multipicationRepository.save(multiDb);
    }

    @PostMapping("/calc")
    public ResponseEntity<OutputDto> calculate(@RequestBody InputDto inputDto){
        OutputDto outputDto = new OutputDto();
        outputDto.setA(inputDto.getA());
        outputDto.setB(inputDto.getB());
        outputDto.setResult(multipicationService.calculate(inputDto));
        inputToDatabase(outputDto);
        System.out.println("Input A: "+inputDto.getA()+" B:"+ inputDto.getB()+" Multipication Server Instance 2");
        return ResponseEntity.ok(outputDto);
    }
}
