package src.validityChecker;

public abstract class ValidityCheck {
    private String ruleName = " ";

    public ValidityCheck(String ruleName) {
        this.ruleName = ruleName;
    }

    public abstract boolean parse(String input);

    public String resultToString(boolean result) {
        String res = this.ruleName;
        if(result) {
            res += ": OK";
        } else {
            res += ": FAIL";
        }
        return res;
    }

    protected String formatInput(String input) {
        return input.replace("-", "").replace("+", "");
    }

    protected int getIntAt(String input, int index) {
        return Integer.parseInt(String.valueOf(input.charAt(index)));
    }
}
