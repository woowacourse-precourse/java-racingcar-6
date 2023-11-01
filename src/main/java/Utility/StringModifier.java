package Utility;

import Validator.StringValidator;

public class StringModifier {
    private static StringModifier stringModifier = null;

    private StringModifier() {

    }

    public static StringModifier getInstance() {
        if (StringModifier.stringModifier == null) {
            return StringModifier.stringModifier = new StringModifier();
        }

        return StringModifier.stringModifier;
    }


    public String[] separateCarNamesBySeparator(String input, String delimeter) {
        return input.split(delimeter);
    }
}
