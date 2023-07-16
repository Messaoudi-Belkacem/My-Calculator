package com.example.mycalculator;

public class Operation {
    private CharSequence operation;
    private CharSequence result;

    public CharSequence getOperation() {
        return operation;
    }

    public void setOperation(CharSequence operation) {
        this.operation = operation;
    }

    public CharSequence getResult() {
        return result;
    }

    public void setResult(CharSequence result) {
        this.result = result;
    }

    public Operation(CharSequence operation, CharSequence result) {
        this.operation = operation;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operation='" + operation + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
