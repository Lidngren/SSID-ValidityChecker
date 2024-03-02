package src.validityChecker.rules;

import src.validityChecker.ValidityCheck;

public class ValidLength extends ValidityCheck {

    public ValidLength() {
        super("Valid length");
    }

    public boolean parse(String input) {
        String temp = formatInput(input);
        return (temp.length() == 10 || temp.length() == 12);
    }

}
