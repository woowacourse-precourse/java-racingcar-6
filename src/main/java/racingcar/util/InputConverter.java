package racingcar.util;

public class InputConverter {

    public static int covertTimes(String times) {
        if (!validateTimes(times)) throw new IllegalArgumentException(ExceptionMessages.NUMBER_FORMAT_EXCEPTION);
        return Integer.parseInt(times);
    }

    private static boolean validateTimes(String times) {
        return times.matches(Constants.NUMBER_MATCH_REGEX);
    }
}
