package src.validityChecker.rules;

import src.validityChecker.ValidityCheck;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class ValidDate extends ValidityCheck {

    public ValidDate() {
        super("Valid date");
    }

    public boolean parse(String input) {
        String formatted = formatInput(input);
        int startIndex = formatted.length() == 10 ? 0 : 2;
        String stripped = formatted.substring(startIndex, formatted.length()-4);

        int month = Integer.parseInt(formatted.substring(startIndex+2,startIndex+4));
        int day = Integer.parseInt(formatted.substring(startIndex+4,startIndex+6));

        //If the month is 20 or higher it's a Swedish organisation number.
        if (month > 19) {
            return true;
        }

        //Special check for february.
        if(month == 2) {
            if(day > 28) {
                if(day < 61 || day > 88) {
                    return false;
                }
            }
        }

        try {
            LocalDate.parse(stripped, DateTimeFormatter.ofPattern("uuMMdd").withResolverStyle(ResolverStyle.STRICT));

        } catch (DateTimeParseException e) {
            //If the date have been increased by 60 it's a valid temporary Swedish SSID.
            if(day < 61 || day > 91) {
                return false;
            } else if(month > 12) {
                return false;
            }
        }

        return true;
    }

}
