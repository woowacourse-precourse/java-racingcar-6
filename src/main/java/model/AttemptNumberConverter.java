package model;

import util.AttemptValidator;

public class AttemptNumberConverter {
    private int attemptNumber;

    public static int convertStringToInteger(String attemptNumber) {
        AttemptValidator.checkValidAttemptNumber(attemptNumber);
        return Integer.parseInt(attemptNumber);
    }
}
