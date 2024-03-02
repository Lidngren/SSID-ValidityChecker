package src;

import src.validityChecker.RuleLoaderAndParser;

public class Main {

    public static void main(String[] args) {
        RuleLoaderAndParser loadAndParse = new RuleLoaderAndParser();

        loadAndParse.parseRules(loadAndParse.loadRules(), "190910799824");
    }
}
