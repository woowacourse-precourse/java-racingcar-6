package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.stream.Stream;

public class Util {
    public static void print(MessageType messageType) {
        System.out.println(messageType.getDetail());
    }

    public static void print(MessageType messageType, String addition) {
        System.out.println(messageType.getDetail() + addition);
    }

    public static void handleCarNamesException(String carNames) throws IllegalArgumentException {
        splitNamesAsStream(carNames, Constant.NAME_DELIMITER)
        .forEach(Util::throwIfNameTooLong);
        throwIfNameDuplicate(carNames);
    }

    public static void handleTryNumberException(String tryNumber) throws IllegalArgumentException {
        throwIfInputCannotParsableAsInt(tryNumber);
    }

    public static void throwIfNameTooLong(String input) {
        if (input.length() > Constant.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                MessageType.CAR_NAMES_LENGTH_ERR.getDetail()
            );
        }
    }

    public static void throwIfNameDuplicate(String input) {
        String[] split = splitNames(input, Constant.NAME_DELIMITER);
        int nameCount = split.length;

        if (Arrays.stream(split).distinct().count() != nameCount) {
            throw new IllegalArgumentException(
                MessageType.CAR_NAMES_DUPLICATE_ERR.getDetail()
            );
        }
    }

    public static void throwIfInputCannotParsableAsInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                MessageType.TRY_NUMBER_INPUT_ERR.getDetail()
            );
        }
    }

    public static Stream<String> splitNamesAsStream(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter));
    }

    public static String[] splitNames(String input, String delimiter) {
        return input.split(delimiter);
    }

    public static String getUserInput() {
        return Console.readLine();
    }
}
