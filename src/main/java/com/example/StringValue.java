package com.example;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("S")
@Getter
@Setter
public class StringValue extends Value {

    @Column(name = "STRING_VALUE")
    private String value;

    public String getType() {
        return "STRING";
    }
}
