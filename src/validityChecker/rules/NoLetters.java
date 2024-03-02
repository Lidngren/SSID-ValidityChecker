package src.validityChecker.rules;

import src.validityChecker.ValidityCheck;

public class NoLetters extends ValidityCheck {

    public NoLetters() {
        super("Contains no letters");
    }

    public boolean parse(String input) {
        String regex = "[0-9\\-/@#$%^&_+=()]+";
        return input.matches(regex);
    }

}
