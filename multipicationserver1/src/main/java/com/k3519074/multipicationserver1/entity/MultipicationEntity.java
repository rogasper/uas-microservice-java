package com.k3519074.multipicationserver1.entity;

import javax.persistence.*;

@Entity
@Table(name = "db_multipication")
public class MultipicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "a")
    private Double a;

    @Column(name = "b")
    private Double b;

    @Column(name = "result")
    private Double result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
