package src.validityChecker.rules;

import src.validityChecker.ValidityCheck;

public class ValidControlNumber extends ValidityCheck {

    public ValidControlNumber() {
        super("Valid control number");
    }

    public boolean parse(String input) {
        String temp = input.replace("-", "").replace("+", "");
        int[] digits = new int[temp.length()];
        int startIndex = temp.length() == 10 ? 0 : 2;

        for (int i = 0; i < temp.length(); i++) {
            digits[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
        }

        int result = 0;
        for (int i = startIndex; i < digits.length-1; i++) {
            int multiplier = i%2 == 0 ? 2 : 1;
            int sum = digits[i] * multiplier;
            if (sum > 10) {
                sum = 1 + (sum-10);
            }
            result += sum;
        }
        result = (10 - (result % 10)) % 10;

        return result == digits[digits.length-1];
    }

}