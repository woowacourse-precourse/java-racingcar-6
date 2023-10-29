package util;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    private UserInput() {}


    public static int inputMoveCount() {
        String userInput = readLine();
        return numValidation(userInput);
    }

}
