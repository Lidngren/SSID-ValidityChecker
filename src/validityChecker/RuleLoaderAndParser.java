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
            System.out.println("\n  Invalid, refer to above log whats at fault.");
            return false;
        }

        defineIDType(input);
        return true;
    }

    private void defineIDType(String input) {
        String formatted = input.replace("-", "").replace("+","");
        int startIndex = formatted.length() == 10 ? 0 : 2;
        int month = Integer.parseInt(formatted.substring(startIndex+2,startIndex+4));
        int day = Integer.parseInt(formatted.substring(startIndex+4,startIndex+6));

        if(month > 19) {
            System.out.println("\n  Valid organisation number");
            return;
        }

        if(day > 60) {
            System.out.println("\n  Valid Swedish co-ordination number");
            return;
        }

        System.out.println("\n  Valid Swedish personal identity number");
    }
}
