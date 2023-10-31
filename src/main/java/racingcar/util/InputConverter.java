package racingcar.util;

public class InputConverter {
    private static int MINMUM = 0;
    public static int covertTimes(String times) {
        if (!validateTimes(times)) throw new IllegalArgumentException(ExceptionMessages.NUMBER_FORMAT_EXCEPTION);
        return Integer.parseInt(times);
    }

    private static boolean validateTimes(String times) {
        return checkInteger(times)&&checkMin(times);
    }

    private static boolean checkMin(String times) {
        return Integer.parseInt(times)>MINMUM;
    }

    private static boolean checkInteger(String times) {
        return times.matches(Constants.NUMBER_MATCH_REGEX);
    }
}
