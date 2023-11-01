package racingcar;

public class RaceInfoValidator {


    public static void checkCarNameLength(String[] input) throws IllegalArgumentException {
        for (String str : input) {
            if (str.length() > Constants.NAME_LENGTH_MAX) {
                throw new IllegalArgumentException(Constants.EXCEED_NAME_LENGTH);
            }
        }

    }

    public static void hasNoName(String[] input) throws  IllegalArgumentException{
        for (String str : input) {
            if (str.isBlank()) {
                throw new IllegalArgumentException(Constants.EMPTY_CAR_NAME);
            }
        }
    }

//    public static void hasDuplicateCarName(String[] input) throws IllegalArgumentException {
//
//    }g


    public static void hasMultipleCars(String[] input) throws IllegalArgumentException {
        if (input.length <= 1) {
            throw new IllegalArgumentException(Constants.CAR_COUNT_INSUFFICIENT);
        }
    }



    public static void checkAttemptCount(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.INVALID_ATTEMPT_COUNT);
        }

        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException(Constants.INVALID_ATTEMPT_COUNT);
        }
    }
}
