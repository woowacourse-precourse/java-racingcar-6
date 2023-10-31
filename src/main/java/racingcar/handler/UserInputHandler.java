package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInputHandler {

    public static List<String> getNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        return validateUserInput(userInput);
    }

    private static List<String> validateUserInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        List<String> names = splitNames(userInput);
        for (String name : names) {
            validateName(name);
        }
        return names;
    }

    private static List<String> splitNames(String input) {
       return null;
    }

    private static void validateName(String name) {
        String trimmedName = name.trim();
    }
}

