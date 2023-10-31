package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class UserInputHandler {
    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> getNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        return validateUserInput(userInput);
    }

    public static List<String> validateUserInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        List<String> names = splitNames(userInput);

        checkDuplicateName(names);

        for (String name : names) {
            validateName(name);
        }
        return names;
    }

    private static List<String> splitNames(String input) {
        return Arrays.asList(input.split(","));
    }

    public static void checkDuplicateName(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);

        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static void validateName(String name) {
        String trimmedName = name.trim();
        if (trimmedName.length() == 0 || trimmedName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
    }

    public static int getAttemptCountFromUser() {
        System.out.println("시도할 회수는 몇회인가요?");
        String countInput = Console.readLine();
        return validateAttemptCount(countInput);
    }

    public static int validateAttemptCount(String countInput) {
        if (countInput == null || countInput.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
        }
        try {
            int attemptCount = Integer.parseInt(countInput);
            if (attemptCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력할 수 있습니다.");
        }
    }
}

