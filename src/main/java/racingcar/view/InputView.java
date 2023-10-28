package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private InputView() {}

    public static List<String> readCarNameList() {
        String input = Console.readLine();
        checkCarNameInputData(input);

        return Arrays.asList(input.split(","));
    }

    private static void checkCarNameInputData(String input) {
        InputValidation.emptyInputValidation(input);
        InputValidation.checkLastCarName(input);
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
        private InputValidation() {}

        private static void emptyInputValidation(String input) {
            if (input.length() == 0) {
                throw new IllegalArgumentException("입력된 값이 없습니다.");
            }
        }

        private static void checkLastCarName(String input) {
            if (input.charAt(input.length()-1) == ',') {
                throw new IllegalArgumentException("입력된 마지막 자동차 이름에 오류가 있습니다.");
            }
        }

        private static void checkCarNameRangeValidation(String input) {
            String[] split = input.split(",");
            long overRangeNameCount = Arrays.stream(split)
                    .filter(name -> name.length() > 5)
                    .count();

            if (overRangeNameCount > 0) {
                throw new IllegalArgumentException("입력된 자동차 이름이 5글자를 넘었습니다.(이름은 5자 이하만 가능)");
            }
        }

        private static void convertNumberValidation(String input) {
            for (int i=0; i<input.length(); i++) {
                char checkData = input.charAt(i);
                if (checkData < '0' || checkData > '9') {
                    throw new IllegalArgumentException("입력된 값이 숫자 형태가 아닙니다.(0~9 사이의 값만 입력 가능)");
                }
            }
        }

        private static void checkProgressCountMinValidation(String input) {
            long inputNumber = Long.parseLong(input);
            if (inputNumber < 1) {
                throw new IllegalArgumentException("입력된 값이 1보다 작을 수 없습니다.");
            }
        }

        private static void checkProgressCountMaxValueValidation(String input) {
            long inputNumber = Long.parseLong(input);
            if (inputNumber > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("입력된 값이 " + Integer.MAX_VALUE + "보다 클 수 없습니다.");
            }
        }
    }
}
