package com.example;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Parent {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Getter
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Value valueHolder;

}
