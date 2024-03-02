package src.validityChecker.rules;

import src.validityChecker.ValidityCheck;

public class CorrectLength extends ValidityCheck {

    public CorrectLength() {
        super("Correct length");
    }

    public boolean parse(String input) {
        String temp = input.replace("-", "").replace("+", "");
        return (temp.length() == 10 || temp.length() == 12);
    }

}
