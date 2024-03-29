package src.validityChecker.rules;

import src.validityChecker.ValidityCheck;

public class ValidControlNumber extends ValidityCheck {

    public ValidControlNumber() {
        super("Valid control number");
    }

    public boolean parse(String input) {
        String temp = formatInput(input);
        int[] digits = new int[temp.length()];
        int startIndex = temp.length() == 10 ? 0 : 2;

        for (int i = 0; i < temp.length(); i++) {
            digits[i] = getIntAt(temp, i);
        }

        /*
            Using Luhns-algorithm to validate the control digit at the end of the number.
            For more info see: https://en.wikipedia.org/wiki/Luhn_algorithm
         */
        int result = 0;
        for (int i = startIndex; i < digits.length-1; i++) {
            int multiplier = i%2 == 0 ? 2 : 1;
            int sum = digits[i] * multiplier;
            if (sum > 9) {
                sum = 1 + (sum-10);
            }
            result += sum;
        }
        result = (10 - (result % 10)) % 10;

        return result == digits[digits.length-1];
    }

}