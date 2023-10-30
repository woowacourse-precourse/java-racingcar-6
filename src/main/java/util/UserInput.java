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
}
