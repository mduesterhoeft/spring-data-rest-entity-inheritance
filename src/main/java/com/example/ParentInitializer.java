package com.example;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ParentInitializer implements ApplicationRunner {

    private final ParentRepository parentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createStringValue();

        createDecimalValue();
    }

    private void createDecimalValue() {
        Parent parent = new Parent();
        DecimalValue decimalValue = new DecimalValue();
        decimalValue.setValue(BigDecimal.TEN);
        parent.setValueHolder(decimalValue);

        parentRepository.saveAndFlush(parent);
    }

    private void createStringValue() {
        Parent parent = new Parent();
        StringValue stringValue = new StringValue();
        stringValue.setValue("some");
        parent.setValueHolder(stringValue);

        parentRepository.saveAndFlush(parent);
    }
}
