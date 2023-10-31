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
    }

    public static void handleTryNumberException(String tryNumber) throws IllegalArgumentException {
        throwIfInputCannotParsableAsInt(tryNumber);
    }

    public static String inputCarNames() {
        return Console.readLine();
    }

    public static String inputTryNumber() {
        return Console.readLine();
    }

    public static Stream<String> splitNamesAsStream(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter));
    }

    public static void throwIfNameTooLong(String input) {
        if (input.length() > Constant.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                String.format("최대 이름길이 %d를 넘는 이름입니다.", Constant.MAX_NAME_LENGTH)
            );
        }
    }

    public static void throwIfInputCannotParsableAsInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                "횟수가 정수 값이 아닙니다."
            );
        }
    }
}
