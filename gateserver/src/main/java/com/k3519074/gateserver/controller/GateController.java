package com.k3519074.gateserver.controller;

import com.k3519074.gateserver.dto.ResultDto;
import com.k3519074.gateserver.dto.TransferDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;

@RestController
@RequestMapping("/api")
public class GateController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/{a}/{operator}/{b}")
    public ResponseEntity<ResultDto> calculateFunctionality(@PathVariable("a") Integer a, @PathVariable("operator") Character operator, @PathVariable("b") Integer b)
    {
        ServiceInstance serviceInstance;
        TransferDto transferDto = new TransferDto();
        transferDto.setA(a);
        transferDto.setB(b);
        switch (operator){
            case ':': serviceInstance = loadBalancerClient.choose("division-server"); break;
            case '*': serviceInstance = loadBalancerClient.choose("multipication-server"); break;
            default: serviceInstance = loadBalancerClient.choose("division-server"); break;
        }
        String selectedUrl = serviceInstance.getUri().toString();
        String completeUrl = selectedUrl+"/calc";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultDto> responseFromInstance = restTemplate.postForEntity(completeUrl, transferDto, ResultDto.class);
        ResultDto resultDto = responseFromInstance.getBody();
        resultDto.setOperation(operator);
        return ResponseEntity.ok(resultDto);
    }

}
