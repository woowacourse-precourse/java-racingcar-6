package racingcar.domain;

import racingcar.exception.UserRoundNumberInputException;

public class UserInputRoundNumber {
    private UserRoundNumberInputException userRoundNumberInputException;

    private static int stringToInt(String userInput) {
        return Integer.parseInt(userInput);
    }

    public int createRoundNumber(String userInput) {
        userRoundNumberInputException = new UserRoundNumberInputException(userInput);
        int roundNum = stringToInt(userInput);
        return roundNum;
    }
}
