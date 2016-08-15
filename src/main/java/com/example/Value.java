package com.example;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;

@Entity
@Inheritance(strategy= SINGLE_TABLE)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
        @Type(name="DECIMAL", value=DecimalValue.class),
        @Type(name="STRING", value=StringValue.class)})
public class Value {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Getter
    private Long id;
}
