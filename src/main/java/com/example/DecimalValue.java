package com.example;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("D")
@Getter
@Setter
public class DecimalValue extends Value {

    @Column(name = "DECIMAL_VALUE")
    private BigDecimal value;

    public String getType() {
        return "DECIMAL";
    }
}
