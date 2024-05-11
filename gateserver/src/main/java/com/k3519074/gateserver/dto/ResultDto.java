package com.k3519074.gateserver.dto;

public class ResultDto {
    private Integer a;
    private Integer b;
    private Character operation;
    private Integer result;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Character getOperation() {
        return operation;
    }

    public void setOperation(Character operation) {
        this.operation = operation;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
