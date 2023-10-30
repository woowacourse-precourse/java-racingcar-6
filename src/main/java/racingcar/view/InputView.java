package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.domain.ErrorMessage.*;

public class InputView {
    private InputView() {}

    public static List<String> readCarNameList() {
        String input = Console.readLine();
        checkCarNameInputData(input);

        return Arrays.asList(input.split(","));
    }

    private static void checkCarNameInputData(String input) {
        InputValidation.emptyInputValidation(input);
        InputValidation.checkBlankCarName(input);
        InputValidation.checkLastCarNameValidation(input);
        InputValidation.checkCarNameRangeValidation(input);
    }

    public static int readProgressCount() {
        String input = Console.readLine();
        checkProgressCountInputData(input);

        return Integer.parseInt(input);
    }

    private static void checkProgressCountInputData(String input) {
        InputValidation.emptyInputValidation(input);
        InputValidation.convertNumberValidation(input);
        InputValidation.checkProgressCountMinValidation(input);
        InputValidation.checkProgressCountMaxValueValidation(input);
    }

    private static class InputValidation {
        private static final int MAX_VALUE = 20000;

        private InputValidation() {}

        private static void emptyInputValidation(String input) {
            if (input.length() == 0) {
                throw new IllegalArgumentException(EMPTY_INPUT_ERROR.getMessage());
            }
        }

        private static void checkBlankCarName(String input) {
            String[] split = input.split(",");
            long count = Arrays.stream(split)
                    .filter(name -> name.length() == 0)
                    .count();

            if (count > 0) {
                throw new IllegalArgumentException(BLANK_INPUT_ERROR.getMessage());
            }
        }

        private static void checkLastCarNameValidation(String input) {
            if (input.charAt(input.length()-1) == ',') {
                throw new IllegalArgumentException(LAST_CAR_NAME_ERROR.getMessage());
            }
        }

        private static void checkCarNameRangeValidation(String input) {
            String[] split = input.split(",");
            long overRangeNameCount = Arrays.stream(split)
                    .filter(name -> name.length() > 5)
                    .count();

            if (overRangeNameCount > 0) {
                throw new IllegalArgumentException(CAR_NAME_RANGE_ERROR.getMessage());
            }
        }

        private static void convertNumberValidation(String input) {
            for (int i=0; i<input.length(); i++) {
                char checkData = input.charAt(i);
                if (checkData < '0' || checkData > '9') {
                    throw new IllegalArgumentException(CONVERT_NUMBER_ERROR.getMessage());
                }
            }
        }

        private static void checkProgressCountMinValidation(String input) {
            long inputNumber = Long.parseLong(input);
            if (inputNumber < 1) {
                throw new IllegalArgumentException(LESS_THEN_ONE_ERROR.getMessage());
            }
        }

        private static void checkProgressCountMaxValueValidation(String input) {
            long inputNumber = Long.parseLong(input);
            if (inputNumber > MAX_VALUE) {
                throw new IllegalArgumentException(GREATER_THEN_MAX_VALUE_ERROR.getGreaterMaxValueThen(MAX_VALUE));
            }
        }
    }
}
