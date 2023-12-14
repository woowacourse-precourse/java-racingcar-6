package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.global.exception.CustomException;
import racingcar.global.exception.ErrorMessage;
import racingcar.view.console.ConsoleReader;
import racingcar.view.console.ConsoleWriter;

public class InputView {
    private static final String CAR_NAMES_NOTICE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`를 출력한다.";
    public static final String CAR_NAMES_SEPARATOR = ",";
    public static final String TRY_COUNT_NOTICE = "시도할 회수는 몇회인가요?";

    public List<String> readCarNames() {
        ConsoleWriter.printlnMessage(CAR_NAMES_NOTICE);
        return Validator.validateCarNames(ConsoleReader.enterMessage());
    }

    public int readTryCount() {
        ConsoleWriter.printlnMessage(TRY_COUNT_NOTICE);
        return Validator.validateNumber(ConsoleReader.enterMessage());
    }

    private static class Validator {
        private static List<String> validateCarNames(String message) {
            List<String> cars = parseStringToList(message, CAR_NAMES_SEPARATOR);
            validateDuplicated(cars);
            return cars;
        }

        private static void validateDuplicated(List<String> items) {
            if (hasDuplicated(items)) {
                throw CustomException.from(ErrorMessage.DUPLICATED_CAR_ERROR);
            }
        }

        private static boolean hasDuplicated(List<String> items) {
            return items.size() != calculateUniqueCount(items);
        }

        private static int calculateUniqueCount(List<String> items) {
            return (int) items.stream()
                    .distinct()
                    .count();
        }

        private static List<String> parseStringToList(String message, String separator) {
            return Arrays.stream(split(message, separator)).toList();
        }

        private static String[] split(String message, String separator) {
            return message.split(separator, -1);
        }

        private static int validateNumber(String message) {
            if (isNotNumber(message)) {
                throw CustomException.from(ErrorMessage.INVALID_TRY_COUNT_ERROR);
            }
            return Integer.parseInt(message);
        }

        private static boolean isNotNumber(String str) {
            return !str.matches("^[1-9]+$");
        }
    }
}
