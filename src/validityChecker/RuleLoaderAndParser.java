package src.validityChecker;

import src.validityChecker.ValidityCheck;
import src.validityChecker.rules.*;

import java.util.ArrayList;

public class RuleLoaderAndParser {

    public ArrayList<ValidityCheck> loadRules() {
        ArrayList<ValidityCheck> rules = new ArrayList<>();
        rules.add(new NoLetters());
        rules.add(new ValidLength());
        rules.add(new ValidDate());
        rules.add(new ValidControlNumber());

        return rules;
    }

    public boolean parseRules(ArrayList<ValidityCheck> rules, String input) {
        int faults = 0;

        for (ValidityCheck rule : rules) {
            boolean result = rule.parse(input);
            System.out.println(rule.resultToString(result));
            if(!result) {
                faults++;
            }
        }

        if(faults > 0) {
            System.out.println("\n  Invalid SSID, refer to above log whats at fault.");
            return false;
        }

        System.out.println("\n  Valid SSID");
        return true;
    }
}
