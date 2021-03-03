package com.company.simplecalc;

public class Expression {
    private UnifiedNumber a;
    private UnifiedNumber b;
    private String operation;

    public Expression(String s) {
        parse(s);
    }

    public UnifiedNumber evaluate() {
        UnifiedNumber result = null;
        switch (operation) {
            case "+":
                result = new UnifiedNumber(a.getNumber() + b.getNumber(), a.getType());
                break;
            case "-":
                result = new UnifiedNumber(a.getNumber() - b.getNumber(), a.getType());
                break;
            case "/":
                result = new UnifiedNumber(a.getNumber() / b.getNumber(), a.getType());
                break;
            case "*":
                result = new UnifiedNumber(a.getNumber() * b.getNumber(), a.getType());
                break;
            default:
                break;
        }
        return result;
    }

    private void parse(String s) throws IllegalArgumentException {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Empty input");
        }
        String[] args = s.split("\\s");
        if (args.length != 3) {
            throw new IllegalArgumentException("Wrong input string");
        }
        if (!args[1].matches("[+-/*]")) {
            throw new IllegalArgumentException("Wrong operation");
        }
        operation = args[1];
        a = UnifiedNumber.valueOf(args[0]);
        b = UnifiedNumber.valueOf(args[2]);
        if (!a.getType().equals(b.getType())) {
            throw new IllegalArgumentException("Arguments types mismatch");
        }
    }
}
