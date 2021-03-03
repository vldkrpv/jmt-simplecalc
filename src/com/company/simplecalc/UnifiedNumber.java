package com.company.simplecalc;

public class UnifiedNumber {
    private final int number;
    private final NumberType type;

    public UnifiedNumber(int number, NumberType type) {
        this.number = number;
        this.type = type;
    }

    public static UnifiedNumber valueOf(String s) {
        if (s == null || s.isBlank()) {
            throw new NumberFormatException("Empty argument");
        }
        //may be it's roman
        String[] symbols = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int value = 0;
        for (; value < symbols.length; value++) {
            if (symbols[value].equals(s)) {
                return new UnifiedNumber(value + 1, NumberType.ROMAN);
            }
        }
        //it's not roman, try normal
        value = Integer.parseInt(s);
        if (value > 0 && value < 10) {
            return new UnifiedNumber(value, NumberType.DECIMAL);
        }
        throw new NumberFormatException("Wrong argument");
    }

    @Override
    public String toString() {
        if (NumberType.DECIMAL.equals(type)) {
            return String.valueOf(number);
        } else {
            int num = this.getNumber();
            String[] symbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
            StringBuilder roman = new StringBuilder();
            for (int i = 0; i < symbols.length; i++) {
                while (num >= values[i]) {
                    roman.append(symbols[i]);
                    num -= values[i];
                }
            }
            return roman.toString();
        }
    }

    public NumberType getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }
}
