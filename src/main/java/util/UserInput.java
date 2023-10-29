package util;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    private UserInput() {}


    public static int inputMoveCount() {
        String userInput = readLine();
        return numValidation(userInput);
    }

    public static int numValidation(String target) throws IllegalArgumentException{
        try {
            return Integer.parseInt(target);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

}
