package com.example.lab9;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ApplicationScoped
public class CalculationBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private double initialValue = 10.0;
    private double value;
    private double result;

    public void add() {
        result = initialValue + value;
    }

    public void subtract() {
        result = initialValue - value;
    }

    @Produces
    @Named("calculationValue")
    public double produceInitialValue() {
        return initialValue;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getResult() {
        return result;
    }
}
