package util;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    private UserInput() {}


    public static int inputMoveCount() {
        String userInput = readLine();
        return numValidation(userInput);
    }

    private static int numValidation(String target) throws IllegalArgumentException{
        try {
            return Integer.parseInt(target);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static String[] inputCarNames() {
        String userInput = readLine();
        return carNamesSplitValidation(userInput);
    }

    private static String[] carNamesSplitValidation(String target) throws IllegalArgumentException {
        validateNotNullOrEmpty(target);

        String[] names = target.split(",");
        for (String name : names) {
            validateNameLength(name);
        }
        return names;
    }

    private static void validateNotNullOrEmpty(String target) {
        if (target == null || target.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어 있습니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다: " + name);
        }
    }
}
